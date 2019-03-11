package br.com.mdev.android.extension

import android.content.Intent

/**
 * Adiciona funcionalidade de valor default para string vinda de uma Intent
 */
fun Intent.getStringExtra(name: String, defaultValue: String) =
        getStringExtra(name) ?: defaultValue