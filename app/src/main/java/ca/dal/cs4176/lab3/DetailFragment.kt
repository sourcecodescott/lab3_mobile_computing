package ca.dal.cs4176.lab3

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.intent?.let(this::populateFromIntent)
        // new navigation style example:
        startBtn.setOnClickListener {
            /*Add your clickListener here*/
        }
    }

    private fun populateFromIntent(intent: Intent) {
        nameTxt.text = intent.getStringExtra(USER_DETAILS_FIRST_NAME_KEY)
        emailTxt.text = intent.getStringExtra(USER_DETAILS_EMAIL_KEY)
        idTxt.text = intent.getStringExtra(USER_DETAILS_ID_KEY)
        Glide.with(this).load(intent.getStringExtra(USER_DETAILS_PROFILE_PHOTO_URL_KEY)).into(imageView)
    }

}
