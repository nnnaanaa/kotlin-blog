package com.example.blog

import java.time.LocalDateTime
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.jdbc.core.mapping.AggregateReference

@Table("article")
data class Article(
    val title: String,
    val headline: String,
    val content: String,
    // プログラム上ではauthorという名前で扱っているが実際はauthor_idである
    @Column("author_id")
    val author: AggregateReference<User, Long>,
    val slug: String = title.toSlug(),
    val addedAt: LocalDateTime = LocalDateTime.now(),
    @Id val id: Long? = null
)

@Table("users")
data class User(
    val login: String,
    val firstname: String,
    val lastname: String,
    val description: String? = null,
    // 重複しない識別番号であることを示す
    @Id val id: Long? = null
)