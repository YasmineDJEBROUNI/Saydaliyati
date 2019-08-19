package com.example.rofaida.saydaliyati.Interfaces

import com.example.rofaida.saydaliyati.Models.Client
import com.example.rofaida.saydaliyati.Models.Commande
import com.example.rofaida.saydaliyati.Models.Facture
import com.example.rofaida.saydaliyati.Models.User_details
import com.example.rofaida.saydaliyati.pharmacaisse
import com.example.rofaida.saydaliyati.pharmacie
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.PUT
import retrofit2.http.FormUrlEncoded




interface Endpoint {

    @POST("addUser")
    fun addUser(@Body client: Client):Call<String>

    /**** Image API ****/
    @Multipart
    @POST("/upload")
    fun postImage(@Part image: MultipartBody.Part, @Part("upload") name: RequestBody): Call<String>

    @GET("uploads/{image}")
    fun getImageDetails(@Path("image") isbn:String): Call<ResponseBody>

    /**** Twilio API***/

    @FormUrlEncoded
    @POST("Accounts/{ACCOUNT_SID}/SMS/Messages")
    fun sendMessage(
        @Path("ACCOUNT_SID") accountSId: String,
        @Header("Authorization") signature: String,
        @FieldMap smsdata: Map<String, String>
    ): Call<ResponseBody>

    /**** Data API ****/

    @POST("addCommande")
    fun addCommande(@Body commande: Commande):Call<String>

    @PUT("updateUserPswd")
    fun updateUserPswd(@Body client: User_details): Call<String>

    @GET("getFacture/{idCmd}")
    fun getFacture(@Path("idCmd") isbn:Int):Call<List<Facture>>

    @POST("getUserLogin")
    fun getUserLogin(@Body client: User_details):Call<List<User_details>>

    @GET("getMaxCommandeID")
    fun getMaxCommandeID(): Call<Int>

    @GET("getCommandes")
    fun getCommandes(): Call<ArrayList<Commande>>

    /**** Pharmacy part ***/

    // Call<List<Book>: une fonction callback qui retourne une liste
    @GET("/getpharma")
    fun getPharma(): Call<List<pharmacie>>

    // Envoi d'un paramètre name
    @GET("getpharmabyville/{ville}")
    fun pharma_vile(@Path("ville") isbn:String):Call<List<pharmacie>>

    @POST("addpharma")
    fun addPharma(@Body pharmacie: pharmacie):Call<String>

    @GET("getcaissebypharma/{id}")
    fun pharma_caisse(@Path("id") id:Int):Call<List<pharmacaisse>>

    @GET("/getcaisse")
    fun getCaisse(): Call<List<String>>

}