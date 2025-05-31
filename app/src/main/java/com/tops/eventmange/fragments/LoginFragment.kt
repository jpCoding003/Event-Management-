package com.tops.eventmange.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tops.eventmange.DrawerDashboardActivity
import com.tops.eventmange.R
import com.tops.eventmange.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (isFormValid()){
            binding.login.isEnabled= true

        }else{
        //ignore
        }

        binding.login.setOnClickListener {
            ///Next Activity
            val intent = Intent(context, DrawerDashboardActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isFormValid(): Boolean{
        var isValid = true
        if(!Patterns.EMAIL_ADDRESS.matcher(binding.email.text.toString()).matches()){
            isValid = false
            binding.email.setError("Enter valid Email")
        }else{
            binding.email.setError(" ")
        }

        if(binding.password.text.toString().isEmpty()){
            isValid = false
            binding.password.setError("Enter valid Email")
        }else{
            binding.password.setError(" ")
        }
        return isValid
    }
}