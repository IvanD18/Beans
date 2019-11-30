package groovy;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Source {
    private final DriverManagerDataSource dataSourceGroovy;


    public Source(DriverManagerDataSource dataSource, String login, String password,
                  String url, String driverClassName) {

        dataSourceGroovy = dataSource;
        dataSourceGroovy.setUsername(login);
        dataSourceGroovy.setDriverClassName(driverClassName);
        dataSourceGroovy.setPassword(password);
        dataSourceGroovy.setUrl(url);
    }


}