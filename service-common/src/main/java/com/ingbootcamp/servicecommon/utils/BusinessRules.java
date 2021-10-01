package com.ingbootcamp.servicecommon.utils;

import com.ingbootcamp.servicecommon.results.ErrorResult;
import com.ingbootcamp.servicecommon.results.Result;
import com.ingbootcamp.servicecommon.results.SuccessResult;

public class BusinessRules {


    public static Result run(Result... logics) {

        for (Result result : logics) {
            if(!result.isSuccess()) {
                return result;
            }
        }
        return new SuccessResult();
    }


}