package com.tops.eventmange.fragments

import android.content.Context
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

val IS_LOGIN = "IS_LOGIN"
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.login.setOnClickListener {

            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            if(email == "") {
                binding.email.error = "Required!!!"
                return@setOnClickListener
            }
            if(password == "") {
                binding.password.error = "Required!!!"
                return@setOnClickListener
            }

            val sharedPref = activity?.getSharedPreferences(getString(R.string.app_name)
                ,Context.MODE_PRIVATE)?: return@setOnClickListener

            with (sharedPref.edit()) {
                putBoolean(IS_LOGIN, true)
                apply()
            }

            val intent = Intent(context, DrawerDashboardActivity::class.java)
            startActivity(intent)
        }

         }

//    private fun isFormValid(): Boolean{
//        var isValid = true
//        if(!Patterns.EMAIL_ADDRESS.matcher(binding.email.text.toString()).matches()){
//            isValid = false
//            binding.email.setError("Enter valid Email")
//        }else{
//            binding.email.setError(" ")
//        }
//
//        if(binding.password.text.toString().isEmpty()){
//            isValid = false
//            binding.password.setError("Enter valid Email")
//        }else{
//            binding.password.setError(" ")
//        }
//        return isValid
//    }
//    }
}