package com.example.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.thymeleaf.spring6.SpringTemplateEngine
import org.thymeleaf.templatemode.TemplateMode
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver

@Configuration
class TemplateEngineConfig {

    /** 画面表示用のテンプレートエンジン */
    @Primary
    @Bean
    fun htmlViewTemplateEngine(): SpringTemplateEngine {
        val resolver = ClassLoaderTemplateResolver()
        resolver.templateMode = TemplateMode.HTML
        resolver.prefix = "templates/"
        resolver.suffix = ".html"
        resolver.characterEncoding = "UTF-8"

        val templateEngine = SpringTemplateEngine()
        templateEngine.setTemplateResolver(resolver)

        return templateEngine
    }

    /** メール送信用のテンプレートエンジン */
    @Bean("textEmailTemplateEngine")
    fun textEmailTemplateEngine(): SpringTemplateEngine {
        val resolver = ClassLoaderTemplateResolver()
        resolver.templateMode = TemplateMode.TEXT
        resolver.prefix = "templates/email/"
        resolver.suffix = ".txt"
        resolver.characterEncoding = "UTF-8"

        val templateEngine = SpringTemplateEngine()
        templateEngine.setTemplateResolver(resolver)

        return templateEngine
    }
}
