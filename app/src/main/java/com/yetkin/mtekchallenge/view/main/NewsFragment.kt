package com.yetkin.mtekchallenge.view.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.yetkin.mtekchallenge.R
import com.yetkin.mtekchallenge.adapter.NewsAdapter
import com.yetkin.mtekchallenge.databinding.FragmentNewsBinding
import com.yetkin.mtekchallenge.viewBinding
import com.yetkin.mtekchallenge.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : Fragment(R.layout.fragment_news) {

    private val newsBinding: FragmentNewsBinding by viewBinding(FragmentNewsBinding::bind)

    private val newsViewModel: NewsViewModel by viewModel()
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val backPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val intent = Intent(Intent.ACTION_MAIN)
                intent.addCategory(Intent.CATEGORY_HOME)
                startActivity(intent)

            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            backPressedCallback
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        newsBinding.apply {

            newsAdapter = NewsAdapter {

            }

            recyclerview.setHasFixedSize(true)
            recyclerview.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            recyclerview.adapter = newsAdapter

            newsViewModel.getData().observe(viewLifecycleOwner, Observer { newsList ->

                (recyclerview.adapter as NewsAdapter).submitList(newsList)
            })
        }
    }


}