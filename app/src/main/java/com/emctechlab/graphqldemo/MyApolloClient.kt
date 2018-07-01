package com.emctechlab.graphqldemo

import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by Sunil Mishra on 6/15/18.
 */
object MyApolloClient {

    fun getMyClient(): ApolloClient {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

        return ApolloClient.builder()
                .serverUrl("http://localhost:8080/graphql")
                .okHttpClient(okHttpClient)
                .build()
    }
}
