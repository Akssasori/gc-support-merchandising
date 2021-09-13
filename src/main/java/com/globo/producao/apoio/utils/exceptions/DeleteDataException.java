package com.globo.producao.apoio.utils.exceptions;

import com.globo.producao.apoio.utils.messages.LocaleContext;
import com.globo.producao.apoio.utils.messages.MessagesEnum;

public class DeleteDataException extends Exception {

    /**
     * Initialize DeleteDataException with message error.
     *
     * @param msgError Message error to initialize
     */
    public DeleteDataException(final String msgError) {
        super(LocaleContext.format(
                MessagesEnum.ERROR_DELETE_DATA.getMessageKey(), msgError));
    }

    /**
     * Initialize DeleteDataException with message error.
     *
     * @param messagesEnum Message error to initialize
     * @param args
     */
    public DeleteDataException(final MessagesEnum messagesEnum, final Object... args) {
        super(LocaleContext.format(messagesEnum.getMessageKey(), args));
    }
}
