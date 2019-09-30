package ca.dal.cs4176.lab3.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import ca.dal.cs4176.lab3.DetailActivity
import ca.dal.cs4176.lab3.R
import ca.dal.cs4176.lab3.USER_DETAILS_EMAIL_KEY
import ca.dal.cs4176.lab3.USER_DETAILS_FIRST_NAME_KEY
import ca.dal.cs4176.lab3.USER_DETAILS_ID_KEY
import ca.dal.cs4176.lab3.USER_DETAILS_PROFILE_PHOTO_URL_KEY
import com.bumptech.glide.Glide
import ca.dal.cs4176.lab3.model.User
import kotlinx.android.synthetic.main.item.view.*

class UserListAdapter(
    private val context: Context,
    private val users: List<User>
) : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        //attach the custom layout to the recycler view
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item, viewGroup, false)
        return ViewHolder(itemView)
    }

    //returns the number of items in the recycler view
    override fun getItemCount() = users.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val user = users[position]
        //Glide is used to load an image using a url
        Glide.with(context).load(user.imageUrl).into(viewHolder.profileImg)
        viewHolder.nameTxt.text = user.firstName

        viewHolder.item.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            // TODO: pass user field data to Intent.extras
            // See DetailsActivity for keys. All values should be strings.
            // intent.putExtra(...)
            context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImg: ImageView
            get() = itemView.profileImg
        val nameTxt: TextView
            get() = itemView.nameTxt
        val item: CardView
            get() = itemView.itemLayout
    }

}
