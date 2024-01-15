package clipperf.siam

import com.fasterxml.jackson.annotation.*
import java.time.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class SiamToken(

    @JsonProperty("access_token")
    val accessToken: String,

)
