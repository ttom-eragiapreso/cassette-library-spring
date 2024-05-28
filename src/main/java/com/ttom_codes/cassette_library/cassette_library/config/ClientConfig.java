package com.ttom_codes.cassette_library.cassette_library.config;

import com.ttom_codes.cassette_library.cassette_library.client.DiscogsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Configuration
public class ClientConfig {
    @Value(value = "${discogs.baseUrl}")
    private String discogsBaseUrl;

    private final int clientMaxInMemorySize = -1;

    @Bean
    DiscogsClient getClient() {

        WebClient webclient = WebClient.builder()
                .baseUrl(discogsBaseUrl)
                .exchangeStrategies(ExchangeStrategies
                        .builder()
                        .codecs(codecs -> codecs
                                .defaultCodecs()
                                .maxInMemorySize(clientMaxInMemorySize))
                        .build())
                .defaultStatusHandler(HttpStatusCode::isError, resp -> Mono.empty())
                .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder()
                /*.blockTimeout(Duration.ofSeconds(3600L))
                .clientAdapter(WebClientAdapter.forClient(webclient))*/
                .build();

        return factory.createClient(DiscogsClient.class);
    }
}
