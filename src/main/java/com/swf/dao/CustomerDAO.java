package com.swf.dao;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;
import com.swf.dto.CustomerDTO;

@Component
public class CustomerDAO {

    public List<CustomerDTO> getCustomers() {
        return IntStream.rangeClosed(1, 50)
                .peek(i -> System.out.println("processing count : " + i))
                .mapToObj(i -> new CustomerDTO(i, "customer " + i))
                .toList();
    }

}
