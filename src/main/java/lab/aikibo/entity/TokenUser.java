package lab.aikibo.entity;

import lab.aikibo.constant.Role;
import lombok.Getter;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by tamami on 29/12/16.
 */
public class TokenUser extends org.springframework.security.core.userdetails.User {

    @Getter
    private lab.aikibo.entity.User user;

    public TokenUser(User user) {
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public Long getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }

}
