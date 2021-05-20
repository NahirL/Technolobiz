package guru.springframework.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated user ID")
    private Integer id;
    @Version                                                            //
    @ApiModelProperty(notes = "The auto-generated version of the user") //  ???????
    private Integer version;                                            //
    @ApiModelProperty(notes = "The application-specific user name")
    private String userName;
    @ApiModelProperty(notes = "The user first name")
    private String fname;
    @ApiModelProperty(notes = "The user last name")
    private String lname;
    @ApiModelProperty(notes = "The user avatar")
    private String avatar;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getVersion() { return version; }

    public void setVersion(Integer version) { this.version = version; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getFname() { return fname; }

    public void setFname(String fname) { this.fname = fname; }

    public String getLname() { return lname; }

    public void setLname(String lname) { this.lname = lname; }

    public String getAvatar() { return avatar; }

    public void setAvatar(String avatar) { this.avatar = avatar; }
}
