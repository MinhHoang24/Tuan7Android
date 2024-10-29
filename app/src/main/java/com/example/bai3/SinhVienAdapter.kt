package com.example.bai3

import SinhVien
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SinhVienAdapter(private var sinhVienList: List<SinhVien>) :
    RecyclerView.Adapter<SinhVienAdapter.SinhVienViewHolder>() {

    inner class SinhVienViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvHoTen: TextView = itemView.findViewById(R.id.tvHoTen)
        val tvMssv: TextView = itemView.findViewById(R.id.tvMssv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SinhVienViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sinh_vien, parent, false)
        return SinhVienViewHolder(view)
    }

    override fun onBindViewHolder(holder: SinhVienViewHolder, position: Int) {
        val sinhVien = sinhVienList[position]
        holder.tvHoTen.text = sinhVien.hoTen
        holder.tvMssv.text = sinhVien.mssv
    }

    override fun getItemCount(): Int = sinhVienList.size

    fun updateList(newList: List<SinhVien>) {
        sinhVienList = newList
        notifyDataSetChanged()
    }
}