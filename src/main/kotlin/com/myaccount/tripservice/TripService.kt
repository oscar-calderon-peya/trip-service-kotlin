package com.myaccount.tripservice

import com.myaccount.tripservice.exception.UserNotLoggedInException
import java.util.*


class TripService {

    @Throws(UserNotLoggedInException::class)
    fun getTripsByUser(user: User): List<Trip?>? {
        var tripList: List<Trip?>? = ArrayList()
        val loggedUser = UserSession.getInstance().getLoggedUser()
        var isFriend = false
        return if (loggedUser != null) {
            for (friend in user.getFriends()!!) {
                if (friend == loggedUser) {
                    isFriend = true
                    break
                }
            }
            if (isFriend) {
                tripList = TripDAO.findTripsByUser(user)
            }
            tripList
        } else {
            throw UserNotLoggedInException()
        }
    }
}