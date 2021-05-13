package com.famco.roomproject.ui.amphibian

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
import com.famco.roomproject.AddAmphibianFragment
import com.famco.roomproject.R
import com.famco.roomproject.adapters.AmphibianAdapter
import com.famco.roomproject.adapters.IAmphibianClickAdapter
import com.famco.roomproject.model.AmphibianModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AmphibianFragment : Fragment(),IAmphibianClickAdapter {

    private lateinit var amphibianViewModel: AmphibianViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        amphibianViewModel =
                ViewModelProvider(this).get(AmphibianViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_amphibian, container, false)
        val recyclerView=root.findViewById<RecyclerView>(R.id.amphibian_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = context?.let { AmphibianAdapter(it, this) }
        recyclerView.adapter = adapter
        amphibianViewModel.allAmphibian.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter?.updateList(it)
            }

        })
        val floatBtn=root.findViewById<FloatingActionButton>(R.id.open_fragment)
        floatBtn.setOnClickListener {
            val args = Bundle()
            args.putString("key", "value")
            val addAmphibianFragment: DialogFragment = AddAmphibianFragment()
            addAmphibianFragment.arguments = args
            this.fragmentManager?.let { it1 -> addAmphibianFragment.show(it1, "TAG") }
        }

        return root
    }

    override fun onItemClick(amphibian: AmphibianModel) {
        Toast.makeText(context, "${amphibian.amphibianName} deleted", Toast.LENGTH_SHORT).show()
        amphibianViewModel.deleteAmphibian(amphibian)
    }
}