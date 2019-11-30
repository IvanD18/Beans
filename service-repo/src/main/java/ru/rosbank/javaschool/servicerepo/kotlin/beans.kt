package ru.rosbank.javaschool.servicerepo.kotlin

import org.springframework.context.support.beans
import ru.rosbank.javaschool.servicerepo.kotlin.repository.DemoRepository
import ru.rosbank.javaschool.servicerepo.kotlin.service.DemoService

val beans = beans {
    bean<DemoRepository>() // сам за нас вызовет new
//    Тип писать не обязательно, выводится автоматически
//    Из лямбды возвращается то значение, которое было на последней строке
//    Круглые скобки писать тоже не надо, т.к. всего один параметр - лямбда
//    bean<DemoService>() {
//        DemoService(ref()) // ref() - просим подставить сюда dependency
//    }
    bean {
        DemoService(ref()) // ref() - просим подставить сюда dependency
    }
}