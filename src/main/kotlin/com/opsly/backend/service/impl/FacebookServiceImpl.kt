package com.opsly.backend.service.impl

import com.opsly.backend.model.response.FacebookFeedResponse
import com.opsly.backend.service.SocialNetworkService
import com.opsly.backend.util.RestTemplateUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.AsyncResult
import org.springframework.stereotype.Service
import java.util.concurrent.Future
import java.util.stream.Collector
import java.util.stream.Collectors

@Service("facebookService")
public class FacebookServiceImpl : SocialNetworkService {

    @Value("\${feed.url.facebook}")
    lateinit var url : String

    @Autowired
    lateinit var restTemplateUtil : RestTemplateUtil

    @Async
    override fun getFeed(): Future<List<String>> {
        return AsyncResult<List<String>>(restTemplateUtil.getData<FacebookFeedResponse>(url).map { response -> response.status!! })
    }

}