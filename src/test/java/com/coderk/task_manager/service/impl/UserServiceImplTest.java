package com.coderk.task_manager.service.impl;


import com.coderk.task_manager.entity.UserData;
import com.coderk.task_manager.repository.UserRepository;
import com.coderk.task_manager.serviceImpl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

   // @Mock
    //private BCryptPasswordEncoder bCryptPasswordEncoder;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterUser() {
        UserData user = new UserData();
        user.setUsername("testuser");
        user.setPassword("password");
        user.setEmail("testuser@example.com");

        when(userRepository.save(any(UserData.class))).thenReturn(user);
      //  when(bCryptPasswordEncoder.encode(any(String.class))).thenReturn("encodedPassword");

        UserData registeredUser = userService.register(user);
        assertThat(registeredUser).isNotNull();
        assertThat(registeredUser.getUsername()).isEqualTo("testuser");
        verify(userRepository, times(1)).save(any(UserData.class));
    }

    /*@Test
    public void testAuthenticateUser() {
        UserData user = new UserData();
        user.setUsername("testuser");
        user.setPassword("encodedPassword");
        user.setEmail("testuser@example.com");

        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));
       // when(bCryptPasswordEncoder.matches(any(String.class), any(String.class))).thenReturn(true);

       // UserData authenticatedUser = userService.authenticate("testuser", "password");
        assertThat(authenticatedUser).isNotNull();
       // assertThat(authenticatedUser.getUsername()).isEqualTo("testuser");
    }

     */
}
