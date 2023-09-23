package com.example.contactbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var arrEntityContact: ArrayList<EntityContact>
    private lateinit var db: MyDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)



//        var entityContact = EntityContact(intent?.getStringExtra("name")!!,
//            intent?.getStringExtra("number")!!
//        )


        db = MyDatabase(this, "contact.db", 1)
//        db.deleteAll()
        arrEntityContact = db.getPersonData()

        mBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MainRecyclerAdapter(this, arrEntityContact )
        mBinding.recyclerView.adapter = adapter



        mBinding.btnCreate.setOnClickListener(View.OnClickListener {
            var intent =  Intent(this, SecondActivity::class.java)
            startActivity(intent)
        })

        mBinding.btnDeleteAll.setOnClickListener(View.OnClickListener {
            db.deleteAll()
            arrEntityContact = db.getPersonData()

            mBinding.recyclerView.layoutManager = LinearLayoutManager(this)
            mBinding.recyclerView.adapter = MainRecyclerAdapter(this, arrEntityContact )
        })



    }
}