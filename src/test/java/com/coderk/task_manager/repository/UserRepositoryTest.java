package com.coderk.task_manager.repository;

import com.coderk.task_manager.entity.UserData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class UserRepositoryTest  {
        @Autowired
        private UserRepository userRepository;

        @Test
        public void testCreateUser() {
                UserData user = new UserData();
                user.setUsername("testuser");
                user.setPassword("password");
                user.setEmail("testuser@example.com");

                UserData savedUser = userRepository.save(user);
                assertThat(savedUser).isNotNull();
                assertThat(savedUser.getId()).isNotNull();
        }
        @Test
        public void testFindByUsername() {
                UserData user = new UserData();
                user.setUsername("testuser");
                user.setPassword("password");
                user.setEmail("testuser@example.com");

                userRepository.save(user);

                Optional<UserData> foundUser = userRepository.findByUsername("testuser");
                assertThat(foundUser).isPresent();
        }


}
