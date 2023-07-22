package com.ssoptimus.sos.models.response;

import lombok.Getter;
import lombok.Setter;

@Getter
public class SingleResult<T> extends CommonResult {

    private T data;

    public void setData(T data){
        this.data = data;
    }
}
