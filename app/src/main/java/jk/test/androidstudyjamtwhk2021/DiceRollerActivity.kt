package jk.test.androidstudyjamtwhk2021

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dice_roller.*

class DiceRollerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller)
        title = resources.getString(R.string.dice_roller)

        val myDice = Dice(6)
        var current = 1

        btn_roll.setOnClickListener {
            current = myDice.roll(current)
            val imageResource = when (current) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            iv_dice.setImageResource(imageResource)
        }
    }
}