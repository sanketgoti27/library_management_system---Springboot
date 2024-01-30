//package com.example.security.Controller;
//
//import com.example.security.Entity.JwtRequest;
//import com.example.security.Service.JwtService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//@WebMvcTest(AuthController.class)
//public class AuthControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private AuthenticationManager authenticationManager;
//
//    @MockBean
//    private UserDetailsService userDetailsService;
//
//    @MockBean
//    private JwtService jwtService;
//
//    @Test
//    public void testAuthenticateAndGetTokenSuccess() throws Exception {
//        JwtRequest jwtRequest = new JwtRequest("username", "password");
//
//        // Mock the authentication manager to return a successful authentication
//        Authentication authentication = Mockito.mock(Authentication.class);
//        Mockito.when(authenticationManager.authenticate(Mockito.any()))
//                .thenReturn(authentication);
//        Mockito.when(authentication.isAuthenticated()).thenReturn(true);
//
//        // Mock the JwtService to return a token
//        Mockito.when(jwtService.generateToken("username"))
//                .thenReturn("mocked_token");
//
//        // Perform the request and assert the response
//        mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(jwtRequest)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("mocked_token"));
//    }
//
//    @Test
//    public void testAuthenticateAndGetTokenInvalidCredentials() throws Exception {
//        JwtRequest jwtRequest = new JwtRequest("invalid_username", "invalid_password");
//
//        // Mock the authentication manager to throw BadCredentialsException
//        Mockito.when(authenticationManager.authenticate(Mockito.any()))
//                .thenThrow(new BadCredentialsException("Invalid credentials"));
//
//        // Perform the request and assert the response
//        mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(jwtRequest)))
//                .andExpect(MockMvcResultMatchers.status().isForbidden())
//                .andExpect(MockMvcResultMatchers.content().string("Invalid credentials"));
//    }
//
//    @Test
//    public void testAuthenticateAndGetTokenException() throws Exception {
//        JwtRequest jwtRequest = new JwtRequest("username", "password");
//
//        // Mock the authentication manager to throw an exception
//        Mockito.when(authenticationManager.authenticate(Mockito.any()))
//                .thenThrow(new RuntimeException("Some error occurred"));
//
//        // Perform the request and assert the response
//        mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(jwtRequest)))
//                .andExpect(MockMvcResultMatchers.status().isForbidden())
//                .andExpect(MockMvcResultMatchers.content().string("Invalid Please Check Username and Password "));
//    }
//
//    // Helper method to convert object to JSON string
//    private static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
