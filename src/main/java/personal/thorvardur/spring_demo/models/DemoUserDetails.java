package personal.thorvardur.spring_demo.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DemoUserDetails implements UserDetails {

    /**
     * UserName of the user.
     */
    private String userName;

    /**
     * User's password.
     */
    private String password;

    /**
     * The authorities that the user has.
     */
    private List<GrantedAuthority> authorities;

    public DemoUserDetails(User user){
        userName = user.getUserName();
        password = user.getPassword();

        // If the user has no roles we return an empty list.
        authorities = user.getRoles() == null || user.getRoles().isEmpty() ? new ArrayList<>() :
                            Arrays.stream(user.getRoles().split(","))
                            .map(SimpleGrantedAuthority::new)
                            .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
