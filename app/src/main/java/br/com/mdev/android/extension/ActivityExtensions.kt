package br.com.mdev.android.extension

import android.app.Activity
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Toast
import br.com.mdev.android.R

/**
 * Adiciona ação ao clique do usuário a uma view
 */
fun Activity.onClick(@IdRes resource: Int, onClick: (v: android.view.View?) -> Unit) {
    findViewById<View>(resource).setOnClickListener(onClick)
}

/**
 * Cria um dialog com uma mensagem e um botão de ok que executa alguma ação
 */
fun Activity.createDialog(@StringRes message: String, onOk: () -> Unit = {}) {
    createDialog(getString(R.string.app_name), message, onOk)
}

/**
 * Cria um dialog com um título, uma mensagem e um botão de ok que executa alguma ação
 */
fun Activity.createDialog(@StringRes title: String,
                          @StringRes message: String,
                          onOk: () -> Unit = {}) {

    AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok)) { _, _ -> onOk() }
            .create().run {
                setCanceledOnTouchOutside(false)
                setCancelable(false)
                show()
            }

}

/**
 * Cria um toast com uma mensagem
 */
fun Activity.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}