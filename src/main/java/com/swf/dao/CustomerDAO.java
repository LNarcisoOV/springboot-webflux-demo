package com.swf.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;
import com.swf.dto.CustomerDTO;
import reactor.core.publisher.Flux;

@Component
public class CustomerDAO {

    public List<CustomerDTO> getCustomers() {
        return IntStream.rangeClosed(1, 50)
                .peek(i -> System.out.println("processing count : " + i))
                .mapToObj(i -> new CustomerDTO(i, "customer " + i))
                .toList();
    }

    public Flux<CustomerDTO> getCustomersStream() {
        return Flux.range(1, 50)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("processing count in stream flow: " + i))
                .map(i -> new CustomerDTO(i, "customer " + i));
    }
    
    public Flux<CustomerDTO> getCustomersRouter() {
        return Flux.range(1, 50)
                .doOnNext(i -> System.out.println("processing count in stream flow: " + i))
                .map(i -> new CustomerDTO(i, "customer " + i));
    }


}
