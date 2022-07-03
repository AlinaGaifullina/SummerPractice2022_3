package com.example.myapplication

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.databinding.ItemZodiacBinding

class ZodiacHolder(
    private val binding: ItemZodiacBinding,
    private val glide: RequestManager,
    private val onItemClick: (position: Int) -> Unit
) : RecyclerView.ViewHolder(binding.root), View.OnClickListener{

    fun onBind(zodiac: Zodiac) {
        with(binding) {
            tvName.text = zodiac.name
            tvAuthor.text = zodiac.elem
            root.setOnClickListener {
                onItemClick(zodiac.id)
            }

            glide
                .load(zodiac.url)
                .placeholder(R.drawable.base)
                .error(R.drawable.base)
                .into(ivCover)

        }
    }

    override fun onClick(v: View?) {
        val position = adapterPosition
        onItemClick(position)
    }
}