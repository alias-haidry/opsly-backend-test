package com.opsly.backend.model.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class InstagramFeedResponse(val username: String? = null,
                                 val picture: String? = null)