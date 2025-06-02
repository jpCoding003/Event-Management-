package com.tops.eventmange.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.tops.eventmange.DrawerDashboardActivity
import com.tops.eventmange.R
import com.tops.eventmange.databinding.FragmentIntroBinding


class IntroFragment : Fragment() {

    private lateinit var binding: FragmentIntroBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding = FragmentIntroBinding.inflate(inflater, container,false)
        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_intro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = activity?.getSharedPreferences(getString(R.string.app_name),Context.MODE_PRIVATE)
        val IS_LOGIN = "IS_LOGIN"
        val isLogin= sharedPref?.getBoolean(IS_LOGIN,false)
        // SharedPreferences :- Save data in Local Database-(In Device Only)
        // To checkk data manually as a developer-> goto "Device Manager"-> click ":" three dots
        // Now goto-> Data -> data -> find your package name -> fid Shared-preference ->
        // ---> ( File name given to shared preferences )== here we have given as app_name("EventMange")


        binding.btnstart.setOnClickListener {
            if (isLogin == true){
                val intent = Intent(context, DrawerDashboardActivity::class.java)
                startActivity(intent)
            }else {
                activity?.supportFragmentManager?.commit {
                    setReorderingAllowed(true)
                    replace<LoginFragment>(R.id.mainactivity_fragment)
                }
            }
        }
    }
}