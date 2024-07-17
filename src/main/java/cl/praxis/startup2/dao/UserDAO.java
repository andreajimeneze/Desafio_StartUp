package cl.praxis.startup2.dao;

import cl.praxis.startup2.model.AddressDTO;
import cl.praxis.startup2.model.UserDTO;

import java.util.List;

public interface UserDAO {

    public List<UserDTO> selectAllUsers();
    public UserDTO getByEmail(String email);
    public UserDTO insertNewUser(UserDTO user);
    public UserDTO updateUser(UserDTO user);
}