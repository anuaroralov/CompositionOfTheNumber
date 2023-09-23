package com.anuar.compositionofthenumber.domain.useCase

import com.anuar.compositionofthenumber.domain.entity.GameSettings
import com.anuar.compositionofthenumber.domain.entity.Level
import com.anuar.compositionofthenumber.domain.repository.GameRepository

class GetGameSettingsUseCase(private val repository: GameRepository) {

    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}