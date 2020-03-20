package com.opsly.backend.util

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.opsly.backend.model.response.TwitterFeedResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import java.io.IOException

@Component
class RestTemplateUtil(@Value("\${feed.url.maxtimeout}") val maxTimeout : Double) {

    final inline fun <reified T> getData(url: String) : List<T> {

        try {

            val response = khttp.get(url,timeout = maxTimeout)

            return if(response.statusCode == HttpStatus.OK.value()) {

                // Converting response body to generic response T type

                val objectMapper = ObjectMapper()
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

                val listType = objectMapper.typeFactory.constructCollectionType(List::class.java,T::class.java)
                objectMapper.readValue(response.content,listType)

            } else {

                // Returning empty list if url responds with error
                emptyList()
            }

        } catch (ex: IOException) {
            // Catching timeout exception
            return emptyList()
        }

    }

}

