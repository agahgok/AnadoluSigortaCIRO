package com.example.anadolusigortaciro.ui.auth.login

import android.app.ActionBar
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.anadolusigortaciro.R
import com.example.anadolusigortaciro.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var actionBar : ActionBar
    private var email = ""
    private var password = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()
        binding.btnLogin.setOnClickListener {
            validateData()
        }
        binding.btnLoginToRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        return binding.root
    }

    private fun checkUser(){
        val firebaseUser = firebaseAuth.currentUser
        if(firebaseUser !=null){
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }
    }
    private fun validateData(){
        email = binding.etLoginEmail.text.toString()
        password = binding.etLoginPassword.text.toString()

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.etLoginEmail.error = "Invalid email format"
        }else if(TextUtils.isEmpty(password)){
            binding.etLoginPassword.error = "Please enter password"
        }else{
            firebaseLogin()
        }
    }
    private fun firebaseLogin(){
        firebaseAuth.signInWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }
            .addOnFailureListener {e ->
                Toast.makeText(requireContext(),"Giriş başarısız: "+e,Toast.LENGTH_SHORT).show()
            }
    }
}