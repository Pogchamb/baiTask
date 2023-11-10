package pa.chan.baitask.features.auth.data

import androidx.security.crypto.EncryptedSharedPreferences
import javax.inject.Inject

class PrefDataSource @Inject constructor(
    private val sharedPreferences: EncryptedSharedPreferences
) {

    fun setPhoneNumber(phoneNumber: String) {
        sharedPreferences.edit()
            .putString("number", phoneNumber)
            .apply()
    }

    fun getPhoneNumber(): String? {
        return sharedPreferences.getString("number", "")
    }

    fun setPassword(password: String) {
        sharedPreferences.edit()
            .putString("password", password)
            .apply()
    }

    fun getPassword(): String? {
        return sharedPreferences.getString("password", "")
    }

    fun clearAll() {
        sharedPreferences.edit().clear().apply()
    }

}