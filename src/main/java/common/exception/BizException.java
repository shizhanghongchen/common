package common.exception;


import common.message.BaseMessageCode;
import common.message.BaseMessageCodeEnum;

/**
 * @Author : wb-yxk397023
 * @Date : 2018/11/27
 */
public class BizException extends RuntimeException {

    private BaseMessageCode messageCode;

    /**
     * 默认无参业务异常类构造;
     * 如果需要设置其他messageCode, 请使用setMessageCode方法
     */
    public BizException() {
        this(BaseMessageCodeEnum.SUCCESS);
    }

    /**
     * 指定messageCode的业务异常类构造;
     * 如果需要修改为其他messageCode, 请使用setMessageCode方法
     */
    public BizException(BaseMessageCode messageCode) {
        super(messageCode.getCode() + messageCode.getMessage());
        this.messageCode = messageCode;
    }

    /**
     * 设置业务异常对应的messageCode,
     * 为了messageCode,不允许独立设置code和message
     *
     * @param messageCode 业务异常描述信息(code和message)
     */
    public void setMessageCode(BaseMessageCode messageCode) {
        this.messageCode = messageCode;
    }

    /**
     * 获取业务异常对应的messageCode
     *
     * @return 业务异常描述信息(code和message)
     */
    public BaseMessageCode getMessageCode() {
        return messageCode;
    }

    /**
     * 获取业务异常对应的Code
     *
     * @return 业务异常描述信息(code)
     */
    public int getBizCode() {
        return messageCode.getCode();
    }

    /**
     * 获取业务异常对应的Message
     *
     * @return 业务异常描述信息(message)
     */
    public String getBizMessage() {
        return messageCode.getMessage();
    }

    /**
     * 获取业务异常对应的Message和Code
     *
     * @return 业务异常描述信息(messageCode字符串信息)
     */
    public String getBizMessageCode() {
        return messageCode.toString();
    }
}
