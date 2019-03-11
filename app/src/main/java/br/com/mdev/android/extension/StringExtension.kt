package br.com.mdev.android.extension

import android.content.Context
import android.util.Patterns
import br.com.mdev.android.R
import br.com.mdev.android.exception.InvalidUrlException

@Throws(InvalidUrlException::class)
fun String.validateURL(context: Context) {

    if (!Patterns.WEB_URL.matcher(this).matches()) {
        throw InvalidUrlException(context.getString(R.string.invalid_url_message))
    }

}

