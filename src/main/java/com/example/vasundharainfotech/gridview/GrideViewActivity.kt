package com.example.vasundharainfotech.gridview

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.LinearInterpolator
import android.widget.AdapterView
import android.widget.GridView
import com.example.vasundharainfotech.R
import com.example.vasundharainfotech.gridview.adapter.GridAdapter


class GrideViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gride)

        val gridSize = intent.getIntExtra("gridSize", 4)
        val gridItems = ArrayList<String>()
        for (i in 0 until gridSize) {
            for (j in 0 until gridSize) {
                gridItems.add("($i, $j)")
            }
        }

        val gridView: GridView = findViewById(R.id.gridView)
        val adapter = GridAdapter(this, gridItems)
        gridView.adapter = adapter

        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, view, position, _ ->
            blinkRows(gridView, position, gridSize)
        }
    }
    private fun blinkRows(gridView: GridView, position: Int, gridSize: Int) {
        val clickedRow = position / gridSize
        val clickedColumn = position % gridSize
        val horizontalRow = ArrayList<Int>()
        val verticalRow = ArrayList<Int>()
        val diagonal1 = ArrayList<Int>()
        val diagonal2 = ArrayList<Int>()

        for (i in 0 until gridSize) {
            horizontalRow.add(clickedRow * gridSize + i)
            verticalRow.add(i * gridSize + clickedColumn)
            diagonal1.add(i * gridSize + i) // Diagonal \
            diagonal2.add(i * gridSize + (gridSize - 1 - i)) // Diagonal /
        }

        val blinkDuration = 500L
        val blinkAnimator = ValueAnimator.ofInt(0, 255)
        blinkAnimator.duration = blinkDuration
        blinkAnimator.addUpdateListener { valueAnimator ->
            val alpha = valueAnimator.animatedValue as Int
            for (position in horizontalRow + verticalRow + diagonal1 + diagonal2) {
                val blinkView = gridView.getChildAt(position)
                blinkView?.background?.alpha = alpha
            }
        }
        blinkAnimator.interpolator = LinearInterpolator()
        blinkAnimator.repeatCount = 1
        blinkAnimator.repeatMode = ValueAnimator.REVERSE
        blinkAnimator.start()
    }
}