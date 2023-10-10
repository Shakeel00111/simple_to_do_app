package com.example.todoapp.di

import android.content.Context
import com.example.todoapp.db.NotesDatabase
import com.example.todoapp.repository.Repository
import com.example.todoapp.viewmodel.NotesViewModalFactory
import com.example.todoapp.viewmodel.NotesViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class Module {

    @Provides
    @Singleton
    fun provideDb(@ApplicationContext app: Context):NotesDatabase = NotesDatabase(app)


    @Provides
    @Singleton
    fun provideRepo(db:NotesDatabase):Repository = Repository(db)

    @Provides
    @Singleton
    fun provideViewModelFactory(repo:Repository):NotesViewModalFactory = NotesViewModalFactory(repo)


}
