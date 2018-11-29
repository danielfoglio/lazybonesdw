package co.foglio

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import io.dropwizard.Configuration
import io.dropwizard.db.DataSourceFactory

import javax.validation.Valid
import javax.validation.constraints.NotNull

/**
 *
 */
@CompileStatic
class DanielConfiguration extends Configuration {
    @Valid
    @NotNull
    @JsonProperty
    DataSourceFactory databaseConfiguration
}
