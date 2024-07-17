package cl.praxis.startup2.dao.impl;

import cl.praxis.startup2.connection.MySqlConnection;
import cl.praxis.startup2.dao.AddressDAO;
import cl.praxis.startup2.model.AddressDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AddressDAOImpl implements AddressDAO {

    private final String INSERT_ADDRESS = "INSERT INTO direcciones (calle, numeracion, usuario_id) VALUES (?,?, ?)";
    private final String UPDATE_ADDRESS = "UPDATE direcciones SET calle = ?, numeracion = ? WHERE usuario_id = ?";
    public AddressDTO insertAddress(AddressDTO address) {
        AddressDTO newAddress = null;

        try (Connection connection = MySqlConnection.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_ADDRESS, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, address.getName());
            ps.setString(2, address.getNumber());
            ps.setNull(3, java.sql.Types.INTEGER);

            if (address.getUser_id() == 0) {
                ps.setNull(3, java.sql.Types.INTEGER);
                } else {
                ps.setInt(3, address.getUser_id());
            }

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()) {
            int id = rs.getInt(1);

            newAddress =new AddressDTO(id, address.getName(), address.getNumber());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newAddress;
    }

    public AddressDTO updateAddress(AddressDTO address) {
        return address;
    }
}

