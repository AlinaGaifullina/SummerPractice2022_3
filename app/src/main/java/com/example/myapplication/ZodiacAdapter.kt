package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.myapplication.databinding.ItemZodiacBinding

class ZodiacAdapter(
    private var list: List<Zodiac>,
    private val glide: RequestManager,
    private val onItemClick: (position: Int) -> Unit
) : RecyclerView.Adapter<ZodiacHolder>() {

    override fun onCreateViewHolder(
                parent: ViewGroup,
                 viewType: Int
    ): ZodiacHolder = ZodiacHolder(
        binding = ItemZodiacBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
        false
        ),
        glide = glide,
        onItemClick = onItemClick
    )

    override fun onBindViewHolder(holder: ZodiacHolder, position: Int) {
        holder.onBind(list[position])
        //Это еще одна попытка перейти на другой фрагмент: тоже не работает((
        /*holder.itemView.setOnClickListener{
            val bundle = Bundle()
            bundle.putInt("ID", position)
            it.findNavController().navigate(R.id.action_mainFragment_to_infoFragment, bundle)
        }*/
    }

    override fun getItemCount(): Int = list.size

}