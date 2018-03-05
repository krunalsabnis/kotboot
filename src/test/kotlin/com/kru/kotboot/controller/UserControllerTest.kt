package com.kru.kotboot.controller


import com.kru.kotboot.ControllerTest
import com.kru.kotboot.model.RestResponsePage
import com.kru.kotboot.model.UserCreateRequest
import com.kru.kotboot.model.UserDto
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import java.util.stream.IntStream



/**
 * @author [Krunal Sabnis](mailto:krunalsabnis@gmail.com)
 *
 * REST Controller Test Cases for User Entity
 * sequence of test case is important hence MethodSorters.NAME_ASCENDING
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class UserControllerTest : ControllerTest() {

    internal lateinit var entity: HttpEntity<String>
    var responseType: ParameterizedTypeReference<RestResponsePage<UserDto>>? = null

    @Before
    fun setUp() {
        responseType = object : ParameterizedTypeReference<RestResponsePage<UserDto>>(){}
    }

    /**
     * Test POST with valid Request. Then do  GET for USER
     * posts 10 parallel requests to run it quicker
     * verify Get Call after creating
     */
    @Test
    fun aVerifyUserPost() {
        val requestNumbers = 10
        IntStream.range(65, requestNumbers).parallel().forEach { x ->
            val u = UserCreateRequest("FirstName" + x.toChar(),
                    "LastName" + x.toChar(),
                    "email-" + x.toChar() + "@email.com"
                    )
            val entity = HttpEntity(u, getHeaders())
            val response = post("/api/v1/user", entity, UserDto::class.java!!)
            assertNotNull(response)
            assertEquals(HttpStatus.CREATED, response.statusCode)


            responseType = object : ParameterizedTypeReference<RestResponsePage<UserDto>>() {}
            val response1 = restTemplate
                    .exchange(createURLWithPort("/api/v1/user?page=0&size=10"),
                            HttpMethod.GET, null, responseType)
            val users = response1.body!!.content

            assertNotNull(users)
            assertEquals(10, users.size)

            users.stream().parallel().forEach { x -> assertNotNull(x.email) }
            users.stream().parallel().forEach { x -> assertNotNull(x.firstName) }
            users.stream().parallel().forEach { x -> assertNotNull(x.lastName) }
        }
    }

    /**
     * Verify there is no more entities to return in page 100, size 2500
     * we loaded and created too few records in H2 in test profile
     *
     */
    @Test
    fun cVerifyUserGetForEmptyResponse() {
        val response = restTemplate
                .exchange(createURLWithPort("/api/v1/user?page=100&size=2500"),
                        HttpMethod.GET, null, responseType)
        responseType = object : ParameterizedTypeReference<RestResponsePage<UserDto>>() {}
        val users = response.body!!.content
        assertEquals(0, users.size)
    }
}
