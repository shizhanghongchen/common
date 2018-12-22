package common.page;

import java.io.Serializable;
import java.util.Collection;

/**
 * @Author : wb-yxk397023
 * @Date : 2018/11/27
 */
public class Page<T> implements Serializable {

    private static final long serialVersionUID = 7827536282487683745L;
    private static final int MAX_PAGE_SIZE = 200;
    private Collection<T> items;

    private Integer totalCount;

    private Integer currentPage;

    private Integer pageSize;

    public Collection<T> getItems() {
        return items;
    }

    public void setItems(Collection<T> items) {
        this.items = items;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public DalPage toDalPage() {
        if (pageSize == null || pageSize <= 0 || pageSize > MAX_PAGE_SIZE) {
            pageSize = 20;
        }
        if (currentPage == null || currentPage <= 0) {
            currentPage = 1;
        }
        if (totalCount != null) {
            int maxPage = totalCount / pageSize + (totalCount % pageSize > 0 ? 1 : 0);
            if (currentPage > maxPage) {
                currentPage = maxPage;
            }
            if (currentPage == 0) {
                currentPage = 1;
            }
        }

        return new DalPage((currentPage - 1) * pageSize, pageSize);
    }

    @Override
    public String toString() {
        return "Page{" +
                "items=" + items +
                ", totalCount=" + totalCount +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
