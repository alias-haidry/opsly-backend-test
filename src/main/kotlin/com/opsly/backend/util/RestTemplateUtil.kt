package com.opsly.backend.util

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import java.io.IOException

@Component
class RestTemplateUtil(@Value("\${feed.url.maxtimeout}") val maxTimeout : Double) {

    fun <T> getData(url: String) : List<T> {

        try {

            val response = khttp.get(url,timeout = maxTimeout)

            return if(response.statusCode == HttpStatus.OK.value()) {

                // Converting response body to generic response T type

                val objectMapper = ObjectMapper()
                val parameterizedType = object : TypeReference<List<T>>(){}
                objectMapper.readValue(response.content,parameterizedType)

            } else {

                // Returning empty list if url responds with error
                listOf<T>()
            }

        } catch (ex: IOException) {
            // Catching timeout exception
            return listOf<T>()
        }

    }

}

