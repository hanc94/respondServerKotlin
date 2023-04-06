package com.example.testmenu


import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager



class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var sharedPreferences: SharedPreferences
    lateinit var text: TextView
    var status:Boolean=false

    //Override this method to inflate main menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    //Override this method to handle click on menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            //If settings menu item was selected
            R.id.settings -> {
                //Creates Intent object
                val intent = Intent()
                //Sets class for activity to launch
                intent.setClassName(this, "com.example.testmenu.SettingsActivity");
                //Launches acitivity
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Object to get preferences of App
        sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this@MainActivity)


        button = findViewById(R.id.button)
        text = findViewById(R.id.textView)


        button.setOnClickListener { view: View ->

            //Get value of "signature" preference
            val str = sharedPreferences.getString("signature", "abc")

            text.text=str
        }
    }
}
