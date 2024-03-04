package com.tony.plugins.live

import com.intellij.codeInsight.template.TemplateActionContext
import com.intellij.codeInsight.template.TemplateContextType

class CustomLiveTemplateContext : TemplateContextType("clog") {

    override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
        return true
    }
}
