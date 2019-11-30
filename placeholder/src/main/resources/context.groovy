import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import ru.rosbank.javaschool.placeholder.groovy.GroovyConnector

beans {
    propertyPlaceholderConfigurer PropertySourcesPlaceholderConfigurer, {
        location = 'classpath:connection.properties'
    }

    // в одинарных кавычках $ не интерпретируется как спец.символ
    connector GroovyConnector, '${login}', '${password}'
}