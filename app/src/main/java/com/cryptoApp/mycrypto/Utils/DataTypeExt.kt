package com.cryptoApp.mycrypto.Utils


fun String?.trimParanthesis(): String {
    return this?.replace(Regex("[()]"), "") ?: ""
}