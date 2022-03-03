package com.example.anadolusigortaciro.ui.home.petsagram.sharephoto

import android.Manifest
import android.app.Activity.RESULT_OK
import androidx.core.app.ActivityCompat
import android.app.ProgressDialog
import android.content.ContentResolver
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.MimeTypeMap
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.anadolusigortaciro.R
import com.example.anadolusigortaciro.databinding.FragmentSharePhotoBinding
import com.example.anadolusigortaciro.model.SharedPhoto
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.StorageTask
import com.google.firebase.storage.UploadTask
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*

class SharePhotoFragment : Fragment() {
    private lateinit var binding: FragmentSharePhotoBinding
    private lateinit var imageUri: Uri
    private lateinit var storageReference: StorageReference
    private lateinit var databaseReference: DatabaseReference
    private lateinit var firebaseAuth: FirebaseAuth
    private var uploadTask: StorageTask<UploadTask.TaskSnapshot>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSharePhotoBinding.inflate(inflater, container, false)
        firebaseAuth = FirebaseAuth.getInstance()
        storageReference = FirebaseStorage.getInstance().getReference("uploads")
        databaseReference = FirebaseDatabase.getInstance().getReference("uploads")

        binding.btnUploadPhoto.setOnClickListener {
            //Upload the photo to firebase.
            if (uploadTask != null && uploadTask!!.isInProgress) {
                Toast.makeText(requireContext(), "Upload in Progress", Toast.LENGTH_SHORT).show();
            } else {
                if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    uploadFile()
                }else{
                    ActivityCompat.requestPermissions(
                        requireActivity(),
                        arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                        44
                    )
                }
            }
        }
        binding.imUpdatePhoto.setOnClickListener {
            selectImage()
        }
        return binding.root
    }

    private fun selectImage() {
        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        startActivityForResult(gallery, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK) {
            imageUri = data?.data!!
            Picasso.get()
                .load(imageUri)
                .fit()
                .into(binding.imUpdatePhoto)
        }
    }

    private fun uploadFile() {
        if (binding.imUpdatePhoto != null) {
            val progressDialog = ProgressDialog(requireContext())
            progressDialog.setMessage("Uploading File...")
            progressDialog.setCancelable(false)
            progressDialog.show()

            val fileReference: StorageReference = storageReference.child(
                System.currentTimeMillis()
                    .toString() + "." + getFileExtension(imageUri)
            )

            uploadTask = fileReference.putFile(imageUri)
                .addOnSuccessListener {
                    progressDialog.dismiss()
                    Toast.makeText(requireContext(), "Uploaded successfully", Toast.LENGTH_SHORT)
                        .show()
                    val urlTask: Task<Uri> = it.storage.downloadUrl
                    while (!urlTask.isSuccessful);

                    val currentDate = getCurrentDateTime()
                    val dateInString = currentDate.toString("yyyy/MM/dd HH:mm")
                    val downloadUrl: Uri = urlTask.result
                    val firebaseUser = firebaseAuth.currentUser
                    val email: String = firebaseUser!!.email.toString()
                    val sharedPhoto = SharedPhoto(downloadUrl.toString(), email, dateInString)
                    val uploadId: String? = databaseReference.push().key
                    if (uploadId != null) {
                        databaseReference.child(uploadId).setValue(sharedPhoto)
                    }
                    findNavController().navigate(R.id.action_sharePhotoFragment_to_petsagramFragment)
                }
                .addOnFailureListener {
                    progressDialog.dismiss()
                    Toast.makeText(requireContext(), "Upload Failed", Toast.LENGTH_SHORT).show()
                }
        } else {
            Toast.makeText(requireContext(), "Empty file", Toast.LENGTH_SHORT).show();
        }
    }

    private fun getFileExtension(uri: Uri): String? {
        val cR: ContentResolver = requireActivity().contentResolver
        val mime = MimeTypeMap.getSingleton()
        return mime.getExtensionFromMimeType(cR.getType(uri))
    }

    private fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    private fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }

}