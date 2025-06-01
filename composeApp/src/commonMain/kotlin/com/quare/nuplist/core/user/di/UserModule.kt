package com.quare.nuplist.core.user.di

import com.quare.nuplist.core.user.domain.usecase.PostUserUseCase
import org.koin.dsl.module

val userModule = module {
    factory { PostUserUseCase(get()) }
}
