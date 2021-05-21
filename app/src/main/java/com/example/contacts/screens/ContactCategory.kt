package com.example.contacts.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.adapter.CategoryAdapter
import com.example.contacts.databinding.ActivityContactCategoryBinding
import com.example.contacts.datasource.DummyData

class ContactCategory : AppCompatActivity() {
    private lateinit var binding: ActivityContactCategoryBinding
    private val myData = DummyData.categories

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GridLayoutManager(this, 2, RecyclerView.VERTICAL, false).apply {
            binding.categoryRv.layoutManager = this
        }
            binding.categoryRv.adapter = CategoryAdapter(this, myData) //To tell the recyclerView to use the ItemAdapter class

    }


}