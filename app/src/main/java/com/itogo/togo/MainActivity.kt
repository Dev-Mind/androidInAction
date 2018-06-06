package com.itogo.togo

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saveSpeaker.setOnClickListener {
            if(mainName.text.isNullOrEmpty()){
                Snackbar.make(it, "Nom est obligatoire", Snackbar.LENGTH_LONG)
                        .setAction("Erreur", null)
                        .show()
            }
            else{
                val speakerDao = AppDatabase.instance(this).speakerDao()
                val speaker = Speaker(mainName.text.toString(), mainCountry.text.toString())
                launch {
                    speakerDao.insert(speaker)
                    Snackbar.make(it, "You add ${speakerDao.all().size} speakers", Snackbar.LENGTH_LONG)
                            .setAction("Etat", null)

                            .show()
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuEmail -> {
                val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:guillaume@dev-mind.fr"))
                startActivity(intent)
                return true
            }
            R.id.menuGithub -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/itogoconf/itogo.org"))
                startActivity(intent)
                return true
            }
            R.id.menuSpeakerList -> {
                startActivity(Intent(this, SpeakerListActivity::class.java))
                return true
            }
        }
        return false
    }
}
