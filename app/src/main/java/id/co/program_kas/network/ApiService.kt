import id.co.program_kas.model.ResponseUser
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    // Get list users with query
    @GET("data/n7eyN7mW4zXOfYhf/")
    fun getListUsers(@Query("page") page: String): Call<ResponseUser>

    // Get list user by id using path
    @GET("data/n7eyN7mW4zXOfYhf/{id}")
    fun getUser(@Path("id") id: String): Call<ResponseUser>

    // Post user using field x-www-form-urlencoded
    @FormUrlEncoded
    @POST("data/n7eyN7mW4zXOfYhf/")
    fun createUser(
        @Field("name") name: String,
        @Field("job") job: String
    ): Call<ResponseUser>

    // Upload file using multipart
    @Multipart
    @PUT("api/uploadfile")
    fun updateUser(
        @Part("file") file: MultipartBody.Part,
        @PartMap data: Map<String, RequestBody>
    ): Call<ResponseUser>
}
