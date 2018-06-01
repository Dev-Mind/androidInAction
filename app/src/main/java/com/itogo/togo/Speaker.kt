package com.itogo.togo

data class Speaker(val name: String, val country: String? = "Unknown")

class SpeakerService(){
    companion object {
        val speakers = mutableListOf(Speaker("Guillaume", "France"))
    }
}