package com.app.wednesdayassignment.di

import androidx.room.Room
import com.app.wednesdayassignment.api.NetworkApi
import com.app.wednesdayassignment.database.AppDatabase
import com.app.wednesdayassignment.repository.DataRepository
import com.app.wednesdayassignment.viewmodel.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModules = module {
    viewModel {
        MainViewModel(get())
    }
}
val repositoryModules = module {
    single {
        DataRepository(get(),get())
    }
}

val databaseModules = module {
    single {
        Room.databaseBuilder(
            androidApplication().applicationContext,
            AppDatabase::class.java,
            "songs.db"
        ).build()
    }

    factory {
        val appDatabase: AppDatabase = get()
        appDatabase.singerDao()
    }
}
val networkModules = module {
//    single {
//        val httpLoggingInterceptor = HttpLoggingInterceptor()
//        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//        OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
//    }

    single {
        Retrofit.Builder().baseUrl("https://itunes.apple.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory {
        val retrofit: Retrofit = get()
        retrofit.create(NetworkApi::class.java)
    }
}