package com.anuar.compositionofthenumber.domain.repository

import com.anuar.compositionofthenumber.domain.entity.GameSettings
import com.anuar.compositionofthenumber.domain.entity.Level
import com.anuar.compositionofthenumber.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}