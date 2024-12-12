package cnovaez.dev.pre_ventav2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 ** Created by Carlos A. Novaez Guerrero on 5/9/2023 9:15 PM
 ** cnovaez.dev@outlook.com
 **/
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        startActivity(Intent(this, MainActivity::class.java))
    }
}
