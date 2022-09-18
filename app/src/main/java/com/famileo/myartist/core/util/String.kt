package com.famileo.myartist.core.util

fun String.getFlag(country: String): String {
    return try {
        val flagOffset = 0x1F1E6
        val asciiOffset = 0x41
        val firstChar = Character.codePointAt(country, 0) - asciiOffset + flagOffset
        val secondChar = Character.codePointAt(country, 1) - asciiOffset + flagOffset
        (String(Character.toChars(firstChar))
                + String(Character.toChars(secondChar)))
    } catch (e: Exception) {
        ""
    }

}