package com.example.blog

import org.springframework.boot.context.properties.ConfigurationProperties

// spring.application.name=blog
// blog.title=My Blog Title
// blog.banner.title=Welcome
// blog.banner.content=This is my Spring Boot blog.

@ConfigurationProperties("blog")
data class BlogProperties(var title: String, val banner: Banner) {
    data class Banner(val title: String? = null, val content: String)
}
