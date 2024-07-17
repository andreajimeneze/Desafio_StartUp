package cl.praxis.startup2.controllers;

import cl.praxis.startup2.model.AddressDTO;
import cl.praxis.startup2.services.AddressService;
import cl.praxis.startup2.services.impl.AddressServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/address")
public class AddressServlet extends HttpServlet {
    private AddressService objAddressService;

    public void init() {
        objAddressService = new AddressServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException{

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException {

    }
    
}
