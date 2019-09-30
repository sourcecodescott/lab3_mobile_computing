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
                val users: List<User>// TODO: Parse JSON data

                //set the adapter after getting the data
                usersRecycler.adapter = UserListAdapter(this@MainActivity, users)
            }, Response.ErrorListener {
                Toast.makeText(this, "Error getting data", Toast.LENGTH_LONG).show()
            })
        )
    }

}
