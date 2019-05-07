package me.indiq.dev.indiqme.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import me.indiq.dev.indiqme.R
import me.indiq.dev.indiqme.adapter.TecnologiaListAdapter
import me.indiq.dev.indiqme.listeners.TecnologiaSelectListener
import me.indiq.dev.indiqme.viewmodel.RegistroViewModel

class RegistroTecnologias : Fragment(), TecnologiaSelectListener {

    // TODO: get from API
    val tecnologiasList =
        listOf("JAVA", "C#", "PYTHON", "JAVA SCRIPT", "TYPE SCRIPT", "ANDROID", "IOS", "ANGULAR", "REACT", "VUE")

    val viewModel: RegistroViewModel by lazy {
        ViewModelProviders.of(activity!!).get(RegistroViewModel::class.java)
    }

    val adapter: TecnologiaListAdapter by lazy {
        TecnologiaListAdapter(activity!!.applicationContext, tecnologiasList, this@RegistroTecnologias)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_registro_tecnologias, container, false)

        val lv = view.findViewById<ListView>(R.id.listview_tecnolias)
        lv.adapter = adapter
        adapter.setCheckedItems(viewModel.tecnologias)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.subtitle = "Tecnologias" // TODO: find a generic way to set title
    }

    override fun onSelectTecnologia(tecnologia: String, selected: Boolean) {
        viewModel.tecnologias = adapter.getCheckedItems()
    }
}
