package jk.test.androidstudyjamtwhk2021

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class HappyBirthdayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_happy_birthday)
        title = resources.getString(R.string.happy_birthday)
    }
}