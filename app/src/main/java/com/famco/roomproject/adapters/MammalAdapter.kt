package com.famco.roomproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.famco.roomproject.R
import com.famco.roomproject.model.MammalModel

class MammalAdapter(private val context: Context, private val listener: IMammalClickAdapter) : RecyclerView.Adapter<MammalAdapter.MammalViewHolder>() {
    private val allMammals = ArrayList<MammalModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MammalViewHolder {
        val viewHolder=MammalViewHolder(LayoutInflater.from(context).inflate(R.layout.row_animal,parent,false))
        viewHolder.deleteAnimalBtn.setOnClickListener{
            listener.onItemClick(allMammals[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: MammalViewHolder, position: Int) {
        val currentAnimalModel=allMammals[position]
        holder.animalNameTextView.text=currentAnimalModel.mammalName
        holder.animalSpeciesTextView.text=currentAnimalModel.mammalSpecies
    }

    override fun getItemCount(): Int {
        return allMammals.size
    }
    inner class MammalViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val animalNameTextView: TextView = itemView.findViewById<TextView>(R.id.animal_name)
        val animalSpeciesTextView: TextView =itemView.findViewById<TextView>(R.id.animal_species)
        val deleteAnimalBtn: ImageView =itemView.findViewById<ImageView>(R.id.delete_btn)
    }
    fun updateList(newList:List<MammalModel>){
        allMammals.clear()
        allMammals.addAll(newList)
        notifyDataSetChanged()
    }

}

interface IMammalClickAdapter{
    fun onItemClick(mammal: MammalModel)
}