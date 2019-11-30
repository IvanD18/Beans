import ru.rosbank.javaschool.servicerepo.groovy.repository.DemoRepository
import ru.rosbank.javaschool.servicerepo.groovy.service.DemoService

beans {
//    "Полный вариант"
//    demoRepository (DemoRepository) { bean ->
//        // bean definition customizer
//        bean.primary = true
//    }
//
//    demoService (DemoService, ref(demoRepository)) {
//       property = value
//    }
    demoRepository DemoRepository
    demoService DemoService, ref(demoRepository)
}