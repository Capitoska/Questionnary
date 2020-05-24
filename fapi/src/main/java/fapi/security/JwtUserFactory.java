package fapi.security;

import fapi.entity.RoleEntity;
import fapi.entity.UserEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;

public final class JwtUserFactory {
    public static JwtUser create(UserEntity userEntity) {
        return new JwtUser(userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                getAuthority(userEntity.getRole()));
    }

    private static Set<SimpleGrantedAuthority> getAuthority(RoleEntity role) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        return authorities;
    }
}
