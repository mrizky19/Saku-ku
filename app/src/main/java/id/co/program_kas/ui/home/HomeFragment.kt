package id.co.program_kas.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.co.program_kas.R
import id.co.program_kas.UserAdapter
import id.co.program_kas.model.DataItem
import id.co.program_kas.model.ResponseUser
import id.co.program_kas.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var adapter: UserAdapter
    private lateinit var rv_users: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Mendapatkan referensi RecyclerView dari view
        rv_users = view.findViewById(R.id.rv_users)

        // Setup adapter
        adapter = UserAdapter(mutableListOf())

        // Setup RecyclerView
        rv_users.setHasFixedSize(true)
        rv_users.layoutManager = LinearLayoutManager(requireContext())
        rv_users.adapter = adapter

        // Memanggil fungsi untuk mengambil data user
        getUser()

        return view
    }

    private fun getUser() {
        val client = ApiConfig.getApiService().getListUsers("1")

        client.enqueue(object : Callback<ResponseUser> {
            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
                if (response.isSuccessful) {
                    val dataArray = response.body()?.data as List<DataItem>
                    for (data in dataArray) {
                        adapter.addUser(data)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
                t.printStackTrace()
            }
        })
    }
}
