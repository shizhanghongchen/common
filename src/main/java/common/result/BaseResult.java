package common.result;


import common.exception.BizException;
import common.message.BaseMessageCode;
import common.message.BaseMessageCodeEnum;

import java.io.Serializable;

/**
 * @Author : wb-yxk397023
 * @Date : 2018/11/27
 */
public abstract class BaseResult implements Serializable {

    private static final long serialVersionUID = 5284320724683148034L;

    /**
     * 本次调用返回code
     */
    protected int code;

    /**
     * 本次调用返回消息
     */
    protected String message;

    public int getCode() {
        return code;
    }

    @Deprecated
    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    @Deprecated
    public void setMessage(String message) {
        this.message = message;
    }

    public BaseResult() {
        code = BaseMessageCodeEnum.SUCCESS.getCode();
        message = BaseMessageCodeEnum.SUCCESS.getMessage();
    }

    public BaseResult(BaseMessageCode messageCode) {
        code = messageCode.getCode();
        message = messageCode.getMessage();
    }
    /**
     * 设置业务异常描述信息messageCode
     *
     * @param messageCode 业务异常描述信息
     * @param <R>
     * @return
     */
    @Deprecated
    public <R extends BaseResult> R setErrorMessage(BaseMessageCode messageCode) {
        setCode(messageCode.getCode());
        setMessage(messageCode.getMessage());

        return (R)this;
    }

    /**
     * 透传底层业务异常描述信息messageCode
     *
     * @param result 业务异常描述信息,一般为HSFResult
     * @param <R>
     * @return
     */
    public <R extends BaseResult> R setMessageCode(BaseResult result) {
        code = result.getCode();
        message = result.getMessage();

        return (R)this;
    }

    /**
     * 设置业务异常描述信息messageCode
     *
     * @param messageCode 业务异常描述信息
     * @param <R>
     * @return
     */
    public <R extends BaseResult> R setMessageCode(BaseMessageCode messageCode) {
        code = messageCode.getCode();
        message = messageCode.getMessage();

        return (R)this;
    }

    /**
     * 设置业务异常信息
     *
     * @param e 业务异常描述信息
     * @param <R>
     * @return
     */
    @Deprecated
    public <R extends BaseResult> R setErrorMessageWithBizException(BizException e) {
        setCode(e.getBizCode());
        setMessage(e.getBizMessage());

        return (R)this;
    }

    /**
     * 设置业务异常信息
     *
     * @param e 业务异常描述信息
     * @param <R>
     * @return
     */
    public <R extends BaseResult> R setMessageCodeWithBizException(BizException e) {
        setCode(e.getBizCode());
        setMessage(e.getBizMessage());

        return (R)this;
    }

    /**
     * 设置未处理异常信息
     *
     * @param e 业务异常描述信息
     * @param <R>
     * @return
     */
    @Deprecated
    public <R extends BaseResult> R setErrorMessageWithNativeException(Exception e) {
        return setMessageCode(BaseMessageCodeEnum.SERVER_INTERNAL_ERROR);
    }

    /**
     * 设置未处理异常信息
     *
     * @param e 业务异常描述信息
     * @param <R>
     * @return
     */
    public <R extends BaseResult> R setMessageCodeWithNativeException(Exception e) {
        return setMessageCode(BaseMessageCodeEnum.SERVER_INTERNAL_ERROR);
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
