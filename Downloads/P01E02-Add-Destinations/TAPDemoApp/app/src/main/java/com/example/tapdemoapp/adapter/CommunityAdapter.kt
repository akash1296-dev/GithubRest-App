package com.example.tapdemoapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tapdemoapp.R
import com.example.tapdemoapp.model.ArticlesModel
import kotlinx.android.synthetic.main.community_news.view.*

class CommunityAdapter(private val news: ArticlesModel) : RecyclerView.Adapter<CommunityAdapter.ViewHolder>() {
    private val TAG = "CommunityAdatper"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.community_news,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = news.totalResults

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.sourceName.text = news.articles[position].source.name
        Log.d("inBindViewHolder","${holder.sourceName}")
        holder.authorName.text = news.articles[position].author
        holder.titleName.text = news.articles[position].title
        holder.description.text = news.articles[position].description

        val photoUrl = news.articles[position].urlToImage
        holder.bind(photoUrl)

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var sourceName: TextView = itemView.tvSource
        var authorName: TextView = itemView.tvAuthor
        var titleName: TextView = itemView.tvTitle
        var description: TextView = itemView.tvDescription

        fun bind(photoUrl: String) {
            Glide.with(itemView.context).load(photoUrl).into(itemView.ivNews)
        }
    }
}