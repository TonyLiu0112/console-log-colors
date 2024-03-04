package com.tony.plugins

import kotlin.random.Random

class CLogUtils private constructor() {

    companion object {

        private const val STYLE: String = "font-size:13px; background:\$bgc; color:\$color;"

        private val colors: MutableList<String> = mutableListOf(
            "#7B68EE",
            "#008B8B",
            "#FF6347",
            "#808080",
            "#800000",
            "#8B4513",
            "#808000",
            "#006400",
            "#2E8B57",
            "#2F4F4F",
            "#000080",
            "#483D8B",
            "#4B0082"
        )
        private val backgroundColors: MutableList<String> =
            mutableListOf("#DCDCDC", "pink", "#FFFFE0", "#E1FFFF", "#E6E6FA", "#F0F8FF", "#F0FFF0")

        fun randomColor(): String {
            return STYLE
                .replace("\$bgc", backgroundColors[Random.nextInt(backgroundColors.size)])
                .replace("\$color", colors[Random.nextInt(colors.size)])
        }

        fun randomNum(): Int {
            return Random.nextInt(101)
        }
    }
}