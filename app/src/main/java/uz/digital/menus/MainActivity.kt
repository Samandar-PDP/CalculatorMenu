package uz.digital.menus

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.PopupMenu
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.MenuProvider

class MainActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {
    private lateinit var constraintLayout: ConstraintLayout
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        constraintLayout = findViewById(R.id.con)
        button = findViewById(R.id.btn)
        button.setOnClickListener {
            val popupMenu = PopupMenu(this, it)
            popupMenu.menuInflater.inflate(R.menu.color_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(this)
            popupMenu.show()
        }
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.blue -> {
                changeBackColor(android.R.color.holo_blue_dark)
            }
            R.id.red -> {
                changeBackColor(android.R.color.holo_red_dark)
            }
            R.id.green -> {
                changeBackColor(android.R.color.holo_green_dark)
            }
        }
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.color_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.blue -> {
                changeBackColor(android.R.color.holo_blue_dark)
            }
            R.id.red -> {
                changeBackColor(android.R.color.holo_red_dark)
            }
            R.id.green -> {
                changeBackColor(android.R.color.holo_green_dark)
            }
        }
        return true
    }

    private fun changeBackColor(color: Int) {
        constraintLayout.setBackgroundColor(ContextCompat.getColor(this, color))
    }
}