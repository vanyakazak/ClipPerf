package clipperf

import clipperf.siam.SiamToken
import io.gatling.javaapi.core.CoreDsl
import io.gatling.javaapi.core.CoreDsl.exec
import io.gatling.javaapi.core.CoreDsl.feed
import io.gatling.javaapi.http.HttpDsl
import io.gatling.javaapi.http.HttpDsl.http
import io.restassured.RestAssured.given
import io.restassured.http.ContentType.*

object Request {

    val feeder = CoreDsl.csv("acountnumbers.csv").random()

    val getClipApplication = exec(
        feed(feeder).exec(
        http("Get /api/v1/clip-applications")
            .get("/api/v1/clip-applications")
            .header(
                "Authorization", "Bearer ${
                    getSiamAuthorizationToken("", "")
                }"
            )
            .queryParam("accountNumber", "#{accountNumber}")
            .check(HttpDsl.status().`is`(200))))


    fun getSiamAuthorizationToken(
        clientId: String, clientSecrete: String
    ) = given()
        .contentType(URLENC)
        .formParam("grant_type", "client_credentials")
        .formParam("client_id", clientId)
        .formParam("client_secret", clientSecrete)
        .post("https://keycloak-top-qa.tinkoff.ru/realms/master/protocol/openid-connect/token")
        .`as`(SiamToken::class.java).accessToken

}