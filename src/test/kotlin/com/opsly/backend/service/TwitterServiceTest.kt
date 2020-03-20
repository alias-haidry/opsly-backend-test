package com.opsly.backend.service

import com.opsly.backend.model.response.FacebookFeedResponse
import com.opsly.backend.service.impl.InstagramServiceImpl
import com.opsly.backend.service.impl.TwitterServiceImpl
import com.opsly.backend.util.RestTemplateUtil
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TwitterServiceTest {

    @Value("\${feed.url.twitter}")
    lateinit var url : String

    @Autowired
    lateinit var restTemplateUtil : RestTemplateUtil

    lateinit var twitterService : TwitterServiceImpl

    @BeforeEach
    fun setUp() {
        twitterService = TwitterServiceImpl()
        twitterService.url = url
        twitterService.restTemplateUtil = restTemplateUtil
    }

    @Test
    fun testTwitterService() {
        Assertions.assertNotNull(twitterService.getFeed().get())
    }
}