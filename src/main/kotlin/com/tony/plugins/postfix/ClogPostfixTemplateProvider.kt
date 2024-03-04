package com.tony.plugins.postfix

import com.intellij.codeInsight.template.postfix.templates.PostfixTemplate
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateProvider
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplatesUtils
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import org.jdom.Element

class ClogPostfixTemplateProvider : PostfixTemplateProvider {

    private val myBuiltinTemplates: MutableSet<PostfixTemplate> = HashSet()

    init {
        myBuiltinTemplates.add(ClogPostfixTemplate(this))
    }

    override fun getId(): String {
        return "clog"
    }

    override fun getPresentableName(): String {
        return "clog"
    }

    override fun getTemplates(): MutableSet<PostfixTemplate> {
        return myBuiltinTemplates
    }

    override fun isTerminalSymbol(currentChar: Char): Boolean {
        return currentChar == '.'
    }

    override fun preExpand(file: PsiFile, editor: Editor) = Unit

    override fun afterExpand(file: PsiFile, editor: Editor) = Unit

    override fun preCheck(copyFile: PsiFile, realEditor: Editor, currentOffset: Int): PsiFile {
        return copyFile
    }

    override fun readExternalTemplate(id: String, name: String, template: Element): PostfixTemplate? {
        return ClogPostfixTemplate(this)
    }

    override fun writeExternalTemplate(template: PostfixTemplate, parentElement: Element) {
        if (template is ClogPostfixTemplate) {
            PostfixTemplatesUtils.writeExternalTemplate(template, parentElement)
        }
    }
}