package kz.aliw7182.room.fragments.update

import android.os.Bundle
import android.os.TokenWatcher
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*
import kz.aliw7182.room.R
import kz.aliw7182.room.model.User
import kz.aliw7182.room.viewmodel.UserViewModel

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_update, container, false)
        view.name_update.setText( args.currentUser.firstName)
        view.lastName_update.setText(args.currentUser.lastName)
        view.age_update.setText(args.currentUser.age.toString())
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        view.update_btn.setOnClickListener {
            updateItem()
        }
        return view
    }
    private fun updateItem(){
        val firstName = name_update.text.toString()
        val lastName = lastName_update.text.toString()
        val age = Integer.parseInt(age_update.text.toString())
        if(checkInput(firstName,lastName,age_update.text)){
            val updatedUser = User(args.currentUser.id,firstName,lastName,age)
            mUserViewModel.updateUser(updatedUser)
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
            Toast.makeText(requireContext(),"Success",Toast.LENGTH_SHORT).show()

            }
        else{
            Toast.makeText(requireContext(),"fill out all fields",Toast.LENGTH_SHORT).show()
        }

    }
    private fun checkInput(name: String,lastName:String,age: Editable):Boolean {
        return !(TextUtils.isEmpty(name)&& TextUtils.isEmpty(lastName)&&age.isEmpty())
    }


}