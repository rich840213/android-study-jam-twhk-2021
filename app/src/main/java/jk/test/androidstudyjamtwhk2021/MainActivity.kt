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

        btn_affirmations.setOnClickListener {
            startActivity(Intent(this, AffirmationsActivity::class.java))
        }

        btn_navigation.setOnClickListener {
            startActivity(Intent(this, NavigationActivity::class.java))
        }

        btn_unscramble.setOnClickListener {
            startActivity(Intent(this, UnscrambleActivity::class.java))
        }

        btn_cupcake.setOnClickListener {
            startActivity(Intent(this, CupcakeActivity::class.java))
        }
    }
}