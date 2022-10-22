package cgx.framework.common.web;

import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 *  json 格式返回值 处理器
 */
public class JsonReturnValueHandler extends RequestResponseBodyMethodProcessor {

    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    public JsonReturnValueHandler(MappingJackson2HttpMessageConverter converters, ContentNegotiationManager manager, List<Object> requestResponseBodyAdvice) {
        super(Collections.singletonList(converters), manager, requestResponseBodyAdvice);
        this.mappingJackson2HttpMessageConverter = converters;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return false;
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws IOException, HttpMediaTypeNotAcceptableException, HttpMessageNotWritableException {
        super.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
    }
}
