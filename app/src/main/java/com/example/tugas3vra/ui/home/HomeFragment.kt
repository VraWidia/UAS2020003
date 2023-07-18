package com.example.tugas3vra.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas3vra.model.PdamModel
import com.example.tugas3vra.adapter.adapterpdam

import com.example.tugas3vra.R
import com.example.tugas3vra.app.ApiConfig.ApiConfig
import com.example.tugas3vra.model.ResponseModel
import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment() {

    //
    lateinit var rvVra: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        init(view)
        getVra()
        return view
    }

    private var listVra: ArrayList<PdamModel> = ArrayList()

    fun getVra(){
        ApiConfig.instanceRetrofit.getVra().enqueue(object :
            retrofit2.Callback<ResponseModel> {

            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                val res = response.body()!!
                listVra = res.vra
                displayVra()
            }
            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Toast.makeText(requireActivity(), "Error :"+t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun  displayVra() {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rvVra.adapter = adapterpdam(requireActivity(), listVra)
        rvVra.layoutManager = layoutManager
    }

    fun init(view: View) {
        //rvBarang = view.findViewById(R.id.recyler_view)
        rvVra=view.findViewById(R.id.recyler_view)
    }

}