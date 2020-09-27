package kz.aliw7182.room.repository

import androidx.lifecycle.LiveData
import kz.aliw7182.room.data.UserDao
import kz.aliw7182.room.model.User

class UserRepository(private val userDao: UserDao) {
    val readAllData:LiveData<List<User>> = userDao.readAllData()
    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }
}