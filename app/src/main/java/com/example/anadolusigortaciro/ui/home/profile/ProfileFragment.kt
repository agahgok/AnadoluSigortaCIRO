package com.example.anadolusigortaciro.ui.home.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.anadolusigortaciro.R
import com.example.anadolusigortaciro.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import kotlin.contracts.contract

class ProfileFragment : Fragment() {
    private lateinit var binding : FragmentProfileBinding
    private lateinit var firebaseAuth : FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        firebaseAuth  = FirebaseAuth.getInstance()

        setUserInformation()
        binding.btnProfileExit.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
            firebaseAuth.signOut()
        }
        return binding.root
    }

    private fun setUserInformation(){
        val firebaseUser = firebaseAuth.currentUser
        binding.tvProfileUsername.text = firebaseUser!!.email.toString()
    }
}