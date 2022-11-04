package com.kodeog.inventory.app.bobisjay

import android.Manifest
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import com.kodeog.inventory.app.bobisjay.databinding.ActivitySample1PermissionsBuiltinDialogBinding
import com.kodeog.inventory.app.bobisjay.databinding.CustomSampleDialogBinding

class sample1PermissionsBuiltinDialog : AppCompatActivity() {
    lateinit var binding: ActivitySample1PermissionsBuiltinDialogBinding
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
        binding.btnSamplePermission.setOnClickListener(){
            showCamera()
        }
    }

    private fun showCamera() {
        Dexter.withContext(this).withPermission(
            Manifest.permission.CAMERA
        ).withListener(object : PermissionListener{
            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                Toast.makeText(applicationContext, "Camera Permission Granted", Toast.LENGTH_SHORT)
                    .show()
                //show camera
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(cameraIntent)
            }

            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                Toast.makeText(applicationContext, "Camera Permission Denied", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onPermissionRationaleShouldBeShown(
                request : PermissionRequest?,
                token: PermissionToken?
            ) {
                token?.continuePermissionRequest()
            }

        }).onSameThread().check() // to show the permission
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
}