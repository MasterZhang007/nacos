package com.alibaba.nacos.plugin.datasource.enums.postgres;

import java.util.HashMap;
import java.util.Map;

/**
 * The TrustedSqlFunctionEnum enum class is used to enumerate and manage a list of trusted built-in SQL functions.
 * By using this enum, you can verify whether a given SQL function is part of the trusted functions list
 * to avoid potential SQL injection risks.
 *
 * @author masterzhang007
 * @date 2024/11/29 11:44
 */
public enum TrustedPostgresqlFunctionEnum {

    /**
     * NOW().
     */
    NOW("NOW()", "CURRENT_TIMESTAMP");

    private static final Map<String, TrustedPostgresqlFunctionEnum> LOOKUP_MAP = new HashMap<>();

    static {
        for (TrustedPostgresqlFunctionEnum entry : TrustedPostgresqlFunctionEnum.values()) {
            LOOKUP_MAP.put(entry.functionName, entry);
        }
    }

    private final String functionName;

    private final String function;

    TrustedPostgresqlFunctionEnum(String functionName, String function) {
        this.functionName = functionName;
        this.function = function;
    }

    /**
     * Get the function name.
     *
     * @param functionName function name
     * @return function
     */
    public static String getFunctionByName(String functionName) {
        TrustedPostgresqlFunctionEnum entry = LOOKUP_MAP.get(functionName);
        if (entry != null) {
            return entry.function;
        }
        throw new IllegalArgumentException(String.format("Invalid function name: %s", functionName));
    }
}
