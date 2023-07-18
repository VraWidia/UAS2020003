package com.example.tugas3vra.app

import com.example.tugas3vra.model.PdamModel
import com.example.tugas3vra.model.ResponseModel
import com.example.tugas3vra.model.ResponseModelSekolah


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("tblvra/save")
    fun saveVra(
        @Body data: PdamModel
    ): Call<ResponseModel>

    @GET("vra")
    fun getVra(): Call<ResponseModel>

    @GET("sekolah")
    fun getSekolah(): Call<ResponseModelSekolah>
}