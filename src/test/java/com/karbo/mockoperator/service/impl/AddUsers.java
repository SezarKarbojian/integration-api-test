package com.karbo.mockoperator.service.impl;

import com.karbo.mockoperator.api.User;
import com.karbo.mockoperator.repository.UserRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AddUsers {

    @Autowired
    private UserRepository repository;


    @Test
    @Ignore
    public void generateUser() {
        User user = new User().userId("user_123").userCat("VIP_SE").kycStatus("Approved")
                .sex("UNKNOWN").firstName("John").lastName("Jonsson").street("Exampel street 1")
                .city("Stockholm").zip("177 32").country("SWE").email("test@example.com")
                .dob("1981-01-01").mobile("+46733123123").balance(new BigDecimal("100.50"))
                .balanceCy("SEK").locale("sv_SE").reservedAmount(BigDecimal.ZERO);
        repository.save(user);
    }
}
