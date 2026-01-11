package com.example.blog

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jdbc.core.mapping.AggregateReference

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(
        userRepository: UserRepository,
        articleRepository: ArticleRepository
    ) = ApplicationRunner {
        // この時点で自動でIDが割り当てられる
        val johnDoe = userRepository.save(User("johnDoe", "John", "Doe"))
        articleRepository.save(
            Article(
                title = "Lorem",
                headline = "Lorem",
                content = "dolor sit amet",
                // Userに自動で割り当てられたIDを取得する !!は絶対にnullではないと伝える
                author = AggregateReference.to(johnDoe.id!!)
            )
        )

        articleRepository.save(
            Article(
                title = "Ipsum",
                headline = "Ipsum",
                content = "dolor sit amet",
                author = AggregateReference.to(johnDoe.id)
            )
        )
    }
}