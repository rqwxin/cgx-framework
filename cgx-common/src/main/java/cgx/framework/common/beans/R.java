package cgx.framework.common.beans;

import cgx.framework.common.exception.ErrorCode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@ApiModel("通用返回对象")
public class R<T> implements Serializable {
    private static final String SUCCESS_CODE = "000000";
    @ApiModelProperty("请求ID")
    private String requestId;
    @ApiModelProperty("返回编码")
    private String code;
    @ApiModelProperty("返回信息")
    private String message;
    @ApiModelProperty("处理时间对象")
    private Time time;
    @ApiModelProperty("访问路径")
    private String path;
    @ApiModelProperty("返回对象")
    private T body;

    public static <T> R<T> create(String code, String message, T body) {
        R<T> responseResult = new R<>();
        responseResult.setCode(code);
        responseResult.setMessage(message);
        responseResult.setBody(body);
        return responseResult;
    }

    public static <T> R<T> success(T body, String message) {
        return create(SUCCESS_CODE, message, body);
    }

    public static <T> R<T> successData(T body) {
        return create(SUCCESS_CODE, null, body);
    }

    public static <T> R<T> errorMsg(String errorCode, String message) {
        return create(errorCode, message, null);
    }

    public static <T> R<T> errorMsg(ErrorCode errorCode) {
        return create(errorCode.getErrorCode(), errorCode.getErrorMsg(), null);
    }


    public static <T> R<T> errorMsg(ErrorCode errorCode, Object... params) {
        return create(errorCode.getErrorCode(), String.format(errorCode.getErrorMsg(), params), null);
    }

    public static <T> R<T> successMsg(String message) {
        return create(SUCCESS_CODE, message, null);
    }

    public static <T> R<T> success() {
        return create(SUCCESS_CODE, null, null);
    }


    @JsonIgnore
    public boolean isSuccess() {
        return SUCCESS_CODE.equals(this.code);
    }

    @JsonIgnore
    public boolean isError() {
        return !isSuccess();
    }

    @Data
    @ApiModel("处理时间对象")
    public static class Time {
        @ApiModelProperty("开始时间戳")
        private Long startTime;
        @ApiModelProperty("结束时间戳")
        private Long endTime;
        @ApiModelProperty("响应毫秒")
        private Long totalResponse;
    }
}
