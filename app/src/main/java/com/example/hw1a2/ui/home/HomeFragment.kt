package com.example.hw1a2.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.hw1a2.R
import com.example.hw1a2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fap.setOnClickListener {
            findNavController().navigate(R.id.secondFragment)
        }
        parentFragmentManager.setFragmentResultListener(
            "rk_news",
            viewLifecycleOwner
        ) { key, bundle ->
            val text = bundle.getString("text")
            Log.e("Home","text$text")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}