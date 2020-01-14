package demo1.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean(name = { "color" }, initMethod = "init", destroyMethod = "destroy")
	public Color getColorBean() {
		return new Color();
	}

	@Bean(name = { "circle" }, initMethod = "init", destroyMethod = "destroy")
	public Circle getCircle() {
		return new Circle();
	}

}
