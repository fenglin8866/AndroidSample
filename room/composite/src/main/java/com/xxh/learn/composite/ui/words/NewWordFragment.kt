package com.xxh.learn.composite.ui.words

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.xxh.learn.composite.R
import com.xxh.learn.composite.databinding.FragmentNewWordBinding
import com.xxh.learn.composite.ui.common.BaseFragment
import com.xxh.learn.composite.vo.Word
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewWordFragment : BaseFragment<FragmentNewWordBinding>() {

    private val viewModel: WordViewModel by activityViewModels()

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?): FragmentNewWordBinding {
        return FragmentNewWordBinding.inflate(inflater, container, false)
    }

    override fun setupViews() {
        super.setupViews()
        mBinding.apply {
            buttonSave.setOnClickListener {
                if (editWord.text.isNullOrEmpty()) {
                    Toast.makeText(requireContext(), R.string.empty_not_saved, Toast.LENGTH_LONG)
                        .show()
                } else {
                    viewModel.insert(Word(editWord.text.toString()))
                    findNavController().navigateUp()
                }
            }
        }
    }

}