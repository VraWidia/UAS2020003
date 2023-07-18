package com.example.tugas3vra.adapter
import android.annotation. SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView




import com.example.tugas3vra.R
import com.example.tugas3vra.model.PdamModel
import com.example.tugas3vra.model.SekolahModel

//import com.squareup.picasso.Picasso
import kotlin.collections.ArrayList

class adaptersekolah (var activity: Activity, var data: ArrayList<SekolahModel>): RecyclerView.Adapter<adaptersekolah.Holder>() {
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvKode = view.findViewById<TextView>(R.id.tvkdsekolah)
        val tvNama = view.findViewById<TextView>(R.id.tvnmsekolah)
        val tvAlamat = view.findViewById<TextView>(R.id.tvalamat)
        val tvUangmasuk = view.findViewById<TextView>(R.id.tvuangmasuk)
        val tvFoto = view.findViewById<ImageView>(R.id.tvfoto)


    }

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sekolah, parent,false)
        return Holder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val a = data[position]
        holder.tvKode.text = a.kdsekolah
        holder.tvNama.text = a.nmsekolah
        holder.tvAlamat.text = a.alamat
        holder.tvUangmasuk.text = a.uangmasuk
        Glide.with(context)
            .load("http://192.168.135.247/larapel-ku/storage/app/public/${a.foto}")
            .into(holder.tvFoto)





    }

    override fun getItemCount(): Int {
        return data.size
    }
}