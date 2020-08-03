package com.myaccount.tripservice

import com.myaccount.tripservice.exception.UserNotLoggedInException


open class TripService {

    @Throws(UserNotLoggedInException::class)
    fun getTripsByUser(user: User): List<Trip> {
        var tripList = listOf<Trip>()
        val loggedUser = UserSession.getInstance().getLoggedUser()
        var isFriend = false
        return if (loggedUser != null) {
            for (friend in user.getFriends()) {
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