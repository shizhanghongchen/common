package common.page;

/**
 * @author wb-dwl358276@alibaba-inc.com
 * @create 2018/5/8 16:12
 **/
public enum PageEnum {
    /**
     * 默认第一页
     */
    DEFAULT_PAGE_NUM(1),
    /**
     * 默认每页的个数
     */
    DEFAULT_PAGE_SIZE(10),
    /**
     * 每页最大的个数
     */
    DEFAULT_PAGE_SIZE_MAX(200);
    private int code;

    PageEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return new StringBuilder("PageEnum{")
                .append("code=").append(code)
                .append("'}").toString();
    }
}
