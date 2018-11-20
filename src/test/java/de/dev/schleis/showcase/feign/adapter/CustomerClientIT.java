package de.dev.schleis.showcase.feign.adapter;


import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class CustomerClientIT
{

    @Autowired
    private CustomerClient underTest;

    @Test
    public void findAll()
    {
        final List<CustomerDTO> results = underTest.findAllCustomers();

        log.info("------------------------------------------");
        results.forEach(result -> log.info(result.toString()));
        log.info("------------------------------------------");

        assertThat(results).isNotNull();
    }

    @Test
    public void createCustomer()
    {
        final CustomerDTO result = underTest.createCustomer(CustomerDTO.builder()
                .firstname("Han")
                .lastname("Solo")
                .build());

        log.info("------------------------------------------");
        log.info(result.toString());
        log.info("------------------------------------------");

        assertThat(result).isNotNull();
    }

    @Test
    public void findById()
    {
        final CustomerDTO result = underTest.findCustomerById(1L);

        log.info("------------------------------------------");
        log.info(result.toString());
        log.info("------------------------------------------");

        assertThat(result).isNotNull();
    }

    @Test(expected = FeignException.class)
    public void deleteCustomers()
    {
        underTest.deleteAllCustomers();
    }


}