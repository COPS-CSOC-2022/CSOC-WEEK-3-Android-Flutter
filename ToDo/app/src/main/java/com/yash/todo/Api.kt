package com.yash.todo

import com.yash.todo.models.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {
    @POST("authenticate/")
    fun register(@Body loginRequest: LoginRequest): Call<RegisterResponse>
}
