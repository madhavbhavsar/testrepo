package com.base.hilt.ui.account.adapter

import android.content.Context
import com.base.hilt.R
import com.base.hilt.bind.GenericRecyclerViewAdapter
import com.base.hilt.databinding.RowAccountBinding
import com.base.hilt.ui.account.model.AccountModel

class AccountRecyclerViewAdapter(context: Context, list:ArrayList<AccountModel>,

): GenericRecyclerViewAdapter<AccountModel, RowAccountBinding>(context, list) {

    override val layoutResId: Int = R.layout.row_account
    override fun onBindData(model: AccountModel, position: Int, dataBinding: RowAccountBinding) {
        dataBinding.model = model
    }

    override fun onItemClick(model: AccountModel, position: Int, dataBinding: RowAccountBinding) {

    }
}