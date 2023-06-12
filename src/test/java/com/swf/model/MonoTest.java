package com.swf.model;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoTest {
    
    @Test
    public void monoTest() {
        Mono<String> monoString = Mono.just("MonoString").log();
        monoString.subscribe(System.out::println);
    }
    
    @Test
    public void monoTestOnError() {
        Mono<?> monoString = Mono.just("MonoString")
                .then(Mono.error(new RuntimeException("Calling onError() method.")))
                .log();
        monoString.subscribe(System.out::println, e -> System.out.println(e.getMessage()));
    }
    
    @Test
    public void fluxTest() {
        Flux<String> fluxString = Flux.just("FluxString","FluxString1","FluxString2")
                .concatWithValues("FluxString3")
                .log();
        fluxString.subscribe(System.out::println);
    }

}
