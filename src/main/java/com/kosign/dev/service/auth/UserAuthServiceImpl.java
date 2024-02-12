package com.kosign.dev.service.auth;

import com.kosign.dev.domain.users.UserRepository;
import com.kosign.dev.payload.auth.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAuthServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * @param email the username identifying the user whose data is required.
     * @return SecurityUser
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        var user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new SecurityUser(user);
    }
}
