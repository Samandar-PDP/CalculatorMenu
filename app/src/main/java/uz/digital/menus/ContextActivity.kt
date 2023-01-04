package uz.digital.menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class ContextActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private val languageList =
        listOf("Android", "IOS", "Flutter", "Kotlin", "Java", "Swift", "Dart", "JavaScript")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context)
        listView = findViewById(R.id.listView)

        val arrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, languageList)
        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, languageList[position], Toast.LENGTH_SHORT).show()
        }
        registerForContextMenu(listView)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.color_menu, menu)
        menu?.setHeaderTitle("Title")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this, item.title.toString(), Toast.LENGTH_SHORT).show()
        return true
    }
}