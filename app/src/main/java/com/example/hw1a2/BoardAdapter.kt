package com.example.hw1a2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.hw1a2.databinding.ItemBoardBinding
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class BoardAdapter(val  navController: NavController) :
    RecyclerView.Adapter<BoardAdapter.ViewHolder>() {


    private val list = arrayListOf("Hello","Привет","Салам")
    private val image = arrayListOf(R.drawable.img_3,R.drawable.img_4,R.drawable.img_2)

    private val text = arrayListOf("Здраствуйте ","как дела?"," ты очень красивая")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false

            )
        )
    }

    override fun onBindViewHolder(holder: BoardAdapter.ViewHolder, position: Int) {
        holder.bind(position)

    }


    override fun getItemCount() =3




    inner class ViewHolder(private var binding: ItemBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.textTittle.text = list[position]
            binding.textDesc.text = text[position]
            binding.imageView.setImageResource(image[position])
            if (position == text.lastIndex) {
                binding.btnStart.visibility == View.VISIBLE
            } else {
                binding.btnStart.visibility == View.VISIBLE

            }
            binding.btnStart.setOnClickListener {
                navController.navigateUp()
            }

        }
    }
    }