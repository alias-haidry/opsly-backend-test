package com.opsly.backend.model.response

data class SocialFeedResponse(val facebook: List<String>,
                              val instagram: List<String>,
                              val twitter: List<String>)