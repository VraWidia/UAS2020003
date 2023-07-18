package com.example.tugas3vra.adapter
import android.annotation. SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView




import com.example.tugas3vra.R
import com.example.tugas3vra.model.PdamModel

//import com.squareup.picasso.Picasso
import kotlin.collections.ArrayList

class adapterpdam(var activity: Activity, var data: ArrayList<PdamModel>): RecyclerView.Adapter<adapterpdam.Holder>() {
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvnamapelanggan = view.findViewById<TextView>(R.id.tvnamapelanggan)
        val tvnomorpelanggan = view.findViewById<TextView>(R.id.tvnomorpelanggan)




    }

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pdam, parent,false)
        return Holder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val a = data[position]
        holder.tvnamapelanggan.text = a.namapelanggan
        holder.tvnomorpelanggan.text = a.nomorpelanggan






    }

    override fun getItemCount(): Int {
        return data.size
    }
}