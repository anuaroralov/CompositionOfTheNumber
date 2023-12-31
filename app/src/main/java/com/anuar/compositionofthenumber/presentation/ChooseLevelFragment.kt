package com.anuar.compositionofthenumber.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.anuar.compositionofthenumber.databinding.FragmentChooseLevelBinding
import com.anuar.compositionofthenumber.domain.entity.Level

class ChooseLevelFragment : Fragment() {
    private var _binding: FragmentChooseLevelBinding?=null
    private val binding: FragmentChooseLevelBinding
        get() = _binding ?:throw RuntimeException("FragmentChooseLevelBinding==null")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentChooseLevelBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonLevelEasy.setOnClickListener{
            launchGameFragment(Level.EASY)
        }
        binding.buttonLevelMedium.setOnClickListener{
            launchGameFragment(Level.MEDIUM)
        }
        binding.buttonLevelHard.setOnClickListener{
            launchGameFragment(Level.HARD)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    private fun launchGameFragment(level: Level){
        findNavController().navigate(ChooseLevelFragmentDirections.actionChooseLevelFragmentToGameFragment(level))
    }
}