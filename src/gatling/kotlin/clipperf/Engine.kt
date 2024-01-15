package clipperf

import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

object Engine {

    @JvmStatic
    fun main(args: Array<String>) {
        val simulationClass = (LoadTest::class).qualifiedName

        val props = GatlingPropertiesBuilder()
            .simulationClass(simulationClass)

        Gatling.fromMap(props.build())
    }

}