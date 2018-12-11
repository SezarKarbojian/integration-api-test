package com.karbo.mockoperator.service.impl;

import com.karbo.mockoperator.api.User;
import com.karbo.mockoperator.repository.TransactionRepository;
import com.karbo.mockoperator.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentServiceImplTest {


    private PaymentServiceImpl service;
    private UserRepository repository;
    private TransactionRepository transactionRepository;


    @Before
    public void setup() {
        repository = mock(UserRepository.class);
        transactionRepository = mock(TransactionRepository.class);
        service = new PaymentServiceImpl(repository,transactionRepository);
    }

    @Test
    public void shouldReturnUserIfExists() {
        //given
        User user = new User().userId("123");
        when(repository.findByUserId(anyString())).thenReturn(user);
        //when
        User returnedUser = service.getUser("123");
        //then
        assertThat(returnedUser.getUserId(), is("123"));
        assertThat(returnedUser.getSuccess(), is(true));
    }


    @Test
    public void shouldReturnPaymentResponseWithErrorIfUserNotFound() {
        //given
        when(repository.findByUserId(anyString())).thenReturn(null);
        //when
        User returnedUser = service.getUser("123");
        //then
        assertThat(returnedUser.getUserId(), is("123"));
        assertThat(returnedUser.getSuccess(), is(false));
        assertThat(returnedUser.getErrCode(), is("1234"));
        assertThat(returnedUser.getErrMsg(), is("Verification failed: User not found"));
    }

}