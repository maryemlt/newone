package com.example.projetmpisi2.service;

import com.example.projetmpisi2.entity.User;
import com.example.projetmpisi2.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user1;

    @BeforeEach
    void setUp() {
        user1 = new User();
        user1.setId(1L);
        user1.setUsername("Mariam");
        user1.setEmail("mariam@example.com");
        user1.setPassword("password123");
    }

    @Test
    void saveUser() {
        when(userRepository.save(user1)).thenReturn(user1);

        User savedUser = userService.saveUser(user1);

        assertNotNull(savedUser);
        assertEquals("Mariam", savedUser.getUsername());
        verify(userRepository, times(1)).save(user1);
    }

    @Test
    void getAllUsers() {
        User user2 = new User(2L, "Ali", "ali@example.com", "pass123");
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> users = userService.getAllUsers();

        assertEquals(2, users.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void getUserById_found() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));

        User result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals("Mariam", result.getUsername());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void getUserById_notFound() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        User result = userService.getUserById(99L);

        assertNull(result);
        verify(userRepository, times(1)).findById(99L);
    }

    @Test
    void updateUser_existing() {
        when(userRepository.existsById(user1.getId())).thenReturn(true);
        when(userRepository.save(user1)).thenReturn(user1);

        User updatedUser = userService.updateUser(user1);

        assertNotNull(updatedUser);
        assertEquals("Mariam", updatedUser.getUsername());
        verify(userRepository, times(1)).save(user1);
    }

    @Test
    void updateUser_notExisting() {
        when(userRepository.existsById(user1.getId())).thenReturn(false);

        User result = userService.updateUser(user1);

        assertNull(result);
        verify(userRepository, never()).save(user1);
    }

    @Test
    void deleteUser() {
        doNothing().when(userRepository).deleteById(1L);

        userService.deleteUser(1L);

        verify(userRepository, times(1)).deleteById(1L);
    }
}
