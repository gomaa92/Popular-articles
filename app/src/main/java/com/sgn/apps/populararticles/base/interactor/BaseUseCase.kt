package com.sgn.apps.populararticles.base.interactor

interface BaseUseCase <Param,R>{
    suspend fun build(param:Param):R
}