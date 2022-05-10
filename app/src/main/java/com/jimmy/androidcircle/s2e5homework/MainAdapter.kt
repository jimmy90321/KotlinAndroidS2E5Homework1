package com.jimmy.androidcircle.s2e5homework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jimmy.androidcircle.s2e5homework.databinding.ItemMainBinding

typealias OnMainItemClick = (Int) -> Unit

class MainViewHolder(
    private val binding: ItemMainBinding,
    private val onItemClick: OnMainItemClick
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(position: Int) {
        binding.apply {
            tvNumber.text = position.toString()

            root.setOnClickListener {
                onItemClick(position)
            }
        }
    }
}


class MainAdapter(
    private val onItemClick: OnMainItemClick
) : RecyclerView.Adapter<MainViewHolder>() {
    private val list = mutableListOf<Int>()

    init {
        for (number in 0 until 50) {
            list.add(number)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}