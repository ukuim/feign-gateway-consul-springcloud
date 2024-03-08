package comAPi.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerProperties;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class GatewayConfig {

    private final LoadBalancerClientFactory loadBalancerClientFactory;
    private final LoadBalancerProperties properties;

    /**
     * 响应式框架中默认不会初始化HttpMessageConverters
     */
    @Bean
    @ConditionalOnMissingBean
    public HttpMessageConverters messageConverters(ObjectProvider<HttpMessageConverter<?>> converters) {
        return new HttpMessageConverters(converters.orderedStream().collect(Collectors.toList()));
    }

    /**
     * 响应式框架中，无法使用feign处理
     */
    @Bean
    public LoadBalancerClient BlockingLoadBalancerClient() {
        return new BlockingLoadBalancerClientConfig(loadBalancerClientFactory, properties);
    }
}

