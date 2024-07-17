package cl.praxis.startup2.services;

import cl.praxis.startup2.model.AddressDTO;

public interface AddressService {
    public AddressDTO insertAddress(AddressDTO address);
    public AddressDTO updateAddress(AddressDTO address);
}
