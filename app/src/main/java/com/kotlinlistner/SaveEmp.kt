package com.kotlinlistner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_save_emp.*
import kotlinx.android.synthetic.main.activity_save_emp.view.*

class SaveEmp : AppCompatActivity() {

    companion object{
        val TAG = SaveEmp::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_emp)

        save.setOnClickListener {view->
            when{
                TextUtils.isEmpty(user_id.text.toString())->Toast.makeText(this,"Id can't be empty",Toast.LENGTH_LONG).show()
                TextUtils.isEmpty(name.text.toString())->Toast.makeText(this,"Nmae can't be empty",Toast.LENGTH_LONG).show()
                TextUtils.isEmpty(email.text.toString())->Toast.makeText(this,"Email can't be empty",Toast.LENGTH_LONG).show()
                else->{
                    saveEmp(view);
                }
            }
        }
    }

    private fun saveEmp(view: View) {
        val database = DatabaseHandler(this);
        val result = database.addEmployee(EmpModelClass(Integer.parseInt(user_id.text.toString()),name.text.toString(),email.text.toString()))
        Log.d(TAG,"result "+result);
        if (result>0){
            Snackbar.make(view, "Employee saved", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            //Toast.makeText(this,"Employee added successfully",Toast.LENGTH_LONG).show()
        }
    }
}
