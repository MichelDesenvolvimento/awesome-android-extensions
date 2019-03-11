package br.com.mdev.android.extension

import android.os.AsyncTask
import br.com.mdev.android.BuildConfig

/**
 * Realiza uma tarefa asincronamente (utilizando AsyncTask)
 */
fun doAsync(handler: () -> Unit) {
    object : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {
            handler()
            return null
        }
    }.execute()
}

inline fun debug(block: () -> Unit) {
    if (inDebug()) {
        block()
    }
}

fun inDebug() = BuildConfig.DEBUG