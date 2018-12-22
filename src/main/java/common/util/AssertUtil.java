package common.util;

/**
 * 分析服务_断言类
 *
 * @author WangBangMing
 */
public class AssertUtil {

    /**
     * 验证输入参数必填项
     *
     * @param argNames
     * @param args
     */
    public static void assertRequired(String argNames, Object... args) {
        String[] namesArray = argNames.split(",");
        StringBuffer argName = new StringBuffer("");
        int index = 0;
        boolean isNull = false;
        for (Object arg : args) {
            if (null == arg || arg.toString().length() == 0) {
                isNull = true;
                argName.append(namesArray[index]).append(" ");
            }
            index++;
        }
        if (isNull) {
            throw new IllegalArgumentException(argName.toString() + "不能为空");
        }
    }
}
