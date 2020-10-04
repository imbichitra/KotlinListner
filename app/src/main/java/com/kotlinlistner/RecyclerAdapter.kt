package com.kotlinlistner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_layout.view.*

class RecyclerAdapter(private var mContext: Context, private var empList: List<EmpModelClass>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(mContext).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return empList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(empList[position])
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bindItems(emp: EmpModelClass) {
            itemView.text_id.text =  emp.userId.toString()
            itemView.text_name.text = emp.userName
            itemView.text_email.text = emp.userEmail
        }
    }

}