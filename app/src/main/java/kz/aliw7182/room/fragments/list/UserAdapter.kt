package kz.aliw7182.room.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_user.view.*
import kz.aliw7182.room.R
import kz.aliw7182.room.model.User

class UserAdapter: RecyclerView.Adapter<UserViewHolder>() {
    private var userList = emptyList<User>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false))
    }


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.item_id.text = currentItem.id.toString()
        holder.itemView.item_name.text = currentItem.firstName
        holder.itemView.item_lastname.text = currentItem.lastName
        holder.itemView.item_age.text = currentItem.age.toString()
        holder.itemView.root_items.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }


    override fun getItemCount(): Int {
        return userList.size
    }
    fun setData(user:List<User>){
        this.userList = user
        notifyDataSetChanged()
    }

}

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


}
