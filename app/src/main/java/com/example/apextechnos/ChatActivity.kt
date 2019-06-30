package com.example.apextechnos

import android.net.wifi.p2p.WifiP2pDevice
import android.net.wifi.p2p.WifiP2pManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.ImageView
import java.nio.channels.Channel


class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

//        val messageEditText = findViewById<EditText>(R.id.message_edit_text);
        val sendMessageButton = findViewById<ImageView>(R.id.send_icon_image_view);

        sendMessageButton.setOnClickListener {
//            val message = messageEditText.text;
//            val peer = intent.getSerializableExtra("PEER") as WifiP2pDevice
//            val channels = intent.getSerializableExtra("CHANNEL") as ArrayList<WifiP2pManager.Channel>
//            val channel = channels[0]
//            val c: Channel = channel as Channel
        }
    }
}
