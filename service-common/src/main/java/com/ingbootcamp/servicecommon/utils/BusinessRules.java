package com.ingbootcamp.servicecommon.utils;

import com.ingbootcamp.servicecommon.results.Result;
import com.ingbootcamp.servicecommon.results.SuccessResult;

public class BusinessRules {
    public static Result run(Result... args){
        for(Result result : args){
            if(!result.isSuccess()){
                return result;
            }
        }
        return new SuccessResult();
    }
}
