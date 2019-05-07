package me.indiq.dev.indiqme.Activities

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import me.indiq.dev.indiqme.Fragments.IndicadoFragment
import me.indiq.dev.indiqme.Fragments.ManutencaoFragment
import me.indiq.dev.indiqme.Fragments.PerfilFragment
import me.indiq.dev.indiqme.R

class HomeActivity : BaseActivity() {


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_indicado -> {
                supportActionBar?.title = "Indicado"
                val indicadoFragment = IndicadoFragment.newInstance()
                openFragment(indicadoFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_manutencao -> {
                supportActionBar?.title = "Manutencão"
                val manutencaoFragment = ManutencaoFragment.newInstance()
                openFragment(manutencaoFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_perfil -> {
                supportActionBar?.title = "Perfil"
                val perfilFragment = PerfilFragment.newInstance()
                openFragment(perfilFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupToolbar(getString(R.string.app_name))

        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        //abaixo é o codigo para definir em qual fragment o aplicativo deve iniciar.
        supportActionBar?.title = "Indicado"
        val indicadoFragment = IndicadoFragment.newInstance()
        openFragment(indicadoFragment)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}
