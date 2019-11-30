package myKotlin

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.springframework.context.support.beans

val beans = beans {
    bean {
        myKotlin.KotlinPropertyPlaceholderConfigurer()
    }
    bean("dataSourceKotlin"){
        myKotlin.DriverManagerDataSourceOwn()
    }
    bean<Source>("Source")
}