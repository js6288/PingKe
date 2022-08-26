package com.ljs.pingke.pojo;

import lombok.Data;

@Data
public class RegisterBody {

    private String username;
    private String password;
    private String stuNum;
    private String realName;
    private String code;
    private String uuid;
}
