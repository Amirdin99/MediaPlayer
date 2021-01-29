package com.example.mediaplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mp: MediaPlayer? = null

    private var currentSong = mutableListOf(R.raw.vyuga)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        controlSong(currentSong[0])
    }

    private fun controlSong(id: Int) {

        play.setOnClickListener {

            if (mp == null) {

                mp = MediaPlayer.create(this, id)
                Log.d("MainActivity", "duration: ${mp!!.duration / 1000} ")

                initializeSeekBar()

            }




            mp?.start()
            Log.d("MainActivity", "duration: ${mp!!.duration / 1000} seconds")
        }

        stop.setOnClickListener {

            if (mp !== null) mp?.pause()
            Log.d("MainActivity", "Paused at: ${mp!!.duration / 1000} seconds")

        }

        pause.setOnClickListener {

            if (mp !== null) {

                mp?.stop()
                mp?.reset()
                mp?.release()
                mp = null
            }
        }

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                if (fromUser) mp?.seekTo(progress)

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }

    private fun initializeSeekBar() {

        seekbar.max = mp!!.duration

        val handler = Handler()

        handler.postDelayed(object : Runnable {
            override fun run() {

                try {

                    seekbar.progress = mp!!.currentPosition
                    handler.postDelayed(this, 1000)
                } catch (e: Exception) {
                    seekbar.progress = 0
                }
            }
        }, 0)
    }
}