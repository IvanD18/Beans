package annotation;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component("dataSourceAnnotation")
public class DriverManagerDataSourceOwn extends DriverManagerDataSource {
}
