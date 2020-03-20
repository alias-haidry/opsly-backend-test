package com.opsly.backend.service

import java.util.concurrent.Future

interface SocialNetworkService {
    fun getFeed(): Future<List<String>>
}