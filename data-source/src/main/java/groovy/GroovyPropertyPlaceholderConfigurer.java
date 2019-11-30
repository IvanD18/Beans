package groovy;

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

public class GroovyPropertyPlaceholderConfigurer extends PropertySourcesPlaceholderConfigurer {
    public GroovyPropertyPlaceholderConfigurer() {
        setLocation(new ClassPathResource("db.properties"));
    }
}