package com.opsly.backend.service

import com.opsly.backend.service.impl.FacebookServiceImpl
import com.opsly.backend.util.RestTemplateUtil
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FacebookServiceTest {

    @Value("\${feed.url.facebook}")
    lateinit var url : String

    @Mock
    var restTemplateUtil : RestTemplateUtil = RestTemplateUtil(10.0)

    lateinit var facebookService : FacebookServiceImpl

    @BeforeEach
    fun setUp() {
        facebookService = FacebookServiceImpl()
        facebookService.url = url
        facebookService.restTemplateUtil = restTemplateUtil
    }

    @Test
    fun testFacebookService() {
        Assertions.assertNotNull(facebookService.getFeed().get())
    }

}