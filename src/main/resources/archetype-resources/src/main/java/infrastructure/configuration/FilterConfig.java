package ${package}.infrastructure.configuration;

import com.kaochong.teaching.common.trace.TraceIdUtil;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean traceIdFilter() {
        return TraceIdUtil.traceIdFilter();
    }

}
