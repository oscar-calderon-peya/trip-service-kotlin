package com.myaccount.tripservice

import java.util.*


class User {
    private val trips: MutableList<Trip> = ArrayList()
    private val friends: MutableList<User> =
        ArrayList()

    fun getFriends(): List<User>? {
        return friends
    }

    fun addFriend(user: User) {
        friends.add(user)
    }

    fun addTrip(trip: Trip) {
        trips.add(trip)
    }

    fun trips(): List<Trip>? {
        return trips
    }
}