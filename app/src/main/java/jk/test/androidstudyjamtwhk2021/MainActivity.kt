package jk.test.androidstudyjamtwhk2021

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_happy_birthday.setOnClickListener {
            startActivity(Intent(this, HappyBirthdayActivity::class.java))
        }

        btn_dice_roll.setOnClickListener {
            startActivity(Intent(this, DiceRollerActivity::class.java))
        }

        btn_tip_time.setOnClickListener {
            startActivity(Intent(this, TipTimeActivity::class.java))
        }
    }
}