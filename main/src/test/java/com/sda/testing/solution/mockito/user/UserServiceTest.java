package com.sda.testing.solution.mockito.user;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserValidator userValidator;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldReturnProperUser() {

        User savedUser = new User(4L, "Tomasz", "Dorszyk");
        when(userRepository.findById(savedUser.getId())).thenReturn(Optional.of(savedUser));
        User user = userService.getUserById(4l);
        assertEquals(savedUser, user);

    }

    @Test
    void shouldThrowExceptionWhenUserNotExists() {
        Long notExistingId = 878L;
        when(userRepository.findById((notExistingId))).thenReturn(Optional.empty());
        assertThrows(Exception.class, () -> userService.getUserById(notExistingId));

    }

    @Test
    void shouldThrowExceptionWhenAddingNotValidUser() {
        User user = new User(875L, "Tomasz", "Dorszyk");
        when(userValidator.isUserValid((user))).thenReturn(false);
        assertThrows(Exception.class, () -> userService.addUser(user));
    }

    @Test
    void shouldAddUser() {
        User user = new User("Dupa", "Blada");
        User savedUser = new User(2324L, user.getFirstName(), user.getLastName());

        when(userValidator.isUserValid(user)).thenReturn(true);
        when(userRepository.addUser(user)).thenReturn(savedUser);

        User addedUser = userService.addUser(user);

        assertEquals(savedUser, addedUser);
        assertNotSame(user, addedUser);
    }

}

