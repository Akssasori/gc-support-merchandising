package com.globo.producao.apoio.configs;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;


@Configuration
public class MessagesConfig {

    /**
     * Configuration variable for charset encoding.
     */
    private static final String CHARSET_ENCODING = "UTF-8";

    /**
     * Configuration variable for classpath.
     */
    private static final String CLASSPATH = "classpath:i18n/messages";

    /**
     * Configuration variable for cache seconds, that use to reload the
     * messages file.
     */
    private static final int CACHE_SECONDS = 60;

    /**
     * Returns an MessageSource object that will be configured to use messages.
     * <p/>
     * like CHARSET_ENCODING, CLASSPATH, CACHE_SECONDS
     *
     * @return MessageSource object that will be configured to use messages
     * @see MessageSource
     */
    @Bean
    public static MessageSource loadMessageSource() {

        ReloadableResourceBundleMessageSource messageSource =
                new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames(CLASSPATH);
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding(CHARSET_ENCODING);
        messageSource.setCacheSeconds(CACHE_SECONDS);
        return messageSource;

    }
}
