package ca.dal.cs4176.lab3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import ca.dal.cs4176.lab3.adapter.UserListAdapter
import ca.dal.cs4176.lab3.model.User
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

const val GET_USERS_URL = "https://reqres.in/api/users"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        usersRecycler.layoutManager = LinearLayoutManager(this)
        getUsers()
    }

    //get users list using Volley

    private fun getUsers() {
        Volley.newRequestQueue(this).add(
            StringRequest(Request.Method.GET, GET_USERS_URL, Response.Listener<String> { response ->
                val users: ArrayList<User> = ArrayList()//
                val JsonObj = JSONObject(response.toString())
                val myUsers = JsonObj.getJSONArray("data")

                for (i in 0 until myUsers.length()) {
                    val u = User(
                        myUsers.getJSONObject(i).getString("id"),
                        myUsers.getJSONObject(i).getString("first_name"),
                        myUsers.getJSONObject(i).getString("last_name"),
                        myUsers.getJSONObject(i).getString("avatar"),
                        myUsers.getJSONObject(i).getString("email"))
                    users.add(u)
                }

                //set the adapter after getting the data
                usersRecycler.adapter = UserListAdapter(this@MainActivity, users)
            }, Response.ErrorListener {
                Toast.makeText(this, "Error getting data", Toast.LENGTH_LONG).show()
            })
        )
    }



}
