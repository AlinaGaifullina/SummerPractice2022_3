package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myapplication.ZodiacRepository.zodiacs
import com.example.myapplication.databinding.FragmentInfoBinding

class InfoFragment : Fragment(R.layout.fragment_info) {

    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    private lateinit var zod: Zodiac

    //Наверное это всё работает... Не могу проверить, так как не открывается этот фрагмент

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentInfoBinding.bind(view)

        val result = (arguments?.getString("ID").orEmpty()).toInt()
        zodiacs.forEach(){
            if(it.id == result){
                zod = it
            }
        }

        with(binding){
            tvInfoname.text = "Name: ${zod.name}"
            tvInfoelem.text = "Elem: ${zod.elem}"
            tvInfodate.text = "Date: ${zod.date}"
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}