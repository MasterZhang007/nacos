package com.alibaba.nacos.plugin.datasource.impl.postgres;

import com.alibaba.nacos.common.utils.CollectionUtils;
import com.alibaba.nacos.plugin.datasource.constants.DataSourceConstant;
import com.alibaba.nacos.plugin.datasource.constants.FieldConstant;
import com.alibaba.nacos.plugin.datasource.mapper.HistoryConfigInfoMapper;
import com.alibaba.nacos.plugin.datasource.model.MapperContext;
import com.alibaba.nacos.plugin.datasource.model.MapperResult;

/**
 * The postgresql implementation of {@link HistoryConfigInfoMapper}
 *
 * @author masterzhang007
 * @date 2024/11/29 15:00
 */
public class HistoryConfigInfoMapperByPostgresql extends AbstractMapperByPostgresql implements HistoryConfigInfoMapper {

    @Override
    public MapperResult removeConfigHistory(MapperContext context) {
        String sql = "DELETE FROM his_config_info WHERE gmt_modified < ? LIMIT ?";
        return new MapperResult(sql, CollectionUtils.list(context.getWhereParameter(FieldConstant.START_TIME),
                context.getWhereParameter(FieldConstant.LIMIT_SIZE)));
    }

    @Override
    public MapperResult pageFindConfigHistoryFetchRows(MapperContext context) {
        String sql = "SELECT nid,data_id,group_id,tenant_id,app_name,src_ip,src_user,op_type,ext_info,publish_type,gmt_create,gmt_modified "
                + "FROM his_config_info " + "WHERE data_id = ? AND group_id = ? AND tenant_id = ? ORDER BY nid DESC OFFSET "
                + context.getStartRow() + " LIMIT " + context.getPageSize();
        return new MapperResult(sql, CollectionUtils.list(context.getWhereParameter(FieldConstant.DATA_ID),
                context.getWhereParameter(FieldConstant.GROUP_ID), context.getWhereParameter(FieldConstant.TENANT_ID)));
    }

    @Override
    public String getDataSource() {
        return DataSourceConstant.POSTGRESQL;
    }
}
