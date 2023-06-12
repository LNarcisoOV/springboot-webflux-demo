package com.swf.model;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoTest {
    
    @Test
    public void monoTest() {
        Mono<String> monoString = Mono.just("MonoString").log();
        monoString.subscribe(System.out::println);
    }

}
