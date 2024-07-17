package cl.praxis.startup2.dao;

import cl.praxis.startup2.model.AddressDTO;

public interface AddressDAO {
    public AddressDTO insertAddress(AddressDTO address);
    public AddressDTO updateAddress(AddressDTO address);
}