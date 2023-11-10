package pa.chan.baitask.features.auth.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import pa.chan.baitask.R
import pa.chan.baitask.databinding.FragmentAuthBinding

class AuthFragment : Fragment() {

    private val viewModel: AuthViewModel by viewModels()

    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val phoneInputLayout = binding?.phoneInputLayout
        val phoneEditText = binding?.phoneEditText
        val passwordInputLayout = binding?.passwordInputLayout
        val passwordEditText = binding?.passwordEditText

        var phone = ""
        var password: String

        phoneEditText?.addTextChangedListener {
            if (phoneInputLayout?.isErrorEnabled == true) {
                phoneInputLayout.isErrorEnabled = false
            }

            if (phoneEditText.text.isNullOrEmpty()) {
                phoneInputLayout?.isErrorEnabled = true
                phoneInputLayout?.error = getString(R.string.invalid_phone)
            }
        }

        binding?.backBtn?.setOnClickListener {
            phoneInputLayout?.visibility = View.VISIBLE
            passwordInputLayout?.visibility = View.GONE
        }


        binding?.authButton?.loginBtn?.setOnClickListener {
            if (phoneInputLayout?.visibility == View.VISIBLE) {
                phone = phoneEditText.toString()
                phoneInputLayout.visibility = View.GONE
                passwordInputLayout?.visibility = View.VISIBLE
            } else if (passwordInputLayout?.visibility == View.VISIBLE) {
                password = passwordEditText.toString()
                viewModel.logInUser(phone, password)
            }
        }

        viewModel.logInLiveData.observe(viewLifecycleOwner) {
            if (it == true) {
                // gotoTask
            } else {
                // invalid credentials
            }

        }


    }

}