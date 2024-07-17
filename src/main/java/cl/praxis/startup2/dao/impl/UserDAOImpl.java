package cl.praxis.startup2.dao.impl;

import cl.praxis.startup2.connection.MySqlConnection;
import cl.praxis.startup2.dao.UserDAO;
import cl.praxis.startup2.model.UserDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static final String GET_USER_BY_EMAIL = "SELECT email, password, nombre, nick FROM usuarios WHERE email = ?";
    private static final String INSERT_USER = "INSERT INTO usuarios (email, nick, nombre, password, peso) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_USER = "UPDATE usuarios SET email = ?, nick = ?, nombre = ?, password = ?, peso = ? WHERE idUser = ?";

    private static final String SELECT_ALL_USERS = "SELECT * FROM usuarios";
    public UserDTO getByEmail(String email) {
        UserDTO user = null;

        try(Connection connection = MySqlConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_USER_BY_EMAIL)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                String nick = rs.getString(2);
                String name = rs.getString(3);
                String password = rs.getString(4);
                user = new UserDTO(email, nick, name, password);
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(user);
        return user;
    }
    public UserDTO insertNewUser(UserDTO user) {
        UserDTO newUser = null;

        try(Connection connection = MySqlConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getNick());
            ps.setString(3, user.getName());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getWeight());

            ps.executeLargeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()) {
                int id = rs.getInt(1);
                Date created_at= user.getCreated_at();
                Date updated_at = user.getUpdated_at();

                newUser = new UserDTO(id, user.getEmail(),  created_at, user.getNick(),user.getName(), user.getPassword(), user.getWeight(), updated_at);
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }

        return newUser;
    }
    public UserDTO updateUser(UserDTO user) {
        return user;
    }

    public List<UserDTO> selectAllUsers() {
        List<UserDTO> users = new ArrayList<>();

        try(Connection connection = MySqlConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("idUser");
                String email = rs.getString("email");
                Date created = rs.getDate("created_at");
                String nick = rs.getString("nick");
                String name = rs.getString("nombre");
                String password = rs.getString("password");
                int weight = rs.getInt("peso");
                Date updated = rs.getDate("update_at");

                users.add(new UserDTO(id, email, created, nick, name, password, weight, updated));
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return users;

    }
}

