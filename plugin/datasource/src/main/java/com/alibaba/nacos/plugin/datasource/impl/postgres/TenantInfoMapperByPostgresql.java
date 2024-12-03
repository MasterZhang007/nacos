package com.alibaba.nacos.plugin.datasource.impl.postgres;

import com.alibaba.nacos.plugin.datasource.constants.DataSourceConstant;
import com.alibaba.nacos.plugin.datasource.mapper.TenantInfoMapper;

/**
 * The postgresql implementation of {@link TenantInfoMapper}
 *
 * @author masterzhang007
 * @date 2024/11/29 15:04
 */
public class TenantInfoMapperByPostgresql extends AbstractMapperByPostgresql implements TenantInfoMapper  {
    @Override
    public String getDataSource() {
        return DataSourceConstant.POSTGRESQL;
    }
}
