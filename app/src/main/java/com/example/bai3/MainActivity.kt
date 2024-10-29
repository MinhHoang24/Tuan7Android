package com.example.bai3

import SinhVien
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SinhVienAdapter
    private lateinit var etSearch: EditText
    private var sinhVienList = listOf(
        SinhVien(hoTen = "Pham Minh Hoang", mssv = "20215582"),
        SinhVien(hoTen = "Critiano Ronaldo", mssv = "20215583"),
        SinhVien(hoTen = "Lionel Messi", mssv = "20215584"),
        SinhVien(hoTen = "Neymar Jr", mssv = "20215585"),
        SinhVien(hoTen = "Steven Gerrard", mssv = "20215586")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        etSearch = findViewById(R.id.etSearch)

        adapter = SinhVienAdapter(sinhVienList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString()
                filterList(query)
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun filterList(query: String) {
        val filteredList = if (query.length > 2) {
            sinhVienList.filter {
                it.hoTen.contains(query, ignoreCase = true) || it.mssv.contains(query, ignoreCase = true)
            }
        } else {
            sinhVienList
        }
        adapter.updateList(filteredList)
    }
}