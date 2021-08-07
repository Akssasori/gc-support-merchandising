package com.globo.producao.apoio.utils.exceptions;

import com.globo.producao.apoio.utils.messages.LocaleContext;
import com.globo.producao.apoio.utils.messages.MessagesEnum;

public class FindDataException extends Exception {
    /**
     * Initialize FindDataException with message error.
     *
     * @param msgError Message error to initialize
     */
    public FindDataException(final String msgError) {
        super(LocaleContext.format(
                MessagesEnum.ERROR_FIND_DATA.getMessageKey(), msgError));
    }

    /**
     * Initialize FindDataException with message error.
     *
     * @param messagesEnum Message error to initialize
     * @param args
     */
    public FindDataException(final MessagesEnum messagesEnum, final Object... args) {
        super(LocaleContext.format(messagesEnum.getMessageKey(), args));
    }
}
