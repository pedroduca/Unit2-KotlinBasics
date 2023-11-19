package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/*
* Essa Activity permite o usuário jogar os dados e ver o resultado
* na tela
* */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /*
    * Rolar os dados e atualizar a tela com o resultado
    * */
    private fun rollDice() {
        // cria um novo dado de 6 lados e rola
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // atualiza a tela com o resultado do dado após jogá-lo
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}