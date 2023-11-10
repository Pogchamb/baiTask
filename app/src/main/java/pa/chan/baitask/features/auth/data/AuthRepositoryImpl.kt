package pa.chan.baitask.features.auth.data

import pa.chan.baitask.features.auth.domain.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val prefDataSource: PrefDataSource
): AuthRepository {
    override suspend fun loginUser(phoneNumber: String, password: String): Boolean {
        try {
            if (prefDataSource.getPassword().isNullOrEmpty() || prefDataSource.getPhoneNumber().isNullOrEmpty()) {
                authRemoteDataSource.loginUser(phoneNumber, password)
                prefDataSource.setPhoneNumber(phoneNumber)
                prefDataSource.setPassword(password)
            } else {
                authRemoteDataSource.loginUser(
                    prefDataSource.getPhoneNumber().orEmpty(),
                    prefDataSource.getPassword().orEmpty()
                )
            }
            return true

        } catch (e: Exception) {
            return false
        }
    }


}