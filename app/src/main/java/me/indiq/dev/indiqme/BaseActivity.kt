package me.indiq.dev.indiqme

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem

open class BaseActivity : AppCompatActivity() {

    fun setupToolbar(title: String) {
        val toolbar = findViewById<Toolbar>(R.id.default_toolbar)
        if (toolbar != null) {
            setSupportActionBar(toolbar)
        }
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item?.itemId == android.R.id.home) {
            finish()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }
}