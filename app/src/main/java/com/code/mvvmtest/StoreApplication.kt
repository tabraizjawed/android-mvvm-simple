package com.code.mvvmtest

import android.app.Application
import com.code.mvvmtest.api.ProductsAPI
import com.code.mvvmtest.repository.ProductRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StoreApplication : Application() {

    lateinit var productsAPI: ProductsAPI
    lateinit var productRepository: ProductRepository

    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://fakestoreapi.com/")
            .build()

        productsAPI = retrofit.create(ProductsAPI::class.java)
        productRepository = ProductRepository(productsAPI)
    }
}