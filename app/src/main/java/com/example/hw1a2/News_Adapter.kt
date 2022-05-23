package com.example.hw1a2

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hw1a2.databinding.ItemNewsBinding
import java.io.Serializable

class News_Adapter(private val onClick:(position:Int)->Unit): RecyclerView.Adapter<News_Adapter.NewsViewHolder>() {
    private val list = arrayListOf<News>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(list[position])

        if (position % 2 == 0){
            holder.itemView.setBackgroundColor(Color.GRAY)
    }else{
            holder.itemView.setBackgroundColor(Color.WHITE)

        }
        holder.itemView.setOnClickListener{
            onClick(position)
        }
    }

    override fun getItemCount() = list.size


    fun addItem(news: News?) {
        news?.let{
list.add(0,it)
            notifyItemInserted(list.indexOf(news))

        }
    }

    fun getItem(it: Int): News {
return list[it]
    }


    inner class NewsViewHolder(private var binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
                binding.textTitle.text = news.title
            }
        }

    }



