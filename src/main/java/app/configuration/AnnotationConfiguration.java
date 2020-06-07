package app.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(value = {"app"})
@EnableAspectJAutoProxy
public class AnnotationConfiguration {
}
