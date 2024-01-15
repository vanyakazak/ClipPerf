package clipperf

import clipperf.Request.getClipApplication
import io.gatling.javaapi.core.CoreDsl

object Simulation {

    val scn = CoreDsl.scenario("Get clip app by account number")
        .exec(getClipApplication)

}