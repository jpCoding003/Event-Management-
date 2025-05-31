package com.tops.eventmange.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.tops.eventmange.R
import com.tops.eventmange.databinding.FragmentIntroBinding


class IntroFragment : Fragment() {

    private lateinit var binding: FragmentIntroBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding = FragmentIntroBinding.inflate(layoutInflater)
        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_intro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnstart.setOnClickListener {

            activity?.supportFragmentManager?.commit {
                setReorderingAllowed(true)
                replace<LoginFragment>(R.id.mainactivity_fragment)
                disallowAddToBackStack()
            }

        }
    }
}