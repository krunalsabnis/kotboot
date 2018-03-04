package com.kru.kotboot


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.core.ParameterizedTypeReference


/**
 * @author [Krunal Sabnis](mailto:krunalsabnis@gmail.com)
 *
*/

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ControllerTest : ApplicationTest() {
    @LocalServerPort
    private val port = 8080

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    protected fun getHeaders(): HttpHeaders {
        val headers: HttpHeaders
        //val basicAuth = String(Base64.encode("admin:admin@2018".getBytes(Charsets.UTF_8)), Charsets.UTF_8)
        headers = HttpHeaders()
        //headers.add("Authorization", "Basic " + basicAuth)
        headers.add("Accept", "application/json")
        headers.add("Accept", "text/plain")
        return headers
    }
    protected fun createURLWithPort(uri: String): String {
        return "http://localhost:" + port + uri
    }

    protected operator fun get(uri: String, entity: HttpEntity<*>, clazz: Class<*>): ResponseEntity<*> {
        return restTemplate!!
                .exchange<Any>(createURLWithPort(uri),
                        HttpMethod.GET, entity, ParameterizedTypeReference.forType(clazz))
    }

    protected fun post(uri: String, entity: HttpEntity<*>, clazz: Class<*>): ResponseEntity<*> {
        return restTemplate!!
                .exchange<Any>(createURLWithPort(uri),
                        HttpMethod.POST, entity, ParameterizedTypeReference.forType(clazz))
    }

    protected fun delete(uri: String, entity: HttpEntity<*>, clazz: Class<*>): ResponseEntity<*> {
        return restTemplate!!
                .exchange<Any>(createURLWithPort(uri),
                HttpMethod.DELETE, entity, ParameterizedTypeReference.forType(clazz))
    }

    protected fun put(uri: String, entity: HttpEntity<*>, clazz: Class<*>): ResponseEntity<*> {
        return restTemplate!!
                .exchange<Any>(createURLWithPort(uri),
                        HttpMethod.PUT, entity, ParameterizedTypeReference.forType(clazz))
    }
}
