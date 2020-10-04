package com.kotlinlistner

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var empList :MutableList<EmpModelClass>?=null
    private var adapter :RecyclerAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        empList = ArrayList()
        getEmp()
        fab.setOnClickListener { view ->
            var intent = Intent(this,SaveEmp::class.java)
            startActivity(intent)
        }

        recyclerview.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        adapter = RecyclerAdapter(this,empList as ArrayList<EmpModelClass>)

        recyclerview.adapter = adapter

    }

    fun getEmp(){
        var db = DatabaseHandler(this)
        empList = db.viewEmployee();
    }

    override fun onResume() {
        super.onResume()

    }
}
