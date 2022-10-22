package cgx.framework.common.swagger;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

@EnableOpenApi
@ConditionalOnClass(Docket.class)
public class SwaggerConfig {

    @Bean
    @ConditionalOnMissingBean(Docket.class)
    public Docket createRestApi() {
        List<RequestParameter> globalRequestParameters = new ArrayList<>();
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(Boolean.TRUE)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .globalRequestParameters(globalRequestParameters);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .build();
    }
}
