package xml;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Source {

    private final DriverManagerDataSource dataSourceXml;

    public Source(DriverManagerDataSource dataSourceXml) {

        this.dataSourceXml = dataSourceXml;
    }

}
