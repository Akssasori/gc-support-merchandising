package com.globo.producao.apoio.utils.exceptions;


import com.globo.producao.apoio.utils.messages.LocaleContext;
import com.globo.producao.apoio.utils.messages.MessagesEnum;

public class InsertDataException extends Exception {

    /**
     * Initialize InsertDataException with message error.
     *
     * @param msgError Message error to initialize
     */
    public InsertDataException(final String msgError) {
        super(LocaleContext.format(
                MessagesEnum.ERROR_INSERT_DATA.getMessageKey(), msgError));
    }

    /**
     * Initialize InsertDataException with message error.
     *
     * @param messagesEnum Message error to initialize
     * @param args
     */
    public InsertDataException(final MessagesEnum messagesEnum, final Object... args) {
        super(LocaleContext.format(messagesEnum.getMessageKey(), args));
    }
}
