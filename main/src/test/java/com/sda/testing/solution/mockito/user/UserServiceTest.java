package com.sda.testing.solution.mockito.user;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
        assertThrows(Exception.class,() -> userService.getUserById(notExistingId));

    }

}

