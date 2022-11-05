package com.example.kaamkinews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import java.util.zip.Inflater

class NewsListadapter(private val listner:NewsItemClicked): RecyclerView.Adapter<NewsViewHolder>() {
    private val items:ArrayList<News> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        val viewHolder=NewsViewHolder(view)
        view.setOnClickListener{
            listner.onItemCliked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem=items[position]
        holder.title_tv.text=currentItem.title
        holder.author_tv.text=currentItem.author
        Glide.with(holder.itemView.context).load(currentItem.imageUrl).into(holder.image_iv)
    }

    override fun getItemCount(): Int {
    return items.size
    }
    fun updatedNews(updatedNews:ArrayList<News>){
        items.clear()
        items.addAll(updatedNews)
        notifyDataSetChanged()
    }
}


class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title_tv: TextView=itemView.findViewById(R.id.title_tv)
    val image_iv:ImageView=itemView.findViewById(R.id.image_iv)
    val author_tv:TextView=itemView.findViewById(R.id.author_tv)
}

interface NewsItemClicked{
    fun onItemCliked(item:News)
    }
