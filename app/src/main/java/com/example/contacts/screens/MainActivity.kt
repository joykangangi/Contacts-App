package com.example.contacts.screens

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.contacts.R
import com.example.contacts.adapter.CategoryAdapter
import com.example.contacts.adapter.ContactAdapter
import com.example.contacts.databinding.ActivityMainBinding
import com.example.contacts.model.Contact

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = ContactAdapter()
    private var name: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpData(binding)
        binding.contactsRv.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))

        //get data from putExtra content
       name = intent.getStringExtra(CategoryAdapter.NAME_EXTRA)
        // To show back button in actionbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //set Title in the activity
        title = name

    }

   private fun setUpData(binding: ActivityMainBinding) {
        binding.contactsRv.adapter = adapter

       //creating the dialogue builder
       val builder = AlertDialog.Builder(this)

       //inflate layout for the add contact dialogue
       val view =layoutInflater.inflate(R.layout.add_contact_dialog, null)
       builder.setView(view)

       //get each item on the layout
       val name = view.findViewById<TextView>(R.id.nameEt)
       val phoneNumb = view.findViewById<TextView>(R.id.numberEt)
       val savBtn = view.findViewById<Button>(R.id.saveBtn)

       phoneNumb.addTextChangedListener(object: TextWatcher {
           override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

           }

           override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
               savBtn.isEnabled = p0?.length == 11
           }

           override fun afterTextChanged(p0: Editable?) {

           }

       } )

       //create dialogue
       val alertDialog = builder.create()

       binding.fab.setOnClickListener {
          builder.create()
           alertDialog.show()
       }

       savBtn.setOnClickListener {
           val contact = Contact(name?.text.toString(), phoneNumb?.text.toString())
           val contacts = mutableListOf(contact)
           adapter.setUpContacts(contacts)
           alertDialog.dismiss()

}
    }

}