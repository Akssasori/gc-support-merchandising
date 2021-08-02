package com.globo.producao.apoio.utils.exceptions;


import com.globo.producao.apoio.utils.messages.LocaleContext;
import com.globo.producao.apoio.utils.messages.MessagesEnum;

public class FindAllDataException extends Exception {

    /**
     * Initialize FindAllDataException with message error.
     *
     * @param msgError Message error to initialize
     */
    public FindAllDataException(final String msgError){
        super(LocaleContext.format(
                MessagesEnum.ERROR_FIND_ALL_DATA.getMessageKey(), msgError));
    }



}
