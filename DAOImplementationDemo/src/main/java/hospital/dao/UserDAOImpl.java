package hospital.dao;

import hospital.model.User;
import hospital.util.DBConection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAOImpl  implements UserDAO {
    @Override
    public boolean loginUnsafe(String username, String password) {
        String query = "SELECT * FROM users WHERE username='" + username +
                "' AND password='" + password + "'";
       try(Connection conn= DBConection.getConnection();
           Statement st=conn.createStatement();
           ResultSet rs=st.executeQuery(query))
       {
           return  rs.next();
       }catch(Exception e)
       {
           e.printStackTrace();
       }

        return false;
    }

    @Override
    public boolean loginSafe(String username, String password) {
        String query="SELECT * FROM users WHERE username=?  AND password= ?";
        try(Connection conn= DBConection.getConnection();
            PreparedStatement ps=conn.prepareStatement(query);
            )
        {
            ps.setString(1,username);
            ps.setString(2,password);
            try(ResultSet rs =ps.executeQuery()){
                return rs.next();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public User getUserByUsername(String username) {
        String query="SELECT * FROM users WHERE username=?";
        try(Connection conn= DBConection.getConnection();
            PreparedStatement ps=conn.prepareStatement(query);
        )
        {
            ps.setString(1,username);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("user_id"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("role_name")
                    );
                }
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
