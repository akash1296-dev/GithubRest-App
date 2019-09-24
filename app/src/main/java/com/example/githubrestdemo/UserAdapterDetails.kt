package com.example.githubrestdemo




import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_user_details.view.*


class UserAdapterDetails(private  val users: User) : RecyclerView.Adapter<UserAdapterDetails.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_user_details, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = users.id

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.loginName.text = users.login
        holder.avatar.text = users.avatar_url
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val loginName: TextView = itemView.loginNameId
        val avatar: TextView = itemView.avatarUrlId
    }
}
