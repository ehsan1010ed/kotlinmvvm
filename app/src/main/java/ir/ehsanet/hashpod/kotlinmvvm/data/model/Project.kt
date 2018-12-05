package ir.ehsanet.hashpod.kotlinmvvm.data.model

import com.google.gson.annotations.SerializedName

data class Project(
    @SerializedName("id") private val id: String? ,
    @SerializedName("name") private val name: String? ,
    @SerializedName("description") private val description: String?
)
