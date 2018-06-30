package com.emctechlab.graphqldemo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

/**
 * Created by Sunil Mishra on 6/16/18.
 */
class MainAdapter : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    private var messageList: List<MessageQuery.AllMessage> = mutableListOf()
    private lateinit var context: Context

    fun updateMessageList(messages: List<MessageQuery.AllMessage>) {
        this.messageList = messages
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        this.context = parent.context
        val inflater = LayoutInflater.from(context)
        val rootView = inflater.inflate(R.layout.adapter_main, parent, false)
        return MyViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return messageList.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val message = messageList[position]
        holder.subjectTextView.text = message.subject
        holder.descriptionTextView.text = message.description
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subjectTextView = itemView.findViewById<TextView>(R.id.subjectTextView)!!
        val descriptionTextView = itemView.findViewById<TextView>(R.id.descriptionTextView)!!
        val dateTimeTextView = itemView.findViewById<TextView>(R.id.dateTimeTextView)!!

        init {
            itemView.setOnClickListener {
                val message = messageList[adapterPosition]
                Toast.makeText(context, message.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}