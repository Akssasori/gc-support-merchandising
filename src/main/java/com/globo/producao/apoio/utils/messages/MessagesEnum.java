package com.globo.producao.apoio.utils.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessagesEnum {

    /**
     * Message error for insert data.
     */
    ERROR_INSERT_DATA("enum.error.insert.data"),

    /**
     * Message error for find all data.
     */
    ERROR_FIND_ALL_DATA("enum.error.find_all.data");

    /**
     * messageKey value.
     */
    private final String messageKey;
}
