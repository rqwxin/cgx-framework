package cgx.framework.common.web.config;


import cgx.framework.common.constants.CommonConstants;
import cgx.framework.common.web.MyReturnValueHandler;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    /**
     * 自定义返回值处理
     * @param handlers initially an empty list
     */
    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
        handlers.add(new MyReturnValueHandler(Collections.singletonList(mappingJackson2HttpMessageConverter)));
    }



    /**
     * 配置信息转换器
     *  配置自带的jackson配置项
     *
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.stream().filter(item -> MappingJackson2HttpMessageConverter.class.isAssignableFrom(item.getClass())).findFirst().ifPresent(
                value -> {
                    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = (MappingJackson2HttpMessageConverter) value;
                    SimpleModule simpleModule = new SimpleModule();
                    //设置long型返回前端为string,避免前端精度丢失
                    simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
                    simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
                    mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("application", "json", Charset.forName("UTF-8")),
                            new MediaType("application", "x-www-form-urlencoded", Charset.forName("UTF-8"))));
                    mappingJackson2HttpMessageConverter.getObjectMapper()
                            .setDateFormat(new SimpleDateFormat(CommonConstants.DATETIME_FORMAT))
                            .registerModule(simpleModule)
                            //配置时间默认转换为时间戳
                            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true)
                            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

                }
        );
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

    }


//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new PreHandlerInterceptor());
//    }




}
