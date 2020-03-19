package com.opsly.backend.controller

import com.opsly.backend.model.response.SocialFeedResponse
import com.opsly.backend.service.SocialNetworkService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SocialNetworkController(var twitterService: SocialNetworkService,
                              var facebookService: SocialNetworkService,
                              var instagramService: SocialNetworkService) {

    @GetMapping
    fun getFeeds(): SocialFeedResponse {

        // Calling all the services for feeds at once but not waiting for the response

        val facebookFutureResponse = facebookService.getFeed()
        val instagramFutureResponse = instagramService.getFeed()
        val twitterFutureResponse = twitterService.getFeed()

        // Will return once all the responses are received.
        return SocialFeedResponse(facebookFutureResponse.get(),
                instagramFutureResponse.get(),
                twitterFutureResponse.get())
    }
}
