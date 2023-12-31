package com.swf.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.swf.dao.CustomerDAO;
import com.swf.dto.CustomerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {

    @Autowired
    private CustomerDAO customerDAO;


    public Mono<ServerResponse> getCustomersRouter(ServerRequest request) {
        Flux<CustomerDTO> customers = customerDAO.getCustomersRouter();

        return ServerResponse.ok().body(customers, CustomerDTO.class);
    }

    public Mono<ServerResponse> getById(ServerRequest request) {
        int customerId = Integer.valueOf(request.pathVariable("input"));
        Mono<CustomerDTO> customerDTO =
                customerDAO.getCustomersRouter().filter(c -> c.getId() == customerId).next();
        return ServerResponse.ok().body(customerDTO, CustomerDTO.class);
    }

}
