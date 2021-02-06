package com.example.UIELEMENTSUNIT6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class AlbumDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_details)
        var modalItems: Modal = intent.getSerializableExtra("data") as Modal;

        Log.e("name",modalItems.name.toString());
        val viewName = findViewById<TextView>(R.id.viewName)
        val viewImage = findViewById<ImageView>(R.id.viewImage)

        viewName.text=modalItems.name;
        var songsArray: Array<String> = arrayOf()

        if(modalItems.name.equals("image1")) {
                viewName.text = "One Direction"
                songsArray = arrayOf( "Best song ever",
                    "What makes you beautiful",
                    "You & I",
                    "Story of my life",
                    "Night Changes",
                    "Kiss you",
                    "Drag me down",
                    "Little things",
                    "Steal my girl",
                    "One thing",
                    "Olivia",
                    "They don't know about us",
                    "Over again",
                    "Right now",)
        }
        else if(modalItems.name.equals("image2")) {
            viewName.text = "Twice"
            songsArray = arrayOf(  "Heart shaker",
                "What is love?",
                "TT",
                "Cheer up",
                "More & more",
                "Yes or yes",
                "Fancy",
                "Feel special",
                "Cry for me",
                "Fanfare",
                "I can't stop me",
                "Like OOH-AAH"                    )
        }
        else if(modalItems.name.equals("image3")) {
            viewName.text = "BTS"
            songsArray = arrayOf( "Euphoria",
                "Save me",
                "Blood, sweat & tears",
                "Fake love",
                "Dynamite",
                "Boy in luv",
                "Boy with luv",
                "On",
                "Black swan",
                "Fire",
                "Spring day",
                "DNA",
                "I need U",
                "IDOL",
                "Mic Drop",
                "The truth untold",
                "Mikrokosmos"
            )
        }
        viewImage.setImageResource(modalItems.image!!);



        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsArray)
        val songs_list: ListView = findViewById<ListView>(R.id.songs_list)
        songs_list.adapter = adapter


    }
}