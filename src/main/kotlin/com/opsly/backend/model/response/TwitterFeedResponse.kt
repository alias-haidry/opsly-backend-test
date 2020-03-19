package com.opsly.backend.model.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class TwitterFeedResponse(val username: String? = null,
                               val tweet: String? = null)