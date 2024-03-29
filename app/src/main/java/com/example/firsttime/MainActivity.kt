package com.example.firsttime

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var inPut: EditText
    lateinit var writing: TextView
    lateinit var answer: String


    val ages = arrayOf(
        mapOf(
            "age" to "21",
            "name" to "Mandela",
            "message" to "He died having achieved so much more"
        ),
        mapOf(
            "age" to "1",
            "name" to "Smith",
            "message" to "He died having so much kids"
        )
    )




    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.buttonSubmit)
        inPut = findViewById(R.id.enter)
        writing = findViewById(R.id.message)

        button.setOnClickListener {
            answer = inPut.text.toString()

            if(ages.any { it["age"] == answer }){
                val index = ages.indexOfFirst { it["age"] == answer }

                val name: String = ages[index]["name"].toString()
                val message: String = ages[index]["message"].toString()

                println("This is the answer : $answer, and this is the name : $name, and this is the message $message")
                writing.text = "This is the answer : $answer, and this is the name : $name, and this is the message $message"
            }else{
                println("No record found")
                writing.text = "No record found for age $answer"
            }

        }


    }
}