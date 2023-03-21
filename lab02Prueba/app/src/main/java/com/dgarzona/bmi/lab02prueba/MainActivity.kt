package com.dgarzona.bmi.lab02prueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var numberEditText: EditText
    private lateinit var numberEditText2: EditText
    private lateinit var actionResultButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var resultTextView2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding()
        setLisener()
    }
private fun binding(){
    numberEditText = findViewById(R.id.weightInt)
    numberEditText2 = findViewById(R.id.heightInt)
    actionResultButton = findViewById(R.id.button)
    resultTextView2 = findViewById(R.id.resultWeight)
    resultTextView = findViewById(R.id.result)

}
private fun setLisener(){
    actionResultButton.setOnClickListener {
        val number = numberEditText.text.toString()
        val number2 = numberEditText2.text.toString()

        if (number.isNullOrEmpty()){
            Toast.makeText(this, "el dato esta vacio", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }
        if (number2.isNullOrEmpty()){
            Toast.makeText(this, "el dato esta vacio", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }
        val result = number.toFloat()/(number2.toFloat()*number2.toFloat()/10000)
        resultado(result)
    }
}
    private fun resultado(number:Float){
        if (number <=18.5){
            resultTextView.text = number.toString()
            resultTextView2.text = "Underweight"
            resultTextView2.setTextColor(ContextCompat.getColor(this, R.color.under_weight))
        }
        if (number >18.5 && number <=24.99){
            resultTextView.text = number.toString()
            resultTextView2.text = "Healthy"
            resultTextView2.setTextColor(ContextCompat.getColor(this, R.color.normal_weight))
        }
        if (number >= 25 && number <=29.99){
            resultTextView.text = number.toString()
            resultTextView2.text = "Overweight"
            resultTextView2.setTextColor(ContextCompat.getColor(this, R.color.over_weight))
        }
        if (number >= 30){
            resultTextView.text = number.toString()
            resultTextView2.text = "Obese"
            resultTextView2.setTextColor(ContextCompat.getColor(this, R.color.obese))
        }
    }

}