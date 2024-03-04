package com.tony.plugins.macro

import com.intellij.codeInsight.template.Expression
import com.intellij.codeInsight.template.ExpressionContext
import com.intellij.codeInsight.template.Result
import com.intellij.codeInsight.template.TextResult
import com.intellij.codeInsight.template.macro.MacroBase
import com.tony.plugins.CLogUtils

class RandomColorMacro : MacroBase("randomColor", "randomColor()") {

    override fun calculateResult(params: Array<out Expression>, context: ExpressionContext?, quick: Boolean): Result? {
        return TextResult(CLogUtils.randomColor())
    }

}