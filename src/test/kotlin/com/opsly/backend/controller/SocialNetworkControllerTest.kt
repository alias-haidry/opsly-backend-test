package com.opsly.backend.controller

import com.opsly.backend.BackendApplication
import com.opsly.backend.util.RestTemplateUtil
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import java.net.URL

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SocialNetworkControllerTest {

    @Autowired
    lateinit var restTemplate : TestRestTemplate

    @Test
    fun testSocialNetworkController() {

        val response: ResponseEntity<String> = restTemplate.getForEntity(
                "/", String::class.java)

        Assertions.assertEquals(HttpStatus.OK,response.statusCode)
        Assertions.assertNotNull(response.body)

    }

}