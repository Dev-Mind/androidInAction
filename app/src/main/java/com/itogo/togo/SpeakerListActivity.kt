package com.itogo.togo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_speaker_list.*

class SpeakerListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speaker_list)

        speakerList.apply {
            val speakers = SpeakerService.speakers
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = SpeakerAdapter(speakers)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }
}
