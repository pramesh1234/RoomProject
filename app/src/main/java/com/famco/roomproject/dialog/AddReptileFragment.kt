package com.famco.roomproject.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.famco.roomproject.R
import com.famco.roomproject.model.ReptileModel
import com.google.android.material.textfield.TextInputEditText

class AddReptileFragment : DialogFragment() {

    private lateinit var addReptileViewModel: AddReptileViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addReptileViewModel =
            ViewModelProvider(this).get(AddReptileViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_add_reptile, container, false)
        val submitBtn = root.findViewById<Button>(R.id.submit_btn)
        submitBtn.setOnClickListener {

            val nameEt = root.findViewById<TextInputEditText>(R.id.name)
            val speciesEt = root.findViewById<TextInputEditText>(R.id.species)

            val animalName = nameEt.text.toString()
            val animalSpecies = speciesEt.text.toString()
            val animal = ReptileModel(animalName, animalSpecies)
            addReptileViewModel.insertAnimal(animal)
            dialog?.dismiss()
        }

        return root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window
            ?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

    }

}