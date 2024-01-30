//package com.example.security.Controller;
//
//import com.example.security.Entity.UserEntity;
//import com.example.security.Repository.UserRepository;
//import com.example.security.Service.JwtService;
//import com.example.security.Service.UserService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//
////@SpringBootTest
//@ExtendWith(MockitoExtension.class)
//class UserControllerTest {
//
//
//    @InjectMocks
//    private UserController userController;
//
//    @Mock
//    private UserService userService;
//
//    @Mock
//    private JwtService jwtService;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Test
//    void getAllUserData() {
//        List<UserEntity> testData = new ArrayList<>();
//
//        when(userService.getNormalData()).thenReturn(testData);
//
//        ResponseEntity<Object> expected = userController.getAllUserData();
//
//        assertEquals(testData, expected.getBody());
//    }
//
//    @Test
//    void getAllManagerData() {
//        List<UserEntity> mangerData = new ArrayList<>();
//
//        when(userService.getManagerUsers()).thenReturn(mangerData);
//
//        ResponseEntity<Object> expected=userController.getAllManagerData();
//
//        assertEquals(mangerData, expected.getBody());
//    }
//
//    @Test
//    void saveUsers(){
//        UserEntity userEntity = new UserEntity();
//
//        when(userService.saveUser(userEntity)).thenReturn(userEntity);
//
//        ResponseEntity<Object> expected=userController.saveUsers(userEntity);
//
//        assertEquals(userEntity, expected.getBody());
//    }
//
//    @Test
//    void getUser(){
//        UserEntity user = new UserEntity();
//        String username = "testUser";
//
//        when(userService.getUser(username)).thenReturn(user);
//
//        UserEntity expected = userController.getUser(username);
//
//        assertEquals(user, expected);
//    }
//
//    @Test
//    void add(){
//        UserEntity user = new UserEntity();
//
//        when(userService.addUser(user)).thenReturn(user);
//
//        UserEntity expected = userController.add(user);
//
//        assertEquals(user, expected);
//    }
//
//    @Test
//    void authenticateAndGetToken(){
//
//        String username = "testUser";
//        String expectedToken = "testToken";
//
//        when(jwtService.generateToken(username)).thenReturn(expectedToken);
//
//        String expected = jwtService.generateToken(username);
//
//        assertEquals(expectedToken, expected);
//    }
//
//    @Test
//    void updateUserDataByAdmin(){
//        String username = "testUser";
//        UserEntity existingUser = new UserEntity();
//        existingUser.setUsername(username);
//
//        UserEntity updatedUserData = new UserEntity();
//        updatedUserData.setEmail("newemail@example.com");
//        updatedUserData.setPassword("newpassword");
//
//        when(userRepository.existsById(username)).thenReturn(true);
//        when(userRepository.findById(username)).thenReturn(java.util.Optional.of(existingUser));
//
//        when(userRepository.save(existingUser)).thenReturn(updatedUserData);
//
//        ResponseEntity<String> result = userController.updateUserDataByAdmin(username, updatedUserData);
//
//        assertEquals("Data updated successfully", result.getBody());
//    }
//
//}