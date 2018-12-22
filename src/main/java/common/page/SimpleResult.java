package common.page;


import com.alibaba.fastjson.JSONObject;
import common.result.BaseResult;
import common.result.SimpleData;

/**
 * @Author : wb-yxk397023
 * @Date : 2018/11/27
 */
public class SimpleResult<T> extends BaseResult {

    private static final long serialVersionUID = 3696163636773650214L;

    private SimpleData<T> content;

    public SimpleData<T> getContent() {
        return content;
    }

    public void setContent(SimpleData<T> content) {
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
