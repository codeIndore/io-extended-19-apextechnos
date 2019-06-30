package com.example.apextechnos

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO: Grab view and start DiscoverPeersActivity
        val discoverButtonView = findViewById<Button>(R.id.discover_button_view)
        discoverButtonView.setOnClickListener {
            startActivity(Intent(this@MainActivity, DiscoverPeersActivity::class.java))
        }

    }
}
