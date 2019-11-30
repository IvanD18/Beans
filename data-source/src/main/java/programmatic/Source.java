package programmatic;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Source {



    public Source(String login, String password,
                  String url, String driverClassName) {
        final DriverManagerDataSource dataSourceProgrammatic=new DriverManagerDataSource();
        dataSourceProgrammatic.setUsername(login);
        dataSourceProgrammatic.setDriverClassName(driverClassName);
        dataSourceProgrammatic.setPassword(password);
        dataSourceProgrammatic.setUrl(url);
    }
}
