package com.example.qrtest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qrtest.databinding.UserItemBinding
import com.example.qrtest.model.User

class UserAdapter(private var userList: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserAdapter.UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = UserItemBinding.inflate(layoutInflater)
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setList(newList: List<User>) {
        userList = newList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    inner class UserViewHolder(private val binding: UserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: User) {
            binding.tvUserId.text = item.userId.toString()
            binding.tvEmployeeId.text = item.employeeId
            binding.tvDepartment.text = item.department
            binding.tvName.text = item.name
            binding.tvPhonenumber.text = item.phoneNumber

            binding.tvDefaultcarId.text = item.defaultCarId.toString()
            //binding.tvDescription.text = item.description
        }
    }
}