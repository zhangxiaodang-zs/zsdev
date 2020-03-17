package com.sdzs.zsdev.web.wxuser;

import com.sdzs.zsdev.core.response.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WxuserRequest extends BaseRequest {

    // 微信昵称
    private String nickname = "";

    // 手机号码
    private String phonenumber = "";
}
