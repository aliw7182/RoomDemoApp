package kz.aliw7182.room.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*
import kz.aliw7182.room.R
import kz.aliw7182.room.model.User
import kz.aliw7182.room.viewmodel.UserViewModel

class AddFragment : Fragment() {
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        view.add_button.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val name = name_input.text.toString()
        val lastName = lastName_input.text.toString()
        val age = age_input.text
        if(checkInput(name,lastName,age)){
            mUserViewModel.addUser(User(0,name,lastName,Integer.parseInt(age.toString())))
            Toast.makeText(requireContext(),"Succesfully added!",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
        else{
            Toast.makeText(requireContext(),"Fill empty blanks",Toast.LENGTH_LONG).show()
        }


    }
    private fun checkInput(name: String,lastName:String,age:Editable):Boolean {
        return !(TextUtils.isEmpty(name)&&TextUtils.isEmpty(lastName)&&age.isEmpty())
    }

}