package com.example.apextechnos

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.p2p.WifiP2pConfig
import android.net.wifi.p2p.WifiP2pDevice
import android.net.wifi.p2p.WifiP2pManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.*
import android.widget.Toast



class DiscoverPeersActivity : AppCompatActivity() {

    private val intentFilter = IntentFilter()
    private lateinit var channel: WifiP2pManager.Channel
    private lateinit var manager: WifiP2pManager
    var isWifiP2pEnabled = false
    private lateinit var receiver: WiFiDirectBroadcastReceiver
    private val peers = mutableListOf<WifiP2pDevice>()
    private val peerNames = mutableListOf<String>()
    private lateinit var peersListAdapter: ArrayAdapter<String>
    lateinit var chatIntent: Intent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover_peers)

        peersListAdapter =
            ArrayAdapter<String>(this@DiscoverPeersActivity, android.R.layout.simple_expandable_list_item_1, peerNames)

        val peersListView = findViewById<ListView>(R.id.peers_list_view);
        peersListView.adapter = peersListAdapter
        peersListView.setOnItemClickListener { parent, view, position, id ->
            connect(position)
            chatIntent = Intent(this@DiscoverPeersActivity, ChatActivity::class.java)
            chatIntent.putExtra("PEER", peers[position])
//            var channels = ArrayList<WifiP2pManager.Channel>()
//            channels.add(channel)
//            chatIntent.putExtra("CHANNEL", channels)
            startActivity(chatIntent)
        }
        // Indicates a change in the Wi-Fi P2P status.
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION)

        // Indicates a change in the list of available peers.
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION)

        // Indicates the state of Wi-Fi P2P connectivity has changed.
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION)

        // Indicates this device's details have changed.
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION)

        manager = getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager
        channel = manager.initialize(this, mainLooper, null)

        manager.discoverPeers(channel, object : WifiP2pManager.ActionListener {
            override fun onSuccess() {

            }

            override fun onFailure(reasonCode: Int) {
                Toast.makeText(applicationContext, "Error in initiating discovery", Toast.LENGTH_SHORT).show()
            }
        })
    }

    /** register the BroadcastReceiver with the intent values to be matched  */
    public override fun onResume() {
        super.onResume()

        val peerListListener = WifiP2pManager.PeerListListener { peerList ->
            val refreshedPeers = peerList.deviceList
            if (refreshedPeers != peers) {
                peers.clear()
                peers.addAll(refreshedPeers)
                peerNames.clear()
                for (peer in peers) {
                    peerNames.add(peer.deviceName)
                }
                peersListAdapter.notifyDataSetChanged()

                // Perform any other updates needed based on the new list of
                // peers connected to the Wi-Fi P2P network.
            }

            if (peers.isEmpty()) {
                Toast.makeText(applicationContext, "No devices Seems online", Toast.LENGTH_SHORT).show()
                return@PeerListListener
            }
        }
        receiver = WiFiDirectBroadcastReceiver(manager, channel, this, peerListListener)
        registerReceiver(receiver, intentFilter)


    }

    public override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

    fun connect(deviceNumber: Int) {

        val device = peers[deviceNumber]
        val config = WifiP2pConfig().apply {
            deviceAddress = device.deviceAddress
        }
        manager.connect(channel, config, object : WifiP2pManager.ActionListener {
            override fun onSuccess() {
            }

            override fun onFailure(reason: Int) {
                Toast.makeText(
                    this@DiscoverPeersActivity,
                    "Connect failed. Retry.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

//        manager.requestGroupInfo(channel) { group ->
//            val groupPassword = group.passphrase
//        }
    }
}
