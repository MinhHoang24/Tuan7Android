package com.example.bai1

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CalendarView
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class MainActivity : AppCompatActivity() {

    private lateinit var addressHelper: AddressHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        addressHelper = AddressHelper(resources)

        val provinces = addressHelper.getProvinces()
        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        val btnChonNgay = findViewById<Button>(R.id.btnChonNgay)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, provinces)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        findViewById<Spinner>(R.id.spTinhThanh).adapter = adapter


        btnChonNgay.setOnClickListener {
            calendarView.visibility = if (calendarView.visibility == View.GONE) View.VISIBLE else View.GONE
        }

        // Xử lý khi nhấn Submit
        btnSubmit.setOnClickListener {
            val mssv = findViewById<EditText>(R.id.etMSSV).text.toString()
            val hoTen = findViewById<EditText>(R.id.etHoTen).text.toString()
            val email = findViewById<EditText>(R.id.etEmail).text.toString()
            val soDienThoai = findViewById<EditText>(R.id.etSoDienThoai).text.toString()
            val dongYDieuKhoan = findViewById<CheckBox>(R.id.cbDongYDieuKhoan).isChecked


            if (mssv.isEmpty() || hoTen.isEmpty() || email.isEmpty() || soDienThoai.isEmpty() || !dongYDieuKhoan) {
                Toast.makeText(this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Nếu mọi thông tin đều hợp lệ
            Toast.makeText(this, "Thông tin hợp lệ", Toast.LENGTH_SHORT).show()
        }
    }
}
