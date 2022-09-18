package com.example.shardingdatabasedemo.com.config;

import lombok.Getter;

@Getter
public enum BizEnum {

    CN("0","0"),
    OTHER("","1");

    String bizId;
    String tableCode;

    BizEnum(String bizId, String tableCode) {
        this.bizId = bizId;
        this.tableCode = tableCode;
    }

    public static String findTableCode(String bizId){
        if (null == bizId){
            return "1";
        }
        BizEnum[] bizEnums =  BizEnum.values();
        for (BizEnum biz :bizEnums) {
            if (bizId.equals(biz.getBizId())){
                return biz.getTableCode();
            }
        }
        return "1";
    }
}
