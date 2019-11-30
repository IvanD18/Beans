import groovy.DriverManagerDataSourceOwn
import groovy.GroovyPropertyPlaceholderConfigurer
import groovy.Source

beans {
    placeHolder GroovyPropertyPlaceholderConfigurer
    dataSourceGroovy DriverManagerDataSourceOwn

    source Source , dataSourceGroovy,'${login}', '${password}', '${url}', '${driverClassName}'
}


