package com.swf.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.swf.dao.CustomerDAO;
import com.swf.dto.CustomerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerStreamHandler {

    @Autowired
    private CustomerDAO customerDAO;
    
    
    public Mono<ServerResponse> getCustomersStreamRouter(ServerRequest request){
        Flux<CustomerDTO> customers = customerDAO.getCustomersStream();
        
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(customers, CustomerDTO.class);
    }
}
