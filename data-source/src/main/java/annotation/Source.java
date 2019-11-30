package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
public class Source {
    @Autowired
    private final DriverManagerDataSource dataSourceAnnotation;


    public Source(DriverManagerDataSource dataSource, @Value("${login}") String login, @Value("${password}") String password,
                  @Value("${url}") String url, @Value("${driverClassName}") String driverClassName) {

        dataSourceAnnotation = dataSource;
        dataSourceAnnotation.setUsername(login);
        dataSourceAnnotation.setDriverClassName(driverClassName);
        dataSourceAnnotation.setPassword(password);
        dataSourceAnnotation.setUrl(url);
    }
}
