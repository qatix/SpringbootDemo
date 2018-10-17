package com.qatix.hello.mongo;

import com.qatix.hello.entity.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception{
        Customer customer1 =  new Customer("C11111A", "Alice", "Chengdu", 0);
        Customer customer2 = new Customer("C22222B", "Bob", "Beijing", 1);
        assertNull(customer1.getId());
        assertNull(customer2.getId());

        this.customerRepository.save(customer1);
        this.customerRepository.save(customer2);

        assertNotNull(customer1.getId());
        assertNotNull(customer2.getId());
    }

    @Test
    public void testFetchData(){
        Customer customerA = this.customerRepository.findByOpenid("C11111A");
        assertNotNull(customerA);
        assertEquals(customerA.nickname,"Alice");

        Iterable<Customer> customers = customerRepository.findAll();
        int count = 0;
        for (Customer c : customers){
            count++;
        }
        assertEquals(count,2);
    }

    @Test
    public void testDataUpdate(){
        Customer customerB = customerRepository.findByOpenid("C22222B");
        customerB.setNickname("Willian");
        customerRepository.save(customerB);
        Customer customerC = customerRepository.findByOpenid("C22222B");
        assertNotNull(customerC);
        assertEquals("Willian",customerC.getNickname());
    }

    @After
    public void tearDown() throws Exception{
        this.customerRepository.deleteAll();
        System.out.println("delete all");
    }
}
