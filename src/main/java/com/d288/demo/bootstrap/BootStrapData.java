package com.d288.demo.bootstrap;

import com.d288.demo.dao.CustomerRepository;
import com.d288.demo.dao.DivisionRepository;
import com.d288.demo.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
Initialize 5 sample customers data
 **/
@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (customerRepository.count()==1){
            Customer daniel=new Customer();
            daniel.setFirstName("Daniel");
            daniel.setLastName("Dan");
            daniel.setAddress("123 W Windows St");
            daniel.setPostal_code("12345");
            daniel.setPhone("1234567890");
            daniel.setDivision(divisionRepository.getReferenceById(3L));

            customerRepository.save(daniel);

            Customer michael=new Customer();
            michael.setFirstName("Michael");
            michael.setLastName("Mike");
            michael.setAddress("127 S Windows St");
            michael.setPostal_code("12222");
            michael.setPhone("1234565555");
            michael.setDivision(divisionRepository.getReferenceById(4L));

            customerRepository.save(michael);

            Customer bobby=new Customer();
            bobby.setFirstName("Bobby");
            bobby.setLastName("Bob");
            bobby.setAddress("121 E Windows St");
            bobby.setPostal_code("13333");
            bobby.setPhone("1234561111");
            bobby.setDivision(divisionRepository.getReferenceById(5L));

            customerRepository.save(bobby);

            Customer steven=new Customer();
            steven.setFirstName("Steven");
            steven.setLastName("Steve");
            steven.setAddress("120 N Windows St");
            steven.setPostal_code("19999");
            steven.setPhone("1234569999");
            steven.setDivision(divisionRepository.getReferenceById(6L));

            customerRepository.save(steven);

            Customer alexa=new Customer();
            alexa.setFirstName("Alexa");
            alexa.setLastName("Alex");
            alexa.setAddress("125 SW Windows St");
            alexa.setPostal_code("10000");
            alexa.setPhone("1234560000");
            alexa.setDivision(divisionRepository.getReferenceById(7L));

            customerRepository.save(alexa);

        }

    }
}

