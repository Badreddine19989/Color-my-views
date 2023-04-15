/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setlisteners()
    }

    private fun setlisteners() {
        binding.apply {

            val clickableviews: List<View> = listOf(
                boxOneText,
                boxTwoText,
                boxTextThree,
                boxTextFour,
                boxTextFive,
                constraintLayout,
                redButton,
                yellowButton,
                greenButton
            )
            for (item in clickableviews) {
                item.setOnClickListener { makeColored(it) }
            }
        }
    }

    fun makeColored(view: View) {
        binding.apply {
            when (view) {
                // Boxes using Color class colors for background
                boxOneText -> view.setBackgroundColor(Color.DKGRAY)
                boxTwoText -> view.setBackgroundColor(Color.GRAY)

                // Boxes using Android color resources for background
                boxTextThree -> view.setBackgroundResource(android.R.color.holo_green_light)
                boxTextFour -> view.setBackgroundResource(android.R.color.holo_green_dark)
                boxTextFive -> view.setBackgroundResource(android.R.color.holo_green_light)

                // Boxes using custom colors for background
                redButton -> boxTextThree.setBackgroundResource(R.color.my_red)
                yellowButton -> boxTextFour.setBackgroundResource(R.color.my_yellow)
                greenButton -> boxTextFive.setBackgroundResource(R.color.my_green)
                else -> view.setBackgroundColor(Color.LTGRAY)
            }
        }
    }
}