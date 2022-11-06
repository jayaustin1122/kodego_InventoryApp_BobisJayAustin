package com.kodeog.inventory.app.bobisjay

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import com.kodeog.inventory.app.bobisjay.databinding.ActivitySample1PermissionsBuiltinDialogBinding
import com.kodeog.inventory.app.bobisjay.databinding.CustomSampleDialogBinding

class sample1PermissionsBuiltinDialog : AppCompatActivity() {
    private lateinit var binding: ActivitySample1PermissionsBuiltinDialogBinding
    private val image = "https://cdn.myanimelist.net/images/characters/11/174517.jpg"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySample1PermissionsBuiltinDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCustomDialog.setOnClickListener() {
            //calling customDialog onclick of btnsample
            showCustomDialog()
        }
        binding.btnBuiltInDialog.setOnClickListener() {
            showBuiltInDialog()
        }
        binding.btnCamera.setOnClickListener(){
            showCamera()
        }
        binding.btnGallery.setOnClickListener(){
            showGallery()
        }
        binding.imgBtnCamera.setOnClickListener(){
            showCamera()
            binding.imgBtnCamera.setImageResource(R.drawable.ic_baseline_edit_24)
        }
        // to call any data image. Glide to get images in the Internet
        Glide.with(this)
            .load(image)
            .into(binding.imgSelectec)
    }


    private fun showGallery() {
        Dexter.withContext(this).withPermission(
            Manifest.permission.READ_EXTERNAL_STORAGE
        ).withListener(object : PermissionListener {
            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                galleryLauncher.launch(galleryIntent)
            }

            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                gotoSettings()
            }

            override fun onPermissionRationaleShouldBeShown(
                request : PermissionRequest?,
                token: PermissionToken?
            ) {
                token?.continuePermissionRequest()
            }

        }).onSameThread().check() // to show the permission
    }
    // to access camera.
    private fun showCamera() {
        Dexter.withContext(this).withPermission(
            Manifest.permission.CAMERA
        ).withListener(object : PermissionListener{
            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                Toast.makeText(applicationContext, "Camera Permission Granted", Toast.LENGTH_SHORT).show()
                //show camera
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                //declare the camera

                cameraLauncher.launch(cameraIntent)
//                startActivity(cameraIntent) // to go to camera only we cannot get an output or the image.
            }

            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                Toast.makeText(applicationContext, "Camera Permission Denied", Toast.LENGTH_SHORT).show()
                gotoSettings()
            }

            override fun onPermissionRationaleShouldBeShown(
                request : PermissionRequest?,
                token: PermissionToken?
            ) {
                token?.continuePermissionRequest()
            }

        }).onSameThread().check() // to show the permission
    }

    private fun gotoSettings() {
        AlertDialog.Builder(this).setMessage("Permission is Denied Go to Settings to Change it to allow.")
            .setPositiveButton("Go to Settings"){ dialog, item ->
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                var uri = Uri.fromParts("package",packageName,null)
                intent.data = uri
                startActivity(intent)
            }.setNegativeButton("Cancel"){ dialog, item ->
                dialog.dismiss()
            }.show()

    }

    // Built in Dialog
    private fun showBuiltInDialog() {
        AlertDialog.Builder(this).setMessage("This is a Dialog")
            .setPositiveButton("Positive Button") { dialog, item ->
                Toast.makeText(applicationContext, "Positive Button Click!", Toast.LENGTH_SHORT)
                    .show()
            }
            .setNegativeButton("Negative Button") { dialog, item ->
                Toast.makeText(applicationContext, "Negative Button Click!", Toast.LENGTH_SHORT)
                    .show()
            }.show()
        }
    // Custom Dialog
    private fun showCustomDialog(){
        //binding the dialog xml
        val customDialog: Dialog = Dialog(this)
        var dialogBinding : CustomSampleDialogBinding = CustomSampleDialogBinding.inflate(layoutInflater)
        customDialog.setContentView(dialogBinding.root)


        //calling buttons yes and no

        dialogBinding.btnYes.setOnClickListener() {
            customDialog.dismiss()
        }
        dialogBinding.btnNo.setOnClickListener(){
            Toast.makeText(applicationContext, "Ok Enjoy", Toast.LENGTH_SHORT).show()
        }
        customDialog.show()
    }
    // handle data or images from the camera
    val cameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.extras.let {
                val image : Bitmap = result.data?.extras?.get("data") as Bitmap // get only the image.
                binding.imgSelectec.setImageBitmap(image)
            }
        }

    }
    // handle data or images in Gallery
    val galleryLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.let {
                val selectedImage = result.data?.data
                binding.imgSelectec.setImageURI(selectedImage)
            }

        }
    }
}