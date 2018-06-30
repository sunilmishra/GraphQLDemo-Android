package com.emctechlab.graphqldemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Sunil Mishra on 6/15/18.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MainAdapter
    private val allMessageList: MutableList<MessageQuery.AllMessage> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.isNestedScrollingEnabled = false
        adapter = MainAdapter()
        recyclerView.adapter = adapter

        getAllMessage()

        addMessageButton.setOnClickListener {
            createNewMessage()
        }
    }

    private fun getAllMessage() {
        val myQuery = MessageQuery.builder()
                .build()
        MyApolloClient.getMyClient().query(myQuery).enqueue(object : ApolloCall.Callback<MessageQuery.Data>() {
            override fun onFailure(e: ApolloException) {
                e.printStackTrace()
            }

            override fun onResponse(response: Response<MessageQuery.Data>) {
                allMessageList.addAll(response.data()?.allMessage!!)
                updateMyMessageList()
            }
        })
    }

    private fun createNewMessage() {
        val subject = "This is new Message"
        val description = "This is message from Android platform."
        val category = "Social"
        val newMessage = MessageCreatorMutation.builder().subject(subject)
                .description(description)
                .category(category)
                .build()

        MyApolloClient.getMyClient().mutate(newMessage).enqueue(object : ApolloCall.Callback<MessageCreatorMutation.Data>() {
            override fun onFailure(e: ApolloException) {
                e.printStackTrace()
            }

            override fun onResponse(response: Response<MessageCreatorMutation.Data>) {
                val messageId = response.data()?.createMessage
                val myNewMessage = MessageQuery.AllMessage("", messageId!!, subject, description)
                allMessageList.add(myNewMessage)
                updateMyMessageList()
            }
        })
    }

    private fun updateMyMessageList() {
        runOnUiThread {
            adapter.updateMessageList(messages = allMessageList)
            adapter.notifyDataSetChanged()
        }
    }
}
