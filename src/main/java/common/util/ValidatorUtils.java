package common.util;


import org.apache.commons.collections4.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 参数校验工具类
 */
public class ValidatorUtils {

    public static final int NUMBER_SIXTEEN = 16;

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * 使用默认分组
     *
     * @param object
     * @return
     */
    public static <T> Map<String, StringBuilder> validate(T object) {
        return validate(object, Default.class);
    }

    /**
     * 使用指定分组
     *
     * @param object
     * @param groups 分组
     * @return
     */
    public static <T> Map<String, StringBuilder> validate(T object, Class<?>... groups) {
        Map<String, StringBuilder> errorMap = new HashMap(ValidatorUtils.NUMBER_SIXTEEN);
        Set<ConstraintViolation<T>> set = validator.validate(object, groups);
        if (CollectionUtils.isEmpty(set)) {
            return Collections.emptyMap();
        }
        for (ConstraintViolation<T> c : set) {
            // 这里循环获取错误信息，可以自定义格式
            String property = c.getPropertyPath().toString();
            if (errorMap.get(property) == null) {
                StringBuilder sb = new StringBuilder(c.getMessage());
                errorMap.put(property, sb);
                continue;
            }
            errorMap.get(property).append(",").append(c.getMessage());

        }
        return errorMap;

    }
}
