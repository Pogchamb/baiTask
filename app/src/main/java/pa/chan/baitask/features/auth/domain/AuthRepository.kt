package pa.chan.baitask.features.auth.domain

interface AuthRepository {

    suspend fun loginUser(phoneNumber:String, password: String): Boolean

}