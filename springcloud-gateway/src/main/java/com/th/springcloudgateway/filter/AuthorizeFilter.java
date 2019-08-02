package com.th.springcloudgateway.filter;

import com.th.client.service.IAuthService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Component 全局GlobalFilter过滤器
 *
 */
/**
 * 请求url权限校验
 */
@Configuration
@ComponentScan(basePackages = "com.th.client")
@Slf4j
public class AuthorizeFilter implements GlobalFilter, Ordered {

    private static final Log logger = LogFactory.getLog(AuthorizeFilter.class);
    /*private static final String AUTHORIZE_TOKEN="token";*/
    private final static String X_CLIENT_TOKEN_USER = "x-client-token-user";
    private final static String X_CLIENT_TOKEN = "x-client-token";

    /**
     * 由authentication-client模块提供签权的feign客户端
     */
    @Autowired
    private IAuthService authService;

    /**
     * 1.首先网关检查token是否有效，无效直接返回401，不调用签权服务
     * 2.调用签权服务器看是否对该请求有权限，有权限进入下一个filter，没有权限返回401
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String authentication = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        String method = request.getMethodValue();
        String url = request.getPath().value();
        log.debug("url:{},method:{},headers:{}", url, method, request.getHeaders());
        //不需要网关签权的url
        if (authService.ignoreAuthentication(url)) {
            return chain.filter(exchange);
        }
        //调用签权服务看用户是否有权限，若有权限进入下一个filter
        if (authService.hasPermission(authentication, url, method)) {
            ServerHttpRequest.Builder builder = request.mutate();
            //TODO 转发的请求都加上服务间认证token
            builder.header(X_CLIENT_TOKEN, "TODO zhoutaoo添加服务间简单认证");
            //将jwt token中的用户信息传给服务
            builder.header(X_CLIENT_TOKEN_USER, authService.getJwt(authentication).getClaims());
            return chain.filter(exchange.mutate().request(builder.build()).build());
        }
        return unauthorized(exchange);
    }

    /**
     * 网关拒绝，返回401
     *
     * @param
     */
    private Mono<Void> unauthorized(ServerWebExchange serverWebExchange) {
        serverWebExchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        DataBuffer buffer = serverWebExchange.getResponse()
                .bufferFactory().wrap(HttpStatus.UNAUTHORIZED.getReasonPhrase().getBytes());
        return serverWebExchange.getResponse().writeWith(Flux.just(buffer));
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
