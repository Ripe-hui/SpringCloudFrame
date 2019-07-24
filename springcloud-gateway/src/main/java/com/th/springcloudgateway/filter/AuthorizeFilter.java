package com.th.springcloudgateway.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Component 全局GlobalFilter过滤器
 *
 */
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {
    private static final Log logger = LogFactory.getLog(AuthorizeFilter.class);
    private static final String AUTHORIZE_TOKEN="token";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("使用filter");
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        String token = headers.getFirst(AUTHORIZE_TOKEN);
        if (null == token){
            token=request.getQueryParams().getFirst(AUTHORIZE_TOKEN);
        }
        ServerHttpResponse response = exchange.getResponse();
        if (StringUtils.isEmpty(token)){
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return  response.setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
/**
 * 继承AbstractGatewayFilterFactory实现指定使用过滤器
 * filters:
 *            - StripPrefix=1
 *            - Authorize=true #启用过滤器 Authorize为过滤类的前缀
 */
    /*@Component
    public class AuthorizeGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthorizeGatewayFilterFactory.Config> {
        private static final Log logger = LogFactory.getLog(AbstractGatewayFilterFactory.class);
        public AuthorizeGatewayFilterFactory(){
            super(Config.class);
        }
        @Override
        public GatewayFilter apply(Config config) {
            return (exchange, chain) -> {
                ServerHttpRequest request =exchange.getRequest();
                String token = request.getHeaders().getFirst("token");
                logger.info("token:"+token);
                if (null == token){
                    token = request.getQueryParams().getFirst("token");
                }
                ServerHttpResponse response = exchange.getResponse();
                if (StringUtils.isEmpty(token)){
                    response.setStatusCode(HttpStatus.UNAUTHORIZED);
                    return response.setComplete();
                }
                return chain.filter(exchange);
            };
        }
        public static class Config{
            static String s="123456";
        }
    }*/

}
