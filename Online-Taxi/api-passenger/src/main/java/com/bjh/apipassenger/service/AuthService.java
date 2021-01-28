package com.bjh.apipassenger.service;

import com.bjh.internalcommon.dto.ResponseResult;

public interface AuthService {
    public ResponseResult auth(String passengerPhone, String code);
}
