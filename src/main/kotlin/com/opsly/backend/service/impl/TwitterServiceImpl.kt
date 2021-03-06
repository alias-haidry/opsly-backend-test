package com.opsly.backend.service.impl

import com.opsly.backend.model.response.InstagramFeedResponse
import com.opsly.backend.model.response.TwitterFeedResponse
import com.opsly.backend.service.SocialNetworkService
import com.opsly.backend.util.RestTemplateUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.AsyncResult
import org.springframework.stereotype.Service
import java.util.concurrent.Future

@Service("twitterService")
class TwitterServiceImpl : SocialNetworkService {

    @Value("\${feed.url.twitter}")
    lateinit var url : String

    @Autowired
    lateinit var restTemplateUtil : RestTemplateUtil

    @Async
    override fun getFeed(): Future<List<String>> {
        return AsyncResult<List<String>>(restTemplateUtil.getData<TwitterFeedResponse>(url).map { response -> response.tweet!! })
    }

}