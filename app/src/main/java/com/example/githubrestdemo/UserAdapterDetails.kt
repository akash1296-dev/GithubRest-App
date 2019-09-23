package com.example.githubrestdemo




import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.user_details.view.*
import kotlinx.android.synthetic.main.user_row.view.*

class UserAdapterDetails(private  val users: List<User>) : RecyclerView.Adapter<UserAdapterDetails.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_details, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.loginName.text = users[position].login
        holder.avatar.text = users[position].avatar_url
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val loginName: TextView = itemView.loginName
        val avatar: TextView = itemView.avatar_url_id
    }
}
