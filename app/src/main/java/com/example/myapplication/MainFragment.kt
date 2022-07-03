package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private var adapter: ZodiacAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        initAdapter()
    }

    private fun initAdapter() {
        adapter = ZodiacAdapter(
            ZodiacRepository.zodiacs,
            Glide.with(this)
        ) { position ->
            //Я не знаю, как здесь сделать переход на другой фрагмент(( Не работает
            val bundle = Bundle()
            bundle.putInt("ID", position)
            binding.root.findNavController().navigate(R.id.action_mainFragment_to_infoFragment, bundle)
        }
        binding.rvZodiac.adapter = adapter
        binding.rvZodiac.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}