package programmatic;

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

public class ProgrammaticPropertyPlaceholderConfigurer extends PropertySourcesPlaceholderConfigurer {
    public ProgrammaticPropertyPlaceholderConfigurer() {
        setLocation(new ClassPathResource("db.properties"));
    }
}