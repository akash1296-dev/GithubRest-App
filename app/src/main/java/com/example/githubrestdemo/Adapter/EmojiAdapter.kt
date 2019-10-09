package com.example.githubrestdemo.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubrestdemo.R
import kotlinx.android.synthetic.main.row_emoji.view.*


class EmojiAdapter(private val emo: ArrayList<String>) : RecyclerView.Adapter<EmojiAdapter.ViewHolder>() {

    private val TAG = "EmojiAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        Log.d(TAG,"onCreateViewHolder")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_emoji, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = emo.hashCode()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Log.d(TAG,"onBindViewHolder")
        Log.d(TAG,"$position")
        if(position < 1510) {
            val photoUrl = emo[position]
            Log.d("photoUrl is:", photoUrl)
            holder.bind(photoUrl)
        } else {
            return
        }
        /*emo?.keys?.forEach { key ->
            Log.d(TAG, "$key => ${emo[key]}")
        }*/

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(photoUrl: String) {
            Log.d("EAinViewHolder",photoUrl)
            Glide.with(itemView.context).load(photoUrl).into(itemView.ivEmojis)
        }

        /*fun bind(photoUrl: String) {
            Glide.with(itemView.context).load(photoUrl).into(itemView.avatarUrlId)
        }*/
    }
}