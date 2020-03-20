package com.opsly.backend.service

import com.opsly.backend.model.response.FacebookFeedResponse
import com.opsly.backend.service.impl.FacebookServiceImpl
import com.opsly.backend.service.impl.InstagramServiceImpl
import com.opsly.backend.util.RestTemplateUtil
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class InstagramServiceTest {

    @Value("\${feed.url.instagram}")
    lateinit var url : String

    @Autowired
    lateinit var restTemplateUtil : RestTemplateUtil

    lateinit var instagramService : InstagramServiceImpl

    @BeforeEach
    fun setUp() {
        instagramService = InstagramServiceImpl()
        instagramService.url = url
        instagramService.restTemplateUtil = restTemplateUtil
    }

    @Test
    fun testInstagramService() {
        Assertions.assertNotNull(instagramService.getFeed().get())
    }

}