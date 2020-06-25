package personal.thorvardur.spring_demo.models;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    /**
     * The id of the user. Automatically incrementing.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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
    private String roles;


    public User() {}

    public User(String userName, String password, String roles){
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRoles()
    {
        return roles;
    }

    public void setRoles(String roles)
    {
        this.roles = roles;
    }

    /**
     * Encodes the password.
     * To be used after the password has been updated to a non-encoded string.
     */
    public void encodePassword(){
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        password = encoder.encode(password);
    }
}
