package com.yetkin.mtekchallenge.module

import com.yetkin.mtekchallenge.repository.NewsRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

val newsRepositoryModule = module {
    factory<NewsRepository> { NewsRepository(newsAPI = get(named("news"))) }
}