package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val weightText = findViewById<EditText>(R.id.etnweight)
        val heightText = findViewById<EditText>(R.id.etnheight)
        val calButton = findViewById<Button>(R.id.buttoncal)

        calButton.setOnClickListener {
            val weight = weightText.text.toString()
            val height = heightText.text.toString()
            if (validateINPUT(weight, height)) {


                val bmi =
                    weight.toFloat() / (((height.toFloat()) / 100) * ((height.toFloat()) / 100))
                val bmi2digit = String.format("%.2f", bmi).toFloat()
                displayResult(bmi2digit)

            }
        }
    }
    private fun validateINPUT(weight:String?,height:String?):Boolean{
        return when{
            weight.isNullOrEmpty()->  {
                Toast.makeText(this,"weight is empty",Toast.LENGTH_SHORT).show()
                return false
            }
            weight.isNullOrEmpty()-> {
                Toast.makeText(this,"weight is empty",Toast.LENGTH_SHORT).show()
                return false
        }
            else ->
            {
            return true}
        }
    }
    private fun displayResult(bmi:Float){
        val resultindex = findViewById<TextView>(R.id.tvresult)
        val resultdescription =findViewById<TextView>(R.id.tvstatement)
        resultindex.text = bmi.toString()
        var resultText = ""
        var color = 0


        when{
            bmi<18.50 ->{
                resultText ="underweight"
                color = R.color.underweight

            }
            bmi in 18.5 ..24.99 ->{
                resultText ="noraml"
                color = androidx.core.R.id.normal
            }
            bmi in 24.99 ..29.99->{
                resultText = "overweight"
                color =R.color.overweight

            }
            bmi >29.99 ->{
                resultText = "obese"
                color = R.color.obese
            }
        }
        resultdescription.text =resultText
        resultdescription.setTextColor(ContextCompat.getColor(this,color))

    }


}



