package common.result;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author : wb-yxk397023
 * @Date : 2018/11/27
 */
public class SimpleData<T> {

    private static final long serialVersionUID = 3696163636773650214L;

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        JSONObject jo = new JSONObject();
        jo.put("data", data);
        return jo.toString();
    }
}
