package co.foglio

import groovy.transform.CompileStatic
import io.dropwizard.Application
import io.dropwizard.db.DataSourceFactory
import io.dropwizard.hibernate.HibernateBundle
import io.dropwizard.migrations.MigrationsBundle
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

/**
 *
 */
@CompileStatic
class DanielService extends Application<DanielConfiguration> {
    public static void main(String[] args) throws Exception {
        new DanielService().run(args)
    }

//    HibernateBundle<DanielConfiguration> hibernateBundle = new HibernateBundle<DanielConfiguration>() {
//        @Override
//        public DataSourceFactory getDataSourceFactory(DanielConfiguration configuration) {
//            return configuration.databaseConfiguration
//        }
//    }

    MigrationsBundle<DanielConfiguration> migrationsBundle = new MigrationsBundle<DanielConfiguration>() {
        @Override
        public DataSourceFactory getDataSourceFactory(DanielConfiguration configuration) {
            return configuration.databaseConfiguration
        }
    }

    @Override
    public void initialize(Bootstrap<DanielConfiguration> bootstrap) {
        bootstrap.with {
            addBundle migrationsBundle
//            addBundle hibernateBundle
        }
    }

    @Override
    public void run(DanielConfiguration configuration,
                    Environment environment) throws ClassNotFoundException {
    }
}
