package com.itogo.togo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class SpeakerAdapter(val speakers: List<Speaker>): RecyclerView.Adapter<SpeakerAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.speaker_item, parent, false))
    }

    override fun getItemCount(): Int = speakers.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val speaker = speakers[position]

        holder.apply {
            name.text = speaker.name
            country.text = speaker.country
        }
    }

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val name = view.findViewById(R.id.viewName) as TextView
        val country = view.findViewById(R.id.viewCountry) as TextView
    }
}