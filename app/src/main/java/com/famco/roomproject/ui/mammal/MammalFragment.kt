package com.famco.roomproject.ui.mammal

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
import com.famco.roomproject.dialog.AddMammalFragment
import com.famco.roomproject.R
import com.famco.roomproject.adapters.IMammalClickAdapter
import com.famco.roomproject.adapters.MammalAdapter
import com.famco.roomproject.model.MammalModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MammalFragment : Fragment(),IMammalClickAdapter {

    private lateinit var mammalViewModel: MammalViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mammalViewModel =
                ViewModelProvider(this).get(MammalViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_mammal, container, false)
        val recyclerView=root.findViewById<RecyclerView>(R.id.mammal_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = context?.let { MammalAdapter(it, this) }
        recyclerView.adapter = adapter
        mammalViewModel.allMammals.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter?.updateList(it)
            }

        })
        val floatBtn=root.findViewById<FloatingActionButton>(R.id.open_fragment)
        floatBtn.setOnClickListener {
            val args = Bundle()
            args.putString("key", "value")
            val addMammalFragment: DialogFragment = AddMammalFragment()
            addMammalFragment.arguments = args
            this.fragmentManager?.let { it1 -> addMammalFragment.show(it1, "TAG") }
        }

        return root
    }

    override fun onItemClick(mammal: MammalModel) {
        Toast.makeText(context, "${mammal.mammalName} deleted", Toast.LENGTH_SHORT).show()
        mammalViewModel.deleteMammal(mammal)
    }
}