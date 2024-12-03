package com.alibaba.nacos.plugin.datasource.impl.postgres;

import com.alibaba.nacos.plugin.datasource.enums.postgres.TrustedPostgresqlFunctionEnum;
import com.alibaba.nacos.plugin.datasource.mapper.AbstractMapper;

/**
 * The abstract postgresql mapper contains CRUD methods.
 *
 * @author masterzhang007
 * @date 2024/11/29 11:31
 */
public abstract class AbstractMapperByPostgresql extends AbstractMapper {

    @Override
    public String getFunction(String functionName) {
        return TrustedPostgresqlFunctionEnum.getFunctionByName(functionName);
    }
}
