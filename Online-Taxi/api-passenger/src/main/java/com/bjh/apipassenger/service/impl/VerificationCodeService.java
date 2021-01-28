package com.bjh.apipassenger.service.impl;

import com.bjh.internalcommon.dto.ResponseResult;

public interface VerificationCodeService {

    public ResponseResult send(String phoneNumber);

    public ResponseResult verify(String phoneNumber, String code);
}
