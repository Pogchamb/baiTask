package pa.chan.baitask.features.auth.domain

import javax.inject.Inject

class LogInUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke(phone: String, password: String): Boolean {
        return authRepository.loginUser(phone, password)
    }

}