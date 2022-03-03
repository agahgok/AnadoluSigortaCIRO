package com.example.anadolusigortaciro.ui.home.petsagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anadolusigortaciro.R
import com.example.anadolusigortaciro.databinding.FragmentPetsagramSharePhotoBinding
import com.example.anadolusigortaciro.model.SharedPhoto
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase

class PetsagramSharePhotoFragment : Fragment() {
    private lateinit var binding: FragmentPetsagramSharePhotoBinding
    private var photoList = ArrayList<SharedPhoto>()
    private lateinit var databaseReference: DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPetsagramSharePhotoBinding.inflate(inflater, container, false)
        photoList = ArrayList()
        databaseReference = FirebaseDatabase.getInstance().getReference("uploads")

        binding.btnSharePhoto.setOnClickListener {
            findNavController().navigate(R.id.action_petsagramFragment_to_sharePhotoFragment)
        }
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                photoList = ArrayList<SharedPhoto>()

                for (postSnapshot: DataSnapshot in snapshot.children) {
                    val sharedPhoto: SharedPhoto? = postSnapshot.getValue(SharedPhoto::class.java)
                    if (sharedPhoto != null) {
                        photoList.add(sharedPhoto)
                    }
                    setRecyclerViewAdapter(photoList)
                    binding.progressBar.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireContext(), error.message, Toast.LENGTH_SHORT).show();
            }
        })
        return binding.root
    }

    private fun setRecyclerViewAdapter(photoList: ArrayList<SharedPhoto>) {
        val mLayoutManager = LinearLayoutManager(context)
        binding.recyclerViewSharedPhotos.layoutManager = mLayoutManager
        binding.recyclerViewSharedPhotos.adapter = context?.let {
            PetsagramSharedPhotoAdapter(it, photoList)
        }
    }
}