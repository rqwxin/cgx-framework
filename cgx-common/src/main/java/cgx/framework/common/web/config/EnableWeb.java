package cgx.framework.common.web.config;


import cgx.framework.common.swagger.SwaggerConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@Import(WebConfig.class)
public @interface EnableWeb {
}
