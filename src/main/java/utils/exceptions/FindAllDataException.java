package utils.exceptions;


import utils.messages.LocaleContext;
import utils.messages.MessagesEnum;

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
