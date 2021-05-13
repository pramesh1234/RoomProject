package com.famco.roomproject.ui.reptile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.famco.roomproject.dialog.AddReptileFragment
import com.famco.roomproject.R
import com.famco.roomproject.adapters.AnimalAdapter
import com.famco.roomproject.adapters.IAnimalClickAdapter
import com.famco.roomproject.model.ReptileModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ReptileFragment : Fragment(), IAnimalClickAdapter {

    private lateinit var reptileViewModel: ReptileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        reptileViewModel =
            ViewModelProvider(this).get(ReptileViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_reptile, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.reptiles_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = context?.let { AnimalAdapter(it, this) }
        recyclerView.adapter = adapter
        reptileViewModel.allReptile.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter?.updateList(it)
            }

        })
        val floatBtn = root.findViewById<FloatingActionButton>(R.id.open_fragment)
        floatBtn.setOnClickListener {
            val args = Bundle()
            args.putString("key", "value")
            val addReptileFragment: DialogFragment = AddReptileFragment()
            addReptileFragment.arguments = args
            this.fragmentManager?.let { it1 -> addReptileFragment.show(it1, "TAG") }
        }


        return root
    }

    override fun onItemClick(reptile: ReptileModel) {
        Toast.makeText(context, "${reptile.reptileName} deleted", Toast.LENGTH_SHORT).show()
        reptileViewModel.deleteAnimal(reptile)
    }


}