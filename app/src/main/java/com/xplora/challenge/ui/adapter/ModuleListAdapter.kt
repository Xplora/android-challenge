package com.xplora.challenge.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xplora.challenge.databinding.ItemModuleListBinding
import com.xplora.challenge.model.ModulesItem

class ModuleListAdapter(
    private val moduleList: List<ModulesItem?>?,
    private val onItemClick: (ModulesItem?) -> (Unit),
) : RecyclerView.Adapter<ModuleListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemModuleListBinding = ItemModuleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemModuleListBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.dataModel = moduleList?.get(position)
        holder.itemView.setOnClickListener {
            onItemClick.invoke(moduleList?.get(position))
        }
    }

    override fun getItemCount(): Int = moduleList?.size ?: 0

    class ViewHolder(val binding: ItemModuleListBinding) : RecyclerView.ViewHolder(binding.root)
}