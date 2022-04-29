package com.github.shynixn.mccoroutine.velocity.impl

import com.github.shynixn.mccoroutine.velocity.entity.UserData
import com.velocitypowered.api.proxy.Player

class FakeDatabase {
    /**
     *  Simulates a getUserData call to a real database by delaying the result.
     */
    fun getUserDataFromPlayer(player: Player): UserData {
        Thread.sleep(5000)
        val userData = UserData()
        userData.amountOfEntityKills = 20
        userData.amountOfPlayerKills = 30
        return userData
    }

    /**
     * Simulates a save User data call.
     */
    fun saveUserData(userData: UserData) {
        Thread.sleep(6000)
    }
}
