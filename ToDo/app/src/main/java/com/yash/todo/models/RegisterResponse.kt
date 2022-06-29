package com.yash.todo.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegisterResponse {
    @SerializedName("token")
    @Expose
    var token: String? = null

    constructor(token: String?) {
        this.token = token
    }
}