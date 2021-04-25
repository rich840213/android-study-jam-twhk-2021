package jk.test.androidstudyjamtwhk2021

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class UnscrambleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unscramble)
        title = resources.getString(R.string.unscramble)
    }
}