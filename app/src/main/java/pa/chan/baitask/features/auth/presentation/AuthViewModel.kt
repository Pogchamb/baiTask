package pa.chan.baitask.features.auth.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pa.chan.baitask.features.auth.domain.LogInUseCase
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val logInUseCase: LogInUseCase
) : ViewModel() {
    private val _logInLiveData: MutableLiveData<Boolean?> = MutableLiveData()
    val logInLiveData: LiveData<Boolean?>
        get() = _logInLiveData


    fun logInUser(phone: String, password: String) {
        viewModelScope.launch {
            _logInLiveData.postValue(logInUseCase(phone, password))
        }
    }


}