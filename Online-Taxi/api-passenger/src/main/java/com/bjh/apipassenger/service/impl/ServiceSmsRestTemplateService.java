package com.bjh.apipassenger.service.impl;

import com.bjh.internalcommon.dto.ResponseResult;
import com.bjh.internalcommon.dto.servicesms.request.SmsSendRequest;

public interface ServiceSmsRestTemplateService {

    public ResponseResult sendSms(String phoneNumber , String code);
}
