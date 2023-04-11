package com.example.sharedpreferencekelompoktiga

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.sharedpreferencekelompoktiga.databinding.FragmentLoginBinding

class FragmentLogin : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var sharedPref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        binding.clickListener = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = requireContext().getSharedPreferences("dataprefs", Context.MODE_PRIVATE)


    }

    fun checkAccount(){

        var inputUsername = binding.inputUsername.text.toString()
        var inputPassword = binding.inputPassword.text.toString()
        if(inputUsername.isNotEmpty() && inputPassword.isNotEmpty()){
            val getUsername = sharedPref.getString("username", "")
            val getPassword = sharedPref.getString("password", "")

            if(inputUsername == getUsername && inputPassword == getPassword){
                findNavController().navigate(R.id.action_fragmentLogin_to_fragmentHome)
                Toast.makeText(context, "$getUsername Login berhasil", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "Username atau password yang anda masukan salah!", Toast.LENGTH_SHORT).show()
            }

        }else{
            Toast.makeText(context, "Username atau Password tidak boleh kosong!", Toast.LENGTH_SHORT).show()
        }
    }

}