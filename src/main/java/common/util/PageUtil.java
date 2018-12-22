package common.util;


import common.page.Page;
import common.page.PageEnum;

/**
 * @author Dyl
 */
public class PageUtil {
    /**
     * 分页参数修正
     *
     * @param page 分页信息
     */
    public static void pageCorrection(Page page) {
        pageCorrection(page, true);
    }

    /**
     * 分页参数修正
     *
     * @param page 分页信息
     */
    public static void pageCorrection(Page page, boolean maxPageSize) {
        if (page == null) {
            return;
        }
        Integer currentPage = page.getCurrentPage();
        if (currentPage == null || currentPage < PageEnum.DEFAULT_PAGE_NUM.getCode()) {
            page.setCurrentPage(PageEnum.DEFAULT_PAGE_NUM.getCode());
        }
        Integer pageSize = page.getPageSize();
        if (pageSize == null || pageSize <= 0) {
            pageSize = PageEnum.DEFAULT_PAGE_SIZE.getCode();
            page.setPageSize(PageEnum.DEFAULT_PAGE_SIZE.getCode());
        }
        if (maxPageSize && pageSize > PageEnum.DEFAULT_PAGE_SIZE_MAX.getCode()) {
            page.setPageSize(PageEnum.DEFAULT_PAGE_SIZE_MAX.getCode());
        }
    }
}
