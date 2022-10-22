package cgx.framework.common.swagger;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(SwaggerConfig.class)
public @interface EnableSwagger {
}
