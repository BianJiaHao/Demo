package com.bjh.apipassenger.service.impl;

import com.bjh.internalcommon.dto.ResponseResult;
import com.bjh.internalcommon.dto.servicesms.request.SmsSendRequest;

public interface ServiceVerificationCodeRestTemplateService {

    public ResponseResult generatorCode(int identity, String phoneNumber);

    public ResponseResult verifyCode(int identity, String phoneNumber , String code);
}
