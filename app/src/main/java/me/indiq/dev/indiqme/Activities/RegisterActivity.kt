package me.indiq.dev.indiqme.Activities

import android.app.Activity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import androidx.navigation.NavigatorProvider
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_register.*
import me.indiq.dev.indiqme.R
import me.indiq.dev.indiqme.viewmodel.RegistroViewModel

class RegisterActivity : BaseActivity() {

    val viewModel: RegistroViewModel by lazy {
        ViewModelProviders.of(this).get(RegistroViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setupToolbar(getString(R.string.cadastre_se))

        viewModel.currentPageLiveData().observe(this, Observer {
            text_etapa.text = "Etapa $it de 5"

            btn_voltar.visibility = (if (it == 1) View.GONE else View.VISIBLE)
            btn_avancar.visibility = (if (it == 5) View.GONE else View.VISIBLE)
            btn_concluir.visibility = (if (it == 5) View.VISIBLE else View.GONE)
        })

        btn_avancar.setOnClickListener {
            val nextAction = getActionByEtapa(viewModel.getCurrentPage() + 1)
            findNavController(R.id.nav_host_fragment).navigate(nextAction)
            viewModel.pushPage()
        }

        btn_voltar.setOnClickListener {
            viewModel.popPage()
            findNavController(R.id.nav_host_fragment).popBackStack()
        }


        findNavController(R.id.nav_host_fragment).addOnDestinationChangedListener { controller, destination, arguments ->
            val etapa = getEtapaNumberForId(destination.id)
            viewModel.setCurrentPage(etapa)
        }
    }

    fun getActionByEtapa(etapa: Int): Int {
        return when (etapa) {
            2 -> R.id.action_go_registro_cidade
            3 -> R.id.action_go_registro_linkedin
            4 -> R.id.action_go_registro_tecnologias
            5 -> R.id.action_go_registro_senha
            else -> 1
        }
    }

    fun getEtapaNumberForId(id: Int): Int {
        return when (id) {
            R.id.registroDadosIniciaisFragment -> 1
            R.id.registroCidadeFragment -> 2
            R.id.registroLinkedin -> 3
            R.id.registroTecnologias -> 4
            else -> 5
        }
    }


}
