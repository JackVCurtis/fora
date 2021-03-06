package com.jackvcurtis.kotlin

import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import org.glassfish.hk2.utilities.binding.AbstractBinder
import org.glassfish.jersey.server.ResourceConfig
import org.glassfish.jersey.server.ServerProperties

class Application : ResourceConfig() {

    init {
        property(ServerProperties.METAINF_SERVICES_LOOKUP_DISABLE, true)
        packages("com.jackvcurtis.kotlin.api")
        register(JacksonFeature::class.java)
        registerInstances(Bindings())
    }

    class Bindings : AbstractBinder() {

        override fun configure() {
            bind(ConfigFactory.load()).to(Config::class.java)
        }
    }
}