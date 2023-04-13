package com.example.sharedpreferencekelompoktiga

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.sharedpreferencekelompoktiga.databinding.FragmentSplashBinding


class FragmentSplash : Fragment() {
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed({
            if (context?.getSharedPreferences("dataprefs", Context.MODE_PRIVATE)!!.contains("username")){
                Navigation.findNavController(view).navigate(R.id.action_fragmentSplash_to_fragmentHome)
            } else{
                Navigation.findNavController(view).navigate(R.id.action_fragmentSplash_to_fragmentLogin)
            }
        },2500)
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar?.show()

    }


}