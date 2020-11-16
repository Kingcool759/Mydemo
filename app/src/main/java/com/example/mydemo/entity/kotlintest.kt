package com.example.mydemo.entity

/**
 * @data on 2020/11/13 6:04 PM
 * @auther
 * @describe
 */
data class kotlintest(
    val `data`: Data,
    val error: Int
)

data class Data(
    val avatar: Any,
    val city_id: String,
    val create_time: String,
    val district_id: String,
    val doctor_uid: String,
    val `field`: String,
    val id: String,
    val is_white: String,
    val position: String,
    val price: String,
    val province_id: String,
    val realname: String,
    val regional: String,
    val role_id: String,
    val role_name: String,
    val third_uid: String,
    val title: String,
    val uid: String,
    val update_time: String
)