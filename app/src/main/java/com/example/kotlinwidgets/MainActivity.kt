package com.example.kotlinwidgets

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinwidgets.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //line  1
        mainBinding.clickBtn.setOnClickListener {
            val veri = mainBinding.girilenVeri.text.toString()
            mainBinding.veriTxt.text = veri
        }


        ///line 2
        mainBinding.switch1.setOnCheckedChangeListener { buttonView, isChecked ->

            if(isChecked){

                Log.e("switch", "açık")

            }else{

                Log.e("switch", "kapalı")

            }

        }

        mainBinding.toggleBtn1.setOnCheckedChangeListener { buttonView, isChecked ->

            if(isChecked){

                Log.e("switch", "açık")

            }else{

                Log.e("switch", "kapalı")

            }

        }

        mainBinding.click1Btn.setOnClickListener {

            val switcDurum = mainBinding.switch1.isChecked
            val toggleDurum = mainBinding.toggleBtn1.isChecked

            Log.e("switch", switcDurum.toString())
            Log.e("toggle", toggleDurum.toString())
        }


        mainBinding.click3Btn.setOnClickListener {
            val javaDurum = mainBinding.checkBoxJava.isChecked
            val kotlinDurum = mainBinding.checkBpxKotlin.isChecked
            val fbDurum = mainBinding.fbRadio.isChecked
            val gsDurum = mainBinding.gsRadio.isChecked

            Log.e("java", javaDurum.toString())
            Log.e("kotlin", kotlinDurum.toString())
            Log.e("fb", fbDurum.toString())
            Log.e("gs", gsDurum.toString())

        }

        mainBinding.fbRadio.setOnCheckedChangeListener { buttonView, isChecked ->

            if(isChecked){
                Toast.makeText(this, "FB seçildi", Toast.LENGTH_SHORT).show()
            }

        }

        mainBinding.btnBasla.setOnClickListener {

            mainBinding.progressBar.visibility = android.view.View.VISIBLE

        }

        mainBinding.btnDur.setOnClickListener {

            mainBinding.progressBar.visibility = android.view.View.INVISIBLE

        }

        mainBinding.sliderBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                mainBinding.sliderTxt.text = progress.toString()

                val bolum = progress / 20
                val kalan = progress % 20

                mainBinding.ratingBar.rating = bolum + kalan / 20f

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })


        mainBinding.btnGoster.setOnClickListener {

            val gelenIlerleme = mainBinding.sliderBar.progress
            val gelenOylama = mainBinding.ratingBar.rating

            Log.e("ilerleme", gelenIlerleme.toString())
            Log.e("oylama", gelenOylama.toString())

        }


        mainBinding.btnGec.setOnClickListener {

            val intent = Intent(this@MainActivity, WebActivity::class.java)
            startActivity(intent)

        }



    }
}