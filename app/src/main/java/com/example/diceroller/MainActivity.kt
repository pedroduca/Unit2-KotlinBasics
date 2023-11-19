package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

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

        rollDice()
    }

    /*
    * Rolar os dados e atualizar a tela com o resultado
    * */
    private fun rollDice() {
        // cria um novo dado de 6 lados e rola
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // atualiza a tela com o resultado do dado após jogá-lo
        val diceImage: ImageView = findViewById(R.id.imageView)

        val drawableResource = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else  -> R.drawable.dice_6

        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription= diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}