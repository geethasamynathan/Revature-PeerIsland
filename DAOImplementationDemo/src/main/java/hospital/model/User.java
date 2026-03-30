package hospital.model;

public class User {
    private int userId;
    private String username;
    private String password;
    private String roleName;

    public User(int userId, String username, String password, String roleName) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.roleName = roleName;
    }
    public User(String username,String password) {
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;

    }
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
