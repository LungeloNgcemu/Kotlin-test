package com.example.firsttime

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
// Declarations
    lateinit var buttonSubmit: Button
    lateinit var buttonClear: Button
    lateinit var inPut: EditText
    lateinit var writing: TextView
    lateinit var name: TextView
    lateinit var age: TextView
    lateinit var head: TextView
    lateinit var answer: String
    lateinit var image: ImageView
    lateinit var picture: ImageView
    var isInt: Boolean = false
   var intAnswer: Int = 0

    //Map
    val ages = arrayOf(
        mapOf(
            "age" to "95",
            "name" to "Mandela",
            "message" to "It always seems impossible until it's done",
            "image" to R.drawable.mandela
        ),
        mapOf(
            "age" to "41",
            "name" to "Koby Bryant",
            "message" to "From the beginning, I wanted to be the best",
            "image" to R.drawable.koby
        ),
        mapOf(
            "age" to "61",
            "name" to "Kobus Van Rensburg",
            "message" to "you will NEVER DIE!",
            "image" to R.drawable.kobus
        ),
        mapOf(
            "age" to "25",
            "name" to "Tupac Shakur",
            "message" to "Death is not the greatest loss in life.",
            "image" to R.drawable.tupac
        ),
        mapOf(
            "age" to "22",
            "name" to "Aalijah",
            "message" to "Keep working hard and you can get anything that you want.",
            "image" to R.drawable.aaliyah
        ),
        mapOf(
            "age" to "50",
            "name" to "Chris Hani",
            "message" to "If you want peace then you must struggle for social justice.",
            "image" to R.drawable.chrishani
        ),
        mapOf(
            "age" to "85",
            "name" to "Fw De Klerk",
            "message" to "He died having so much kids",
            "image" to R.drawable.deklerk
        ),
        mapOf(
            "age" to "33",
            "name" to "Jesus Christ",
            "message" to "No one comes to the father except through me.",
            "image" to R.drawable.jesus
        ),
        mapOf(
            "age" to "90",
            "name" to "Desmond Tutu",
            "message" to "We need to go upstream and find out why they’re falling in.",
            "image" to R.drawable.tutu
        ),
        mapOf(
            "age" to "43",
            "name" to "Chadwick Boseman",
            "message" to "Nobody has to give me permission to write.",
            "image" to R.drawable.chadwick
        ),
        mapOf(
            "age" to "28",
            "name" to "Heath Ledger",
            "message" to "If you’re good at something, never do it for free.",
            "image" to R.drawable.heath
        ),

        )



    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//liniking
        buttonSubmit = findViewById(R.id.buttonSubmit)
        buttonClear = findViewById(R.id.buttonClear)
        inPut = findViewById(R.id.enter)
        name = findViewById(R.id.name)
        age = findViewById(R.id.age)
        head = findViewById(R.id.head)
        writing = findViewById(R.id.writing)
        image = findViewById(R.id.image)
        picture = findViewById(R.id.picture)

        // Starting values
        name.text = "Warning!!"
        writing.text = "Welcome to the place where your age killed people..."

//IntCheck
        fun intCheck(toCheck: String): Boolean {
            return toCheck.toIntOrNull() != null
        }

        buttonClear.setOnClickListener {
            inPut.text.clear()
            name.text = ""
            age.text = ""
            writing.text = "Entering your Age might just kill someone again"
            head.text = "Death"

            picture.setImageResource(R.drawable.joker)
            image.setImageResource(R.drawable.beg)

        }




        buttonSubmit.setOnClickListener {
            answer = inPut.text.toString()

            //Check if its an Int
            isInt = intCheck(answer)
            println("This is int $isInt")

            if (isInt != false) {

                intAnswer = answer.toInt()

//Age check
                if (intAnswer < 20 || intAnswer > 100) {
                    age.text = ""
                    name.text = "Sorry"
                    writing.text = "You can't enter age less than 20 or greater than 100"
                    image.setImageResource(R.drawable.wrongway)
                    picture.setImageResource(R.drawable.wrongway)

                }else{
                //ELSE HERE


                if (ages.any { it["age"] == answer }) {

                    val index = ages.indexOfFirst { it["age"] == answer }
                    val namex: String = ages[index]["name"].toString()
                    val agex: String = ages[index]["age"].toString()
                    val messagex: String = ages[index]["message"].toString()


                    //Set the text to display in the Card
                    head.text = ""
                    name.text = "$namex"
                    age.text = "Died at the age of $agex"
                    writing.text = "'$messagex'"
                    image.setImageResource(ages[index]["image"] as Int)
                    picture.setImageResource(ages[index]["image"] as Int)

                    // Assist with error checking
                    println("This is the Name : $namex")
                    println("This is the Age : $agex")
                    println("$messagex")
                } else {
                    //No age at that number
                    println("No record found")
                    age.text = ""
                    head.text = ""
                    name.text = "Sorry"
                    writing.text = "No record found for that age "
                    image.setImageResource(R.drawable.no)
                    picture.setImageResource(R.drawable.no)
                }

            }

            }else{
                //Wrong number Instruction
                age.text = ""
                head.text = ""
                name.text = "Dont be Silly"
                writing.text = "Please enter whole numbers only"
                image.setImageResource(R.drawable.wrongway)
                picture.setImageResource(R.drawable.wrongway)
            }
        }
    }
}