package personal.thorvardur.spring_demo.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Edit user DTO")
public class EditUserDTO {

    /**
     * Username of the user.
     */
    @ApiModelProperty(notes = "Username of the user.")
    private String userName;

    /**
     * The authorities that the user has.
     */
    @ApiModelProperty(notes = "The authorities that the user has.")
    private String roles;


    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getRoles()
    {
        return roles;
    }

    public void setRoles(String roles)
    {
        this.roles = roles;
    }
}
