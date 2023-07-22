package com.ssoptimus.sos.service;

import com.ssoptimus.sos.enums.CommonResponse;
import com.ssoptimus.sos.models.response.CommonResult;
import com.ssoptimus.sos.models.response.SingleResult;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {
    public <T> SingleResult<T> getSingleResult(T data){
        SingleResult<T> singleResult = new SingleResult<T>();
        singleResult.setData(data);
        setSuccessResult(singleResult);

        return singleResult;
    }


    public CommonResult getSuccessResult()
    {
        CommonResult commonResult = new CommonResult();
        setSuccessResult(commonResult);
        return new CommonResult();
    }

    public CommonResult getfailResult()
    {
        CommonResult commonResult = new CommonResult();
        setFailResult(commonResult);
        return new CommonResult();
    }

    public void setSuccessResult(CommonResult commonResult)
    {
        commonResult.setSuccess(true);
        commonResult.setCode(CommonResponse.SUCCESS.getCode());
        commonResult.setMessage(CommonResponse.SUCCESS.getMessage());
    }
    public void setFailResult(CommonResult commonResult)
    {
        commonResult.setSuccess(false);
        commonResult.setCode(CommonResponse.FAIL.getCode());
        commonResult.setMessage(CommonResponse.FAIL.getMessage());
    }


}
