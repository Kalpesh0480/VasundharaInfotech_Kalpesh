package com.example.vasundharainfotech.blink_box

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.vasundharainfotech.R
import com.example.vasundharainfotech.gridview.GrideViewActivity

class BlinkBoxActivity : AppCompatActivity() {

    private lateinit var  editTextGridSize:EditText
    private lateinit var  buttonProceed:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blink_box)

        initView()
        setOnClickList()
    }
    private fun initView() {
         editTextGridSize = findViewById<EditText>(R.id.editTextGridSize)
         buttonProceed = findViewById<Button>(R.id.buttonProceed)
    }
    private fun setOnClickList() {
        buttonProceed.setOnClickListener {
            val gridSizeText = editTextGridSize.text.toString()
            if (gridSizeText.isNotEmpty()) {
                val gridSize = gridSizeText.toInt()
                if (gridSize in 4..10) {
                    val intent = Intent(this, GrideViewActivity::class.java)
                    intent.putExtra("gridSize", gridSize)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Grid size should be between 4 and 10", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter a grid size", Toast.LENGTH_SHORT).show()
            }
        }

    }
}