package cl.praxis.startup2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String email;
    private Date created_at;
    private String nick;
    private String name;
    private String password;
    private int weight;
    private Date updated_at;
    private AddressDTO address;
    private UserRoleDTO role;

    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserDTO(int id, String email, Date created_at, String nick, String name, String password, int weight, Date updated_at) {
        this.id = id;
        this.email = email;
        this.created_at = created_at;
        this.nick = nick;
        this.name = name;
        this.password = password;
        this.weight = weight;
        this.updated_at = updated_at;
    }

    public UserDTO(String email, String password, String name, String nick) {
        this.email = email;
        this.nick = nick;
        this.name = name;
        this.password = password;
    }
}