package de.dev.schleis.showcase.feign.adapter;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@FeignClient(name = "CustomerService", url = "http://localhost:8085/customer")
public interface CustomerClient {
    @RequestMapping(value = "/findAll", method = GET)
    List<CustomerDTO> findAllCustomers();

    @RequestMapping(value = "/{id}", method = GET)
    CustomerDTO findCustomerById(@PathVariable("id") final Long id);

    @RequestMapping(value = "/", method = POST)
    CustomerDTO createCustomer(final CustomerDTO customerDTO);

    @RequestMapping(value = "/deleteAll", method = DELETE)
    void deleteAllCustomers();

}
