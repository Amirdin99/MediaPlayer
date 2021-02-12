package com.example.mediaplayer.adapter

import android.media.AudioManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mediaplayer.MainActivity
import com.example.mediaplayer.R
import com.example.mediaplayer.model.DataMediaPlayer

class AdapterMediaPlayer(val data :ArrayList<DataMediaPlayer>, val listener: MainActivity):RecyclerView.Adapter<AdapterMediaPlayer.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterMediaPlayer.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false))
    }

    override fun onBindViewHolder(holder: AdapterMediaPlayer.ViewHolder, position: Int) {

        holder.itemView.apply {

        }
    }

    override fun getItemCount(): Int {

        return data.size
    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){

    }
}