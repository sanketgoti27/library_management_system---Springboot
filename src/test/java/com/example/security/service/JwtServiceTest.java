//package com.example.security.Service;
//
//import com.example.security.Entity.UserEntity;
//import com.example.security.Entity.CustomUserDeatil;
//import com.example.security.service.implService.JwtService;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Date;
//import java.util.function.Function;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class JwtServiceTest {
//
//    @Mock
//    private JwtService jwtService;
//
//    @Mock
//    private Claims mockClaims;
//
//    @Test
//    void extractUsername() {
//        String username = "test";
//        String token = jwtService.generateToken(username);
//        String expectedUsername = "testUser";
//
//        when(mockClaims.getSubject()).thenReturn(expectedUsername);
//
//        String actualUsername = jwtService.extractUsername(token);
//
//        assertEquals(expectedUsername, actualUsername);
//    }
//
//    @Test
//    void extractExpiration() {
//        String username = "test";
//        String token = jwtService.generateToken(username);
//        Date expectedExpiration = new Date();
//
//        Claims mockClaims = mock(Claims.class);
//        when(jwtService.extractAllClaims(token)).thenReturn(mockClaims);
////        when(mockClaims.getExpiration()).thenReturn(expectedExpiration);
//
//        Date actualExpiration = jwtService.extractExpiration(token);
//
//        assertEquals(expectedExpiration, actualExpiration);
//    }
//
//
//    @Test
//    void extractClaim() {
//        String username = "test";
//        String token = jwtService.generateToken(username);
//        String expectedClaimValue = "testClaimValue";
//
//        // Set up the mockClaims object
//        Claims mockClaims = mock(Claims.class);
//
//        // Mock the behavior of getSubject() on mockClaims
//        when(jwtService.extractAllClaims(token)).thenReturn(mockClaims);
//        when(mockClaims.getSubject()).thenReturn(expectedClaimValue);
//
//        // Call the actual extractClaim method
//        String actualClaimValue = jwtService.extractClaim(token, Claims::getSubject);
//
//        // Assert that the expectedClaimValue matches the actualClaimValue
//        assertEquals(expectedClaimValue, actualClaimValue);
//    }
//
//
//
//    @Test
//    void generateToken() {
//        String username = "testUser";
//
//        String actualToken = jwtService.generateToken(username);
//
//        Claims actualClaims = jwtService.extractAllClaims(actualToken);
//
//        assertEquals(username, actualClaims.getSubject());
//    }
//
//    @Test
//    void validateToken() {
//        String username = "test";
//        String token = jwtService.generateToken(username);
//
//        // Mock the behavior of the extractUsername method
//        when(jwtService.extractUsername(token)).thenReturn(username);
//
//        // Mock the behavior of the isTokenExpired method
//        when(jwtService.isTokenExpired(token)).thenReturn(false); // assuming the token is not expired
//
//        UserEntity user = new UserEntity();
//        CustomUserDeatil userDetails = new CustomUserDeatil(user);
//
//        boolean isValid = jwtService.validateToken(token, userDetails);
//
//        // Verify that the token is considered valid
//        assertTrue(isValid);
//    }
//
//}
