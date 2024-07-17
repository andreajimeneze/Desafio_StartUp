package cl.praxis.startup2.services.impl;

import cl.praxis.startup2.dao.AddressDAO;
import cl.praxis.startup2.dao.UserDAO;
import cl.praxis.startup2.dao.impl.AddressDAOImpl;
import cl.praxis.startup2.dao.impl.UserDAOImpl;
import cl.praxis.startup2.model.AddressDTO;
import cl.praxis.startup2.model.UserDTO;
import cl.praxis.startup2.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDAO objUserDAO;
    private final AddressDAO objAddressDAO;


    public UserServiceImpl() {

        this.objUserDAO = new UserDAOImpl();
        this.objAddressDAO = new AddressDAOImpl();
    }

    public UserDTO validateUser(String email, String password) {
        UserDTO user = objUserDAO.getByEmail(email);
        try {
            if (user !=null && user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("User found with email: " + email);
                return user;
            } else {
                System.out.println("User NOT found: ");
                return null;
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void insertNewUser(UserDTO user, AddressDTO address) {
        int idUser = getIdInsertedUser(user);
        address.setUser_id(idUser);
        objAddressDAO.insertAddress(address);
    }

    public int getIdInsertedUser(UserDTO user) {
        UserDTO insertedUser = objUserDAO.insertNewUser(user);

       return insertedUser.getId();
    }
    public UserDTO updateUser(UserDTO user) {
        return objUserDAO.updateUser(user);
    }

    public List<UserDTO> selectAllUsers() {
        return objUserDAO.selectAllUsers();
    }
}
