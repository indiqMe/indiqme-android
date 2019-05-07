package me.indiq.dev.indiqme.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import androidx.appcompat.widget.AppCompatCheckBox
import me.indiq.dev.indiqme.R
import me.indiq.dev.indiqme.listeners.TecnologiaSelectListener

/**
 * @author andrauss
 *
 * TODO: converter para RecyclerView (caso necessário)
 */
class TecnologiaListAdapter(
    mContext: Context,
    lista: List<String>,
    listener: TecnologiaSelectListener
) :
    ArrayAdapter<String>(
        mContext, -1, lista
    ) {

    val mListener = listener
    val mSelectionMap: MutableMap<String, Boolean> = mutableMapOf()

    init {

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.tecnologias_list_item, parent, false)

        val tecnologia = getItem(position)

        if (tecnologia != null) {
            view.findViewById<TextView>(R.id.tv_tecnologia).text = tecnologia
            val checkbox = view.findViewById<CheckBox>(R.id.chk_tecnologia);

            checkbox.setOnCheckedChangeListener { _, checked ->
                mSelectionMap[tecnologia] = checked
                mListener.onSelectTecnologia(tecnologia, checked)
            }

            view.setOnClickListener {
                checkbox.isChecked = !isItemChecked(tecnologia)
                mSelectionMap[tecnologia] = checkbox.isChecked
                mListener.onSelectTecnologia(tecnologia, checkbox.isChecked)
            }

            checkbox.isChecked = isItemChecked(tecnologia)
        }

        return view
    }

    fun getCheckedItems(): List<String> {
        return (mSelectionMap.filter { it.value }.keys.toMutableList())
    }

    fun setCheckedItems(items: List<String>) {
        this.mSelectionMap.clear()
        this.mSelectionMap.putAll(items.map { Pair(it, true) })
        notifyDataSetChanged()
    }

    fun isItemChecked(tecnologia: String): Boolean {
        return mSelectionMap.get(tecnologia) ?: false
    }
}