package jk.test.androidstudyjamtwhk2021

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import jk.test.androidstudyjamtwhk2021.adapter.ItemAdapter
import jk.test.androidstudyjamtwhk2021.data.Datasource
import kotlinx.android.synthetic.main.activity_affirmations.*

class AffirmationsActivity : AppCompatActivity() {

    private val adapter = ItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_affirmations)
        title = resources.getString(R.string.affirmations)

        recycler_view.adapter = adapter
        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recycler_view.setHasFixedSize(true)

        adapter.submitList(Datasource().loadAffirmations())
    }
}