package com.example.githubrestdemo.Adapter


import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubrestdemo.MainActivity
import com.example.githubrestdemo.R
import com.example.githubrestdemo.User
import com.example.githubrestdemo.UserDetailsActivity
//import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_user_row.view.*

class UserAdapter(private val users: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private var recyclerViewItemListener : ((User?) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_user_row, parent, false)
        view.setOnClickListener { view1 ->
            val tag = view1.tag as Int
            val user = users[tag]
            val mytext: String = user.login
            println(mytext)
            val intent = Intent(view1.context, UserDetailsActivity::class.java)
            intent.putExtra("login", mytext)
            view1.context.startActivity(intent)
            Log.d(MainActivity.TAG, "onClickHandler " + view1.context.javaClass.simpleName)
        }
        return ViewHolder(view)
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.firstName.text = users[position].login
        holder.itemView.tag = position
        /*for( i in users) {
            println(i.avatar_url)
        }*/
        val photoUrl : User = users[position]
        /*println("user position is ${users[position]}")
        holder.itemView.setOnClickListener {
            recyclerViewItemListener?.invoke(photoUrl)
        }*/
        holder.bind(users[position].avatar_url)

        /*holder.itemView.apply {
            recyclerViewItemListener?.invoke(photoUrl)
        }
        holder.bind(photoUrl)*/
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstName: TextView = itemView.loginName
        //val avatarid: ImageView? = itemView.avatarUrlId
        fun bind(photoUrl: String) {
            Glide.with(itemView.context).load(photoUrl).into(itemView.avatarUrlId)
        }

    }
}
