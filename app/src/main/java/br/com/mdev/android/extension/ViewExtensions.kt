package br.com.mdev.android.extension

import android.support.annotation.UiThread
import android.view.View

/**
 * Torna uma view invisivel
 */
@UiThread
fun View.invisible() {
    visibility = View.INVISIBLE
}

/**
 * Torna uma view visivel
 */
@UiThread
fun View.visible() {
    visibility = View.VISIBLE
}

/**
 * Remove a view da tela (juntamento com o seu espaço de tela)
 */
@UiThread
fun View.gone() {
    visibility = View.GONE
}