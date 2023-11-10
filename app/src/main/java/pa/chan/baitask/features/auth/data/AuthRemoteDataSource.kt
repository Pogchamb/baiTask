package pa.chan.baitask.features.auth.data


import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(

) {

   suspend fun loginUser(phone: String, password: String) {
       //TODO
   }

}