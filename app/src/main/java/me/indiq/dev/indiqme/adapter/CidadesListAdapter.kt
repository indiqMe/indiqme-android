package me.indiq.dev.indiqme.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import me.indiq.dev.indiqme.R

class CidadesListAdapter(mContext: Context, lista: List<Pair<String, String>>) : ArrayAdapter<Pair<String, String>>(
    mContext, -1, lista
) {

    init {

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = LayoutInflater.from(context).inflate(R.layout.cidade_list_item, parent, false)

        view.findViewById<TextView>(R.id.tv_cidade).text = getItem(position)!!.first
        view.findViewById<TextView>(R.id.tv_estado).text = getItem(position)!!.second

        return view;

    }
}