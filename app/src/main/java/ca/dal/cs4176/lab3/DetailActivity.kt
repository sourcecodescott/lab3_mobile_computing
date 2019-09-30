package ca.dal.cs4176.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// Intent arguments for Activity (in "extras" bundle) -- string values.
const val USER_DETAILS_ID_KEY = "id"
const val USER_DETAILS_FIRST_NAME_KEY = "firstName"
const val USER_DETAILS_EMAIL_KEY = "email"
const val USER_DETAILS_PROFILE_PHOTO_URL_KEY = "profilePhotoUrl"

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        if (savedInstanceState != null) {
            val fragment = DetailFragment()
            fragment.arguments = intent.extras
            supportFragmentManager.beginTransaction()
                .add(R.id.my_nav_host_fragment,fragment)
                .commit()
        }
    }

}
