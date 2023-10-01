package com.anuar.compositionofthenumber.presentation

import android.content.Context
import android.content.res.ColorStateList
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.anuar.compositionofthenumber.R
import com.anuar.compositionofthenumber.domain.entity.GameResult


@BindingAdapter("progressBarColor")
fun progressBarColor(progressBar: ProgressBar,goodState:Boolean){
    progressBar.progressTintList= ColorStateList.valueOf(getColorByState(progressBar.context,goodState))
}

@BindingAdapter("textViewColor")
fun textViewColor(textView: TextView,goodState: Boolean){
    textView.setTextColor(getColorByState(textView.context,goodState))
}

private fun getColorByState(context: Context, goodState: Boolean): Int {
    val colorResId = if (goodState) {
        android.R.color.holo_green_light
    } else {
        android.R.color.holo_red_light
    }
    return ContextCompat.getColor(context, colorResId)
}

@BindingAdapter("imageResource")
fun imageResource(imageView: ImageView,winner: Boolean){
    imageView.setImageResource(getSmileResId(winner))
}

@BindingAdapter("percentOfScore")
fun percentOfScore(textView: TextView,gameResult: GameResult){
    textView.text= String.format(
        textView.context.getString(R.string.score_percentage),
        getPercentOfRightAnswers(gameResult)
    )
}

private fun getPercentOfRightAnswers(gameResult: GameResult) = with(gameResult) {
    if (countOfQuestions == 0) {
        0
    } else {
        ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()
    }
}

private fun getSmileResId(winner:Boolean):Int{
    return if (winner) {
        R.drawable.ic_smile
    } else {
        R.drawable.ic_sad
    }
}
