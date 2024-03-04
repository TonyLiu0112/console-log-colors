package com.tony.plugins.postfix

import com.intellij.codeInsight.template.postfix.templates.PostfixTemplate
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateProvider
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.NlsSafe
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.tony.plugins.CLogUtils

class ClogPostfixTemplate(p: PostfixTemplateProvider) : PostfixTemplate("clog", "clog", "console.log('DEBUG[args]-100', '#{RandomColor}', args)", p) {

    private val logTemplate: String = "console.log('%c DEBUG[ \$expr ]-\$num', '\$color', \$expr)"

    override fun isApplicable(context: PsiElement, copyDocument: Document, newOffset: Int): Boolean {
        return true
    }

    override fun expand(context: PsiElement, editor: Editor) {
        val currentStatement = PsiTreeUtil.getParentOfType(context, PsiElement::class.java)
        val expr = currentStatement?.text ?: return
        val modifiedStatementText = expr.replace(expr, buildConsoleLog(expr))
        editor.document.replaceString(
            currentStatement.textOffset,
            currentStatement.textOffset + expr.length,
            modifiedStatementText
        )
    }

    private fun buildConsoleLog(expr: @NlsSafe String): String {
        val cLogText = logTemplate.replace("\$expr", expr)
            .replace("\$num", CLogUtils.randomNum().toString())
            .replace("\$color", CLogUtils.randomColor())
        return cLogText
    }

}