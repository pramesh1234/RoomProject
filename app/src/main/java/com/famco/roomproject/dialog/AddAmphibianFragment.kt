package com.famco.roomproject.dialog

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.famco.roomproject.R
import com.famco.roomproject.model.AmphibianModel
import com.google.android.material.textfield.TextInputEditText

class AddAmphibianFragment : DialogFragment() {


    private lateinit var viewModel: AddAmphibianViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(AddAmphibianViewModel::class.java)

        val root = inflater.inflate(R.layout.add_amphibian_fragment, container, false)
        val submitBtn = root.findViewById<Button>(R.id.submit_btn)
        submitBtn.setOnClickListener {

            val nameEt = root.findViewById<TextInputEditText>(R.id.name)
            val speciesEt = root.findViewById<TextInputEditText>(R.id.species)

            val animalName = nameEt.text.toString()
            val animalSpecies = speciesEt.text.toString()
            val animal = AmphibianModel(animalName, animalSpecies)
            viewModel.insertAmphibian(animal)
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