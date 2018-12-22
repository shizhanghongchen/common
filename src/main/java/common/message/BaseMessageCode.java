package common.message;

/**
 * @Author : wb-yxk397023
 * @Date : 2018/11/27
 */
public interface BaseMessageCode {
    /**
     * 获取业务描述信息Code
     * @return code信息
     */
    int getCode();

    /**
     * 获取业务描述信息Message
     * @return message信息
     */
    String getMessage();

}
