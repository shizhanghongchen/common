package common.result;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author : wb-yxk397023
 * @Date : 2018/11/27
 */
public class PojoResult<T> extends BaseResult {

    private static final long serialVersionUID = 3696163636773650214L;

    private T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
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
