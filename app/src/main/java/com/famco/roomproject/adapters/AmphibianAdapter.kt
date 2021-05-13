package com.famco.roomproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.famco.roomproject.R
import com.famco.roomproject.model.AmphibianModel

class AmphibianAdapter(private val context: Context, private val listener: IAmphibianClickAdapter) :
    RecyclerView.Adapter<AmphibianAdapter.AmphibianViewHolder>() {
    private val allAmphibian = ArrayList<AmphibianModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmphibianViewHolder {
        val viewHolder = AmphibianViewHolder(
            LayoutInflater.from(context).inflate(R.layout.row_animal, parent, false)
        )
        viewHolder.deleteAnimalBtn.setOnClickListener {
            listener.onItemClick(allAmphibian[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: AmphibianViewHolder, position: Int) {
        val currentAmphibianMoel = allAmphibian[position]
        holder.animalNameTextView.text = currentAmphibianMoel.amphibianName
        holder.animalSpeciesTextView.text = currentAmphibianMoel.amphibianSpecies
    }

    override fun getItemCount(): Int {
        return allAmphibian.size
    }

    inner class AmphibianViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val animalNameTextView: TextView = itemView.findViewById<TextView>(R.id.animal_name)
        val animalSpeciesTextView: TextView = itemView.findViewById<TextView>(R.id.animal_species)
        val deleteAnimalBtn: ImageView = itemView.findViewById<ImageView>(R.id.delete_btn)
    }

    fun updateList(newList: List<AmphibianModel>) {
        allAmphibian.clear()
        allAmphibian.addAll(newList)
        notifyDataSetChanged()
    }

}

interface IAmphibianClickAdapter {
    fun onItemClick(amphibian: AmphibianModel)
}