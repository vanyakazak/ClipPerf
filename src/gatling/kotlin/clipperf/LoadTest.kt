package clipperf

import clipperf.Simulation.scn
import io.gatling.javaapi.core.CoreDsl
import io.gatling.javaapi.core.Simulation
import io.gatling.javaapi.http.HttpDsl.http

class LoadTest : Simulation() {

    val httpProtocol = http.baseUrl("https://top-clip-limit-process-manager.top-credit-cards-clip-platform.internal.ya-ruc1-dev1.dev.k8s.tcsbank.ru/top-clip-limit-process-manager")

    init {
        setUp (
            scn.injectOpen(CoreDsl.constantUsersPerSec(1000.0).during(5))
        ).protocols(httpProtocol)
    }

}