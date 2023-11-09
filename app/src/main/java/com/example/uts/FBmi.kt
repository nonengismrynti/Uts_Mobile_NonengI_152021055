package com.example.uts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.uts.databinding.FragmentFBmiBinding
import kotlin.math.pow

class FBmi : Fragment() {

    private lateinit var binding: FragmentFBmiBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFBmiBinding.inflate(inflater,container,false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.calculateBtn.setOnClickListener{
            calculateBMI()
        }
    }

    private fun calculateBMI(){
        val weight = binding.weightEdit.text.toString().toFloatOrNull()
        val height = binding.heightEdit.text.toString().toFloatOrNull()

        if (weight != null && height != null){
            val bmi = weight/(height/100).pow(2)
            val bmiResult = String.format("%.2f",bmi)

            val bmiCategory = when {
                bmi < 18.5 -> "Berat Rendah"
                bmi < 25 -> "Berat Ideal"
                bmi < 30 -> "Overweight"
                else -> "Obesitas"
            }
            binding.resultText.text = "BMI : $bmiResult\nCategory : $bmiCategory"
        }else {
            binding.resultText.text = "Data tidak valid"
        }
    }

}