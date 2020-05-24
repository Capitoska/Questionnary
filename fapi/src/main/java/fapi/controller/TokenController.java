package fapi.controller;

import fapi.dto.JwtResponse;
import fapi.dto.SignInDto;
import fapi.dto.UserDto;
import fapi.dto.UserNarrowingDto;
import fapi.security.TokenProvider;
import fapi.utils.AuthorizationBean;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/fapi/token")
@RestController
@Log4j2
public class TokenController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthorizationBean authorizationBean;

    @Autowired
    private TokenProvider tokenProvider;

    @Qualifier("defaultUserDetailsService")
    @Autowired
    private UserDetailsService userDetailsService;


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody SignInDto signInDto) throws Exception {
        authenticate(signInDto.getUsername(), signInDto.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(signInDto.getUsername());
        final String token = tokenProvider.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/authorized-user", method = RequestMethod.GET)
    public  ResponseEntity<UserNarrowingDto> getAuthorizedDTO(){
        UserDto userDto = authorizationBean.getAuthorizedUserDTO();
        UserNarrowingDto userNarrowingDto = new UserNarrowingDto();
        userNarrowingDto = userNarrowingDto.builder()
                .id(userDto.getId())
                .role(userDto.getRole())
                .username(userDto.getUsername())
                .build();
        log.info(userNarrowingDto.toString());
        return ResponseEntity.ok(userNarrowingDto);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}