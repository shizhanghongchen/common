package common.result;

import com.alibaba.fastjson.JSONObject;
import common.page.Page;

/**
 * @Author : wb-yxk397023
 * @Date : 2018/11/27
 */
public class PageResult<T> extends BaseResult {

    private static final long serialVersionUID = 7944192044185215906L;

    private Page<T> content;

    public PageResult() {
    }

    public PageResult(Page<T> content) {
        this.content = content;
    }

    public Page<T> getContent() {
        return content;
    }

    public void setContent(Page<T> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        JSONObject jo = new JSONObject();
        jo.put("code", getCode());
        jo.put("message", getMessage());
        jo.put("content", content);
        return jo.toString();
    }
}
