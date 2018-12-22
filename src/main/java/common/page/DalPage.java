package common.page;

/**
 * @Author : wb-yxk397023
 * @Date : 2018/11/27
 */
public class DalPage {
    /**
     * 分页查询开始记录位置
     */
    private int begin;
    /**
     * 分页查看下结束位置
     */
    private int end;
    /**
     * 每页显示记录数
     */
    private int length;
    /**
     * 查询结果总记录数
     */
    private int count;
    /**
     * 当前页码
     */
    private int current;
    /**
     * 总共页数
     */
    private int total;

    /**
     * 构造函数
     *
     * @param begin
     * @param length
     */
    public DalPage(int begin, int length) {
        this.begin = begin;
        this.length = length;
        this.end = this.begin + this.length;
        this.current = (int) Math.floor((this.begin * 1.0d) / this.length) + 1;
    }

    /**
     * @param begin
     * @param length
     * @param count
     */
    public DalPage(int begin, int length, int count) {
        this(begin, length);
        setCount(count);
    }

    /**
     * @return the begin
     */
    public int getBegin() {
        return begin;
    }

    /**
     * @return the end
     */
    public int getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(int end) {
        this.end = end;
    }

    /**
     * @param begin the begin to set
     */
    public void setBegin(int begin) {
        this.begin = begin;
        if (this.length != 0) {
            this.current = (int) Math.floor((this.begin * 1.0d) / this.length) + 1;
        }
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
        if (this.begin != 0) {
            this.current = (int) Math.floor((this.begin * 1.0d) / this.length) + 1;
        }
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * 设置数据总条数, 调用此方法前必须设置begin和length
     * 如果begin >= count, 则默认重置为最后一页
     *
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
        this.total = (count - 1) / this.length + 1;
        if(this.begin >= count) {
            this.begin = (this.total -1) * this.length;
            this.end = this.begin + this.length;
            this.current = this.begin / this.length + 1;
        }
    }

    /**
     * @return the current
     */
    public int getCurrent() {
        return current;
    }

    /**
     * @param current the current to set
     */
    public void setCurrent(int current) {
        this.current = current;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        if (total == 0) {
            return 1;
        }
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

}
