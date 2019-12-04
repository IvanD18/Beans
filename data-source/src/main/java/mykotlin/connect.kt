package mykotlin

import org.springframework.context.support.beans

val beans = beans {
    bean {
        mykotlin.KotlinPropertyPlaceholderConfigurer()
    }
    bean("dataSourceKotlin"){
        mykotlin.DriverManagerDataSourceOwn()
    }
    bean<Source>("Source")
}