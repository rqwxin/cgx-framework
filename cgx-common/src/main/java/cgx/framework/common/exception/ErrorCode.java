package cgx.framework.common.exception;

/**
 */
public interface ErrorCode {
    /**
     * 获取错误编码
     *
     * @return 错误编码
     */
    String getErrorCode();

    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    String getErrorMsg();
}
