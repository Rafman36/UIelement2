package com.example.UIELEMENTSUNIT6

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


val queuedList = ArrayList<String>()

val songsArray: Array<String> = arrayOf(
    "Best song ever",
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
    "Right now",
    "Heart shaker",
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
    "Like OOH-AAH",
    "Euphoria",
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
    "Mikrokosmos")

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsArray)
        val songsListView: ListView = findViewById<ListView>(R.id.songsListView)
        songsListView.adapter = adapter

        registerForContextMenu(songsListView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater =menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        return when(item.itemId){
            R.id.go_to_songs_act -> {
                startActivity(Intent(this, MainActivity::class.java))
                true
            }
            R.id.go_to_albums_act -> {
                startActivity(Intent(this, AlbumsActivity::class.java))
                true
            }
            R.id.add_to_queue_act -> {
                val intent = Intent(this, QueuedSongsActivity::class.java)
                intent.putStringArrayListExtra("queuedList", queuedList)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.song_item_menu, menu)
    }


    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterContextMenuInfo
        val position = info.position

        return when (item.itemId){
            R.id.add_to_queue -> {
                val info = item.getMenuInfo() as AdapterContextMenuInfo
                val index = info.position
                queuedList.add(songsArray[index])
            }
            else -> super.onContextItemSelected(item)
        }
    }


}










