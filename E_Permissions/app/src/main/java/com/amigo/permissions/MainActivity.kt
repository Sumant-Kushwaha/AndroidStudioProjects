package com.amigo.permissions

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            permissions.entries.forEach { (permission, isGranted) ->
                if (isGranted) {
                    Log.d("PermissionRequested", "$permission granted")
                } else {
                    Log.d("PermissionRequested", "$permission denied")
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnPermission).setOnClickListener {
            reqPermission()
        }
    }

    private fun hasPermission(permission: String) =
        ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED

    private fun reqPermission() {
        val permissionToRequest = mutableListOf<String>()

        if (!hasPermission(Manifest.permission.ACCESS_COARSE_LOCATION)) {
            permissionToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            if (!hasPermission(Manifest.permission.ACCESS_BACKGROUND_LOCATION) &&
                hasPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
            ) {
                permissionToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            if (!hasPermission(Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED)) {
                permissionToRequest.add(Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED)
            }
            if (!hasPermission(Manifest.permission.READ_MEDIA_AUDIO)) {
                permissionToRequest.add(Manifest.permission.READ_MEDIA_AUDIO)
            }
        }

        if (permissionToRequest.isNotEmpty()) {
            requestPermissionLauncher.launch(permissionToRequest.toTypedArray())
        } else {
            Log.d("PermissionRequested", "All permissions already granted")
        }
    }
}
