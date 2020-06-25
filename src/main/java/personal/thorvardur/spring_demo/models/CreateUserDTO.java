package personal.thorvardur.spring_demo.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Create user DTO")
public class CreateUserDTO extends EditUserDTO {

    /**
     * User's password.
     */
    @ApiModelProperty(notes = "User's password.")
    private String password;


    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * Transforms it's properties to a User entity.
     * @return User entity.
     */
    public User toUserEntity(){
        User user = new User(super.getUserName(), password, super.getRoles());
        user.encodePassword();
        return user;
    }
}
