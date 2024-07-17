package cl.praxis.startup2.controllers;

import cl.praxis.startup2.model.AddressDTO;
import cl.praxis.startup2.model.UserDTO;
import cl.praxis.startup2.services.UserService;
import cl.praxis.startup2.services.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private UserService objUserService;

    public void init() { objUserService = new UserServiceImpl(); }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");

        if(action == null) {
            action = "view";
        }

            switch (action) {
                case "insert":
                    insertUser(req, res);
                    break;
                case "compare":
                    validateUser(req, res);
                    break;
                case "register":
                    showNewForm(req, res);
                    break;
                case "login":
                    showLoginForm(req, res);
                    break;
                default:
                    showIndex(req, res);
                    break;
            }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        doGet(req, res);
    }

    private void showIndex(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, res);
    }

    private void showLoginForm(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, res);
    }
    public void insertUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
        UserDTO user = new UserDTO();
        AddressDTO address = new AddressDTO();

        // Parámetros User
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String nick = req.getParameter("nick");
        String password = req.getParameter("password");
        int weight = Integer.parseInt(req.getParameter("weight"));

        // Parámetros Address
        String addressName = req.getParameter("addressName");
        String number = req.getParameter("number");

        // Seteo del usuario con parámetros
        user.setEmail(email);
        user.setName(name);
        user.setNick(nick);
        user.setPassword(password);
        user.setWeight(weight);

        // Seteo de direcciones con parámetros
        address.setName(addressName);
        address.setNumber(number);

        objUserService.insertNewUser(user, address);
        res.sendRedirect("login.jsp");
    }

     private void validateUser(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        //Parámetros User
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDTO user = objUserService.validateUser(email, password);

        if(user != null) {
            req.setAttribute("user", user);
            req.getRequestDispatcher("home.jsp").forward(req, res);

        } else {
            res.sendRedirect("login.jsp");
        }
    }
}
