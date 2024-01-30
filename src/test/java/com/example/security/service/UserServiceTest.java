//package com.example.security.Service;
//
//import com.example.security.Entity.UserEntity;
//import com.example.security.Repository.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.lang.annotation.Inherited;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class UserServiceTest {
//
//    @InjectMocks
//    private UserService userService;
//
//    @Mock
//    private UserRepository userRepository;
//
//
//    @Test
//    void getNormalData() {
//
//        String role="ROLE_NORMAL";
//        List<UserEntity> test=new ArrayList<>();
//        when(userService.getNormalData()).thenReturn(test);
//        List<UserEntity> expected=userRepository.findByRole(role);
//        assertEquals(test, expected);
//    }
//
//    @Test
//    void getManagerUsers() {
//        String role="ROLE_MANAGER";
//        List<UserEntity> test=new ArrayList<>();
//        when(userService.getManagerUsers()).thenReturn(test);
//        List<UserEntity> expected=userRepository.findByRole(role);
//        assertEquals(test,expected);
//    }
//
//    @Test
//    void saveUser() {
//        UserEntity user = new UserEntity();
//        when(userRepository.save(user)).thenReturn(user);
//        UserEntity expected=userRepository.save(user);
//        assertEquals(user, expected);
//    }
//
//    @Test
//    void getUser() {
//        String username = "User";
//        UserService userService = new UserService();
//        UserEntity expected = userService.getUser(username);
//        assertNull(expected);
//    }
//
//    @Test
//    void addUser() {
//        String username="test";
//        UserEntity user = new UserEntity();
//        user.setUsername(username);
//        UserEntity expected=userService.addUser(user);
//        assertEquals(user, expected);
//    }
//}