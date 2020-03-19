package com.opsly.backend.model.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class FacebookFeedResponse(val name: String? = null,
                                val status: String? = null)