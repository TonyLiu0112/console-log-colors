package com.tony.plugins.services

import com.intellij.codeInsight.completion.InsertHandler
import com.intellij.codeInsight.completion.InsertionContext
import com.intellij.codeInsight.lookup.LookupElement

class CustomInsertHandler : InsertHandler<LookupElement> {

    override fun handleInsert(context: InsertionContext, item: LookupElement) {
        val editor = context.editor
        val document = editor.document
        val caretModel = editor.caretModel

        // 获取插入位置的偏移量
        val offset = caretModel.offset
        // 获取插入的提示文本
        val insertedText = item.`object`.toString()

        // 在编辑器当前行插入文本
        document.insertString(offset, insertedText)

        // 移动光标到插入文本的末尾
        caretModel.moveToOffset(offset + insertedText.length)
    }
}