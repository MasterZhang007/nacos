package com.alibaba.nacos.plugin.datasource.impl.postgres;

import com.alibaba.nacos.common.utils.CollectionUtils;
import com.alibaba.nacos.plugin.datasource.constants.DataSourceConstant;
import com.alibaba.nacos.plugin.datasource.constants.FieldConstant;
import com.alibaba.nacos.plugin.datasource.mapper.TenantCapacityMapper;
import com.alibaba.nacos.plugin.datasource.model.MapperContext;
import com.alibaba.nacos.plugin.datasource.model.MapperResult;

/**
 * The postgresql implementation of {@link TenantCapacityMapper}
 *
 * @author masterzhang007
 * @date 2024/11/29 15:04
 */
public class TenantCapacityMapperByPostgresql extends AbstractMapperByPostgresql implements TenantCapacityMapper {

    @Override
    public String getDataSource() {
        return DataSourceConstant.POSTGRESQL;
    }

    @Override
    public MapperResult getCapacityList4CorrectUsage(MapperContext context) {
        String sql = "SELECT id, tenant_id FROM tenant_capacity WHERE id>? LIMIT ?";
        return new MapperResult(sql, CollectionUtils.list(context.getWhereParameter(FieldConstant.ID),
                context.getWhereParameter(FieldConstant.LIMIT_SIZE)));
    }
}
