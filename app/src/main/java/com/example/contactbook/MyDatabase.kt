package com.example.contactbook


import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDatabase(var context: Context, var name: String, var version: Int) : SQLiteOpenHelper(context, name , null, 1) {
    override fun onCreate(database: SQLiteDatabase?) {
        database?.execSQL("create table person(id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(200), phone varchar(200))")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun insertPersonData(nameValue: String, phoneValue: String){
        var database = this.writableDatabase
        var contentValue  = ContentValues()
        contentValue.put("name", nameValue)
        contentValue.put("phone", phoneValue)
        database.insert("person" , null, contentValue)

    }

    fun getPersonData(): ArrayList<EntityContact>{
        var contactList =  ArrayList<EntityContact>()
        var database = this.readableDatabase
        var cursor = database.rawQuery("select * from person",null)
        while (cursor.moveToNext()){
            var name = cursor.getString(1)
            var phone = cursor.getString(2)
            contactList.add(EntityContact(name,phone))
        }
        return contactList
    }

    fun updatePersonData(nameValue: String, id: String){
        var database = this.writableDatabase
        var contentValue  = ContentValues()
        contentValue.put("name", nameValue)
        database.update("person" , contentValue, "id=?", arrayOf(id))

    }

    fun deletePersonData(id: String){
        var database = this.writableDatabase
        database.delete("person" , "id=?" ,arrayOf(id))

    }

    fun deleteAll() {
        val db = this.writableDatabase
        val sql = "DELETE FROM person"
        db.execSQL(sql)
    }
}