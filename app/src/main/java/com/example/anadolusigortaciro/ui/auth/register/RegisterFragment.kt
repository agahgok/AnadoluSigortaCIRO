package com.example.anadolusigortaciro.ui.auth.register

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
import com.example.anadolusigortaciro.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text

class RegisterFragment : Fragment() {
    private lateinit var binding : FragmentRegisterBinding
    private lateinit var firebaseAuth : FirebaseAuth
    private var email = ""
    private var password = ""
    private var repassword = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnRegister.setOnClickListener {
            validateData()
        }

        return binding.root
    }
    private fun validateData(){
        email = binding.etRegisterEmail.text.toString()
        password = binding.etRegisterPassword.text.toString()
        repassword = binding.etRegisterPasswordAgain.text.toString()

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.etRegisterEmail.error = "Invalid email format"
        }else if(TextUtils.isEmpty(password) || TextUtils.isEmpty(repassword)){
            binding.etRegisterPassword.error = "Enter password"
        }else if(password != repassword){
            Toast.makeText(requireContext(),"Şifreler uyuşmuyor.",Toast.LENGTH_SHORT).show()
        }else{
            firebaseRegister()
        }
    }
    private fun firebaseRegister(){
        firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                //Register success.
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email
                Toast.makeText(requireContext(), "Kayıt oluşturuldu : $email",Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
            }
            .addOnFailureListener {e ->
                //Register failed.
                Toast.makeText(requireContext(), "Kayıt başarısız:$e",Toast.LENGTH_SHORT).show()
            }
    }
}