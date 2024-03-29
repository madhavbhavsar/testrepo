package com.base.hilt.ui.account.ui

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.base.hilt.MainActivity
import com.base.hilt.R
import com.base.hilt.base.FragmentBase
import com.base.hilt.base.ToolbarModel
import com.base.hilt.base.ViewModelBase
import com.base.hilt.databinding.FragmentAccountBinding
import com.base.hilt.ui.account.adapter.AccountRecyclerViewAdapter
import com.base.hilt.ui.account.model.AccountModel
import com.base.hilt.ui.account.viewmodel.AccountViewModel
import com.base.hilt.utils.MyPreference
import com.base.hilt.utils.PrefKey
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AccountFragment : FragmentBase<AccountViewModel,FragmentAccountBinding>(){

    @Inject
    lateinit var pref : MyPreference

    override fun getLayoutId(): Int = R.layout.fragment_account

    override fun setupToolbar() {
        viewModel.setToolbarItems(ToolbarModel(isBottomNavVisible = true, isVisible = false))
    }

    override fun initializeScreenVariables() {

        getDataBinding().viewmodel = viewModel

        // observe live data
        observeData()

        //status bar color change
        (requireActivity() as MainActivity).backGroundColor()

        // set up recycler adapter
        setUpRecyclerAdapter()

    }

    private fun setUpRecyclerAdapter() {

        val list = arrayListOf(AccountModel(getString(R.string.add_balance)),
            AccountModel(getString(R.string.invite_friend)),
            AccountModel(getString(R.string.settings)),
            AccountModel(getString(R.string.support)),
            AccountModel(getString(R.string.faqs)),
            AccountModel(getString(R.string.transfer_friend)),
            AccountModel(getString(R.string.scan_code)),
            AccountModel(getString(R.string.withdrow_balance)),
            )
        getDataBinding().rcvAccount.adapter = AccountRecyclerViewAdapter(requireContext(), list)
        getDataBinding().rcvAccount.layoutManager = LinearLayoutManager(requireContext())

    }

    private fun observeData() {

        viewModel.apply {

            onLogOutClick?.observe(viewLifecycleOwner){
                findNavController().navigate(R.id.action_accountsFragment_to_loginFragment)
                pref.setBeanValue(PrefKey.IS_LOGINED, false)
            }


        }

    }

    override fun onDestroyView() {

        //setStatus bar color black
        (requireActivity() as MainActivity).backGroundColorBlack()
        super.onDestroyView()
    }

    override fun getViewModelClass(): Class<AccountViewModel> = AccountViewModel::class.java

}