package com.anuar.compositionofthenumber.domain.useCase

import com.anuar.compositionofthenumber.domain.entity.Question
import com.anuar.compositionofthenumber.domain.repository.GameRepository

class GenerateQuestionUseCase(private val repository: GameRepository) {

    operator fun invoke(maxSumValue:Int): Question {
        return repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
    }

    companion object{
        private const val COUNT_OF_OPTIONS=6
    }
}