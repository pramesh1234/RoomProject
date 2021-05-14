package com.famco.roomproject.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.famco.roomproject.R
import com.famco.roomproject.model.MammalModel
import com.google.android.material.textfield.TextInputEditText

class AddMammalFragment : DialogFragment() {

    lateinit var addMammalViewmodel: AddMammalViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addMammalViewmodel =
            ViewModelProvider(this).get(AddMammalViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_add_mammal, container, false)
        val submitBtn = root.findViewById<Button>(R.id.submit_btn)
        submitBtn.setOnClickListener {

            val nameEt = root.findViewById<TextInputEditText>(R.id.name)
            val speciesEt = root.findViewById<TextInputEditText>(R.id.species)

            val mammalName = nameEt.text.toString()
            val mammalSpecies = speciesEt.text.toString()
            if (mammalName.isNotBlank() and mammalSpecies.isNotBlank()) {
                val mammal = MammalModel(mammalName, mammalSpecies)
                addMammalViewmodel.insertMammal(mammal)
                dialog?.dismiss()
            }
            else{
                Toast.makeText(context, "Above fields are empty", Toast.LENGTH_SHORT).show()
            }
        }
        return root

    }

    override fun onStart() {
        super.onStart()
        dialog?.window
            ?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

}