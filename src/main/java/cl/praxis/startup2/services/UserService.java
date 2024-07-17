package cl.praxis.startup2.services;

import cl.praxis.startup2.model.AddressDTO;
import cl.praxis.startup2.model.UserDTO;

import java.util.List;

public interface UserService {
    public UserDTO validateUser(String email, String password);
    public void insertNewUser(UserDTO user, AddressDTO address);

    public int getIdInsertedUser(UserDTO user);
}
