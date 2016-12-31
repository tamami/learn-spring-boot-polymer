package lab.aikibo.auth;

import lab.aikibo.entity.TokenUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by tamami on 31/12/16.
 */
public class UserAuthentication implements Authentication {

    private final TokenUser user;
    @Getter @Setter
    private boolean authenticated = true;

    public UserAuthentication(TokenUser user) {
        this.user = user;
    }

    @Override
    public String getName() {
        return user.getUsername();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return user.getPassword();
    }

    @Override
    public TokenUser getDetails() {
        return user;
    }

    @Override
    public Object getPrincipal() {
        return user.getUsername();
    }


}
