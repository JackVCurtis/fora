package com.jackvcurtis.kotlin.api

import com.typesafe.config.Config
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

data class HealthStatus(val status: String)

@Path("health")
class Health @Inject constructor(val config: Config) {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun healthCheck(): HealthStatus {
        return HealthStatus("ok")
    }
}