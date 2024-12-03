package com.codshooter.porter

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.codshooter.porter.activity.LoginActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val locationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                proceedToApp()
            } else {
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Location and notification permissions are required to continue this app.",
                    Snackbar.LENGTH_SHORT
                ).show()

                handlePermissionDenied()

            }
        }


    private val locationNotificationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            if (permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true &&
                permissions[Manifest.permission.POST_NOTIFICATIONS] == true
            ) {
                proceedToApp()
            } else {
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Location and notification permissions are required to continue this app.",
                    Snackbar.LENGTH_SHORT
                ).show()
                handlePermissionDenied()
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { // Android 13+
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED ||

                ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            )
                locationNotificationPermissionLauncher.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.POST_NOTIFICATIONS
                    )
                )
        } else {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            )
                locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            else
                proceedToApp()
        }


    }

    private fun handlePermissionDenied() {
        AlertDialog.Builder(this)
            .setTitle("Permission Denied")
            .setMessage("Notification permission is required to stay updated. Please enable it in settings.")
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
                finish()
            }
            .setPositiveButton("Settings") { dialog, _ ->
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                    data = Uri.fromParts("package", packageName, null)
                }
                startActivity(intent)
                dialog.dismiss()
            }


            .show()
    }

    private fun proceedToApp() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            finish()
        }, 2000)
    }


}