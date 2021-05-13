package com.famco.roomproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.famco.roomproject.R
import com.famco.roomproject.model.ReptileModel

class AnimalAdapter(private val context:Context, private val listener: IAnimalClickAdapter) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {
private val allAnimals = ArrayList<ReptileModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
      val viewHolder=AnimalViewHolder(LayoutInflater.from(context).inflate(R.layout.row_animal,parent,false))
        viewHolder.deleteAnimalBtn.setOnClickListener{
            listener.onItemClick(allAnimals[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val currentAnimalModel=allAnimals[position]
        holder.animalNameTextView.text=currentAnimalModel.reptileName
        holder.animalSpeciesTextView.text=currentAnimalModel.reptileSpecies
    }

    override fun getItemCount(): Int {
        return allAnimals.size
    }
    inner class AnimalViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val animalNameTextView: TextView = itemView.findViewById<TextView>(R.id.animal_name)
        val animalSpeciesTextView: TextView =itemView.findViewById<TextView>(R.id.animal_species)
        val deleteAnimalBtn: ImageView =itemView.findViewById<ImageView>(R.id.delete_btn)
    }
    fun updateList(newList:List<ReptileModel>){
        allAnimals.clear()
        allAnimals.addAll(newList)
        notifyDataSetChanged()
    }

}

interface IAnimalClickAdapter{
    fun onItemClick(reptile:ReptileModel)
}