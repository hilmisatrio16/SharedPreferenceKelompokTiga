package com.example.sharedpreferencekelompoktiga

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sharedpreferencekelompoktiga.databinding.FragmentHomeBinding


class FragmentHome : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var getPref:SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        binding.clickListeners = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPref = requireContext().getSharedPreferences("dataprefs", Context.MODE_PRIVATE)
        binding.username = "Hello," + " " + getPref.getString("username", "null")

        binding.btnLogout.setOnClickListener {
            logOut()
        }
    }



    @SuppressLint("CommitPrefEdits")
    fun logOut(){
        val prefs = getPref.edit()
        prefs.clear()
        prefs.apply()
        findNavController().navigate(R.id.action_fragmentHome_to_fragmentLogin)
    }


}