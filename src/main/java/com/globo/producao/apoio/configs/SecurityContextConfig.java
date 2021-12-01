package com.globo.producao.apoio.configs;


import com.globo.ad.core.security.SecurityContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({SecurityContext.class})
public class SecurityContextConfig {

}
