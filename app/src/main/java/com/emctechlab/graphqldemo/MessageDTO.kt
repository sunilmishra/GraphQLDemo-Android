package com.emctechlab.graphqldemo

/**
 * Created by Sunil Mishra on 6/16/18.
 */
class EMessageVO {
    var id: String? = null
    var subject: String? = null
    var description: String? = null
    var category: String? = null
    var read = false
    var dateTime: String? = null
    override fun toString(): String {
        return "EMessageVO(id=$id, subject=$subject, description=$description, category=$category, read=$read, dateTime=$dateTime)"
    }

}