package hospital.service;

import hospital.dao.UserDAO;
import hospital.dao.UserDAOImpl;

public class UserService {

    private final UserDAO userDAO=new UserDAOImpl();

    public boolean loginUnsafe(String username,String password)
    {
        if(username==null || username.trim().isEmpty()){

            System.out.println("Username cannot be Epty");
            return false;
        }
        if(password==null || password.trim().isEmpty()){
            System.out.println("Password cannot be Epty");
            return false;
        }
        return userDAO.loginUnsafe(username,password);
    }

    public boolean loginSafe(String username,String password)
    {
        if(username==null || username.trim().isEmpty()){

            System.out.println("Username cannot be Epty");
            return false;
        }
        if(password==null || password.trim().isEmpty()){
            System.out.println("Password cannot be Epty");
            return false;
        }
        return userDAO.loginSafe(username,password);
    }

}
