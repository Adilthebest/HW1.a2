package com.example.hw1a2

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw1a2.databinding.ItemNewsBinding

class News_Adapter: RecyclerView.Adapter<News_Adapter.NewsViewHolder>() {
    private val list = arrayListOf<News>()
    var onClick: ((News) -> Unit)? = null
    var onLongClick: ((Int) -> Unit)? = null

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

        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(Color.GRAY)
        } else {
            holder.itemView.setBackgroundColor(Color.WHITE)

        }


    }

    override fun getItemCount() = list.size


    fun addItem(news: News?) {
        news?.let {
            list.add(0, it)
            notifyItemInserted(list.indexOf(news))

        }
    }

    fun getItem(it: Int): News {
        return list[it]

    }


    fun deleteItemsAndNotifyAdapter(pos: Int) {
        list.removeAt(pos)
        notifyItemRemoved(pos)
    }

    inner class NewsViewHolder(private var binding: ItemNewsBinding) ://
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            binding.textTitle.text = news.title
            itemView.setOnClickListener {
                onClick?.invoke(news)
            }
            itemView.setOnLongClickListener {
                onLongClick?.invoke(adapterPosition)// учесть и не забыть!!!!
                return@setOnLongClickListener true
            }
        }
    }
}



