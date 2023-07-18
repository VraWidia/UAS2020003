package com.example.tugas3vra.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.tugas3vra.R
import com.example.tugas3vra.adapter.adaptersekolah
import com.example.tugas3vra.app.ApiConfig.ApiConfig
import com.example.tugas3vra.model.ResponseModelSekolah
import com.example.tugas3vra.model.SekolahModel
import retrofit2.Call
import retrofit2.Response

class DashboardFragment : Fragment() {

    //
    lateinit var rvSekolah: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_dashboard, container, false)

        init(view)
        getSekolah()
        return view
    }

    private var ListSekolah: ArrayList<SekolahModel> = ArrayList()

    fun getSekolah(){
        ApiConfig.instanceRetrofit.getSekolah().enqueue(object :
            retrofit2.Callback<ResponseModelSekolah> {

            override fun onResponse(call: Call<ResponseModelSekolah>, response: Response<ResponseModelSekolah>) {
                val res = response.body()!!
                ListSekolah = res.sekolah
                displaySekolah()
            }
            override fun onFailure(call: Call<ResponseModelSekolah>, t: Throwable) {
                Toast.makeText(requireActivity(), "Error :"+t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun  displaySekolah() {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rvSekolah.adapter = adaptersekolah(requireActivity(), ListSekolah)
        rvSekolah.layoutManager = layoutManager
    }

    fun init(view: View) {
        //rvBarang = view.findViewById(R.id.recyler_view)
        rvSekolah=view.findViewById(R.id.recyler_dashboard)
    }

}