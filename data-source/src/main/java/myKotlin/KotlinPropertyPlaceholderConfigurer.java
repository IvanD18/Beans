package myKotlin;

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

public class KotlinPropertyPlaceholderConfigurer extends PropertySourcesPlaceholderConfigurer {
    public KotlinPropertyPlaceholderConfigurer() {
        setLocation(new ClassPathResource("db.properties"));
    }
}