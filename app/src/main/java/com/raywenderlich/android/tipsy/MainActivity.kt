/*
 * Copyright (c) 2021 Razeware LLC
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 * 
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.tipsy

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Main Screen
 */
class MainActivity : AppCompatActivity() {
  private lateinit var billTextInput: EditText
  private lateinit var percentTextInput: EditText
  private lateinit var tipTextView: TextView
  private lateinit var totalTextView: TextView
  private lateinit var submitButton: Button

  override fun onCreate(savedInstanceState: Bundle?) {
    // Switch to AppTheme for displaying the activity
    setTheme(R.style.AppTheme)

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // Your code
    billTextInput = findViewById(R.id.billTextInput)
    percentTextInput = findViewById(R.id.percentTextInput)
    tipTextView = findViewById(R.id.tipTextView)
    totalTextView = findViewById(R.id.totalTextView)
    submitButton = findViewById(R.id.submitButton)


  }

  override fun onStart() {
    super.onStart()
    submitButton.setOnClickListener {
      submitButtonPressed()
    }
  }

  private fun textOrZero(input: String?): String {
    if (input.isNullOrBlank()) {
      return "0"
    }
    return input
  }

  private fun submitButtonPressed() {
    val bill = textOrZero(billTextInput.text.toString())
    val percentage = textOrZero(percentTextInput.text.toString())
    val tip = this.calculateTip(percentage.toInt(), bill.toInt())
    tipTextView.text = tip.toString()
    val total = tip + bill.toDouble()
    totalTextView.text = total.toString()
  }

  private fun calculateTip(bill: Int, percent: Int): Double {
    // convert percent to decimal number
    val percentage = percent.toDouble() * 0.01
    // multiply bill by percentage
    return bill * percentage
  }
}
