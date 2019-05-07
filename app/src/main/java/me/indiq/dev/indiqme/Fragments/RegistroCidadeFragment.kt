package me.indiq.dev.indiqme.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import me.indiq.dev.indiqme.R
import me.indiq.dev.indiqme.adapter.CidadesListAdapter
import me.indiq.dev.indiqme.viewmodel.RegistroViewModel

class RegistroCidadeFragment : Fragment() {

    val viewModel: RegistroViewModel by lazy {
        ViewModelProviders.of(activity!!).get(RegistroViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_registro_cidade, container, false)

        // TODO: criar model para cidade
        val lista = listOf(
            Pair("SÃO PAULO", "SÃO PAULO"),
            Pair("BELHO HORIZONTE", "MINAS GERAIS"),
            Pair("RIO DE JANEIRO", "RIO DE JANEIRO"),
            Pair("FLORIANÓPOLIS", "SANTA CATARINA"),
            Pair("SALVADOR", "BAHIA"),
            Pair("BARREIRAS", "BAHIA")
        ) // TODO: get from API

        val listView = view.findViewById<ListView>(R.id.listview_cidades)
        val adapter = CidadesListAdapter(activity!!.applicationContext, lista)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            val cidade = adapter.getItem(position) // TODO: salvar cidade no modelo

            this@RegistroCidadeFragment.activity!!
                .findNavController(R.id.nav_host_fragment)
                .navigate(R.id.action_go_registro_linkedin)

            viewModel.pushPage()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.subtitle = "Cidade" // TODO: find a generic way to set title
    }
}
