package com.alibaba.nacos.plugin.datasource.impl.postgres;

import com.alibaba.nacos.plugin.datasource.constants.DataSourceConstant;
import com.alibaba.nacos.plugin.datasource.mapper.ConfigInfoGrayMapper;
import com.alibaba.nacos.plugin.datasource.model.MapperContext;
import com.alibaba.nacos.plugin.datasource.model.MapperResult;

import java.util.Collections;

/**
 * The postgresql implementation of {@link ConfigInfoGrayMapper}.
 *
 * @author masterzhang007
 * @date 2024/11/29 11:55
 */
public class ConfigInfoGrayMapperByPostgresql extends AbstractMapperByPostgresql implements ConfigInfoGrayMapper {

    @Override
    public MapperResult findAllConfigInfoGrayForDumpAllFetchRows(MapperContext context) {
        String sql = " SELECT t.id,data_id,group_id,tenant_id,gray_name,gray_rule,app_name,content,md5,gmt_modified "
                + " FROM (  SELECT id FROM config_info_gray  ORDER BY id OFFSET " + context.getStartRow() + " LIMIT "
                + context.getPageSize() + " ) " + "g, config_info_gray t  WHERE g.id = t.id  ";
        return new MapperResult(sql, Collections.emptyList());
    }

    @Override
    public String getDataSource() {
        return DataSourceConstant.POSTGRESQL;
    }
}
