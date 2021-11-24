package ${package};

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.kaochong.teaching.common.annotation.ExcludeComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@ServletComponentScan
@EnableScheduling
@EnableFeignClients(basePackageClasses = Application.class, basePackages = {"${package}"})
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {ExcludeComponent.class})})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
