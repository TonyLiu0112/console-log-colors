package com.tony.plugins.services

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiPlainText
import com.intellij.util.ProcessingContext

class CustomCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC, PlatformPatterns.psiElement(PsiPlainText::class.java),
            CustomCompletionProvider()
        )
    }

    private class CustomCompletionProvider : CompletionProvider<CompletionParameters>() {
        override fun addCompletions(
            parameters: CompletionParameters,
            context: ProcessingContext,
            resultSet: CompletionResultSet
        ) {
            // 在这里添加你的自定义联想提示
            resultSet.addElement(LookupElementBuilder.create("clog"))
            // 添加更多的自定义建议...
        }
    }
}