package common.message;

/**
 * @Author : wb-yxk397023
 * @Date : 2018/11/27
 */
public enum BaseMessageCodeEnum implements BaseMessageCode {

    /**
     * 业务操作成功对应的MessageCode定义
     */
    SUCCESS(200, "成功"),

    /**
     * 使用ajax访问数据接口时,后台需要前端配合执行重定向操作
     */
    REDIRECTION(302, "重定向"),

    /**
     * 使用ajax访问数据接口时,无法找到对应的资源或者接口定义,返回该错误码
     */
    NO_LOGIN(401, "用户未登录"),
    /**
     * 使用ajax访问数据接口时,无法找到对应的资源或者接口定义,返回该错误码
     */
    NOT_FOUND(404, "无法找到资源或者接口定义"),

    /**
     * 前端入参类型不匹配错误处理,返回该错误码
     */
    PARAMENTER_TYPE_INCONFORMITY(410, "传入参数类型不一致"),

    /**
     * 前端入参不合法
     */
    PARAMENTER_NOT_VALID(411, "前端入参不合法"),

    /**
     * 服务器发生未知内部错误,返回该错误码
     */
    SERVER_INTERNAL_ERROR(500, "服务器内部错误"),

    /**
     * 服务端调用HSF接口出现异常,返回该错误码
     */
    SERVER_HSF_INTERFACE_ERROR(520, "服务器内部错误"),

    /**
     * 服务端调用HSF接口出现参数异常,返回该错误码
     */
    SERVER_HSF_ILLEGAL_ARGUMENT_ERROR(521, "服务器内部错误"),






    /**
     * 最大公共MessageCode定义, 即小于10000的code,业务不允许占用
     */
    MAX_BASE_CODE(9999, "最大公共MessageCode占位");

    private int code;
    private String message;

    BaseMessageCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "BaseMessageCodeEnum{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
