package com.example.contactbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactbook.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivitySecondBinding
    private lateinit var db : MyDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_second)

        db = MyDatabase(this, "contact.db", 1)

        mBinding.btnInsert.setOnClickListener(View.OnClickListener {
            var name = mBinding.edtName.text.toString()
            var number = mBinding.edtNumber.text.toString()
            if (name.isEmpty() || number.isEmpty()){
                Toast.makeText(this,"Fill Both Field", Toast.LENGTH_SHORT).show()
            }else{
                db.insertPersonData(name, number)
                var intent = Intent(this, MainActivity::class.java)
                Toast.makeText(this,"Data added successfully", Toast.LENGTH_SHORT).show()
//                intent.putExtra("name", name)
//                intent.putExtra("number", number)
                startActivity(intent)
                finish()

            }
        })
    }
}