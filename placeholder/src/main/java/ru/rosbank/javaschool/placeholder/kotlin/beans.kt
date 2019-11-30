package ru.rosbank.javaschool.placeholder.kotlin

// после компиляции превратиться в BeansKt.class
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.springframework.context.support.beans
import org.springframework.core.io.ClassPathResource

val beans = beans {
    bean {
        PropertySourcesPlaceholderConfigurer().apply {
            // не всё так гладко в Java <-> Kotlin, здесь нужно явно вызывать set
            setLocation(ClassPathResource("connection.properties"))
        }
    }
    bean<KotlinConnector>("connector")
}
