package com.bjh.apipassenger.service;

import com.bjh.internalcommon.dto.ResponseResult;
import com.bjh.internalcommon.dto.servicepassengeruser.request.LoginRequest;

public interface ServicePassengerUserService {

    public ResponseResult login(String passengerPhone);
}
