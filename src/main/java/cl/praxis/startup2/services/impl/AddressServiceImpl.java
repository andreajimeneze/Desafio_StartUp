package cl.praxis.startup2.services.impl;

import cl.praxis.startup2.dao.AddressDAO;
import cl.praxis.startup2.dao.impl.AddressDAOImpl;
import cl.praxis.startup2.model.AddressDTO;
import cl.praxis.startup2.services.AddressService;

public class AddressServiceImpl implements AddressService {

    private final AddressDAO objAddressDAO;

    public AddressServiceImpl() {
        this.objAddressDAO  = new AddressDAOImpl();
    }
    public AddressDTO insertAddress(AddressDTO address) { return objAddressDAO.insertAddress(address); }
    public AddressDTO updateAddress(AddressDTO address) {
        return objAddressDAO.updateAddress(address);
    }
}
