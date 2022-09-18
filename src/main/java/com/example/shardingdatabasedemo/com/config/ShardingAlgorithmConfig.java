package com.example.shardingdatabasedemo.com.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Properties;

/**
 * shardingAlgorithm
 */
@Slf4j
@Component(value = "shardingAlgorithmConfig")
public class ShardingAlgorithmConfig implements StandardShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection<String> tableNames, PreciseShardingValue<String> shardingValue) {

        /**
         * 若bizId为0，在user0中查找对应bizId的数据
         * 若bizId不为0，在user1中查找对应bizId的数据
         */
        String value = shardingValue.getValue();
        String tableCode = BizEnum.findTableCode(value);
        for (String tableName : tableNames) {
            if (tableName.endsWith(tableCode)) {
                return tableName;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<String> shardingValue) {
        return availableTargetNames;
    }


    @Override
    public String getType() {
        return null;
    }

    @Override
    public Properties getProps() {
        return null;
    }

    @Override
    public void init() {

    }

}
