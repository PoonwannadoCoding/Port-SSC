package io.muic.ooc.webapp.service;

import io.muic.ooc.webapp.model.User;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {


    private static final String INSERT_USER_SQL = "INSERT INTO tbl_user (username, password, display_name) VALUES (?,?,?);";
    private static final String SELECT_USER_SQL = "SELECT * FROM tbl_user WHERE username = ?;";
    private static final String SELECT_ALL_USER_SQL = "SELECT * FROM tbl_user; ";
    private static final String DELETE_USER_SQL = "DELETE FROM tbl_user WHERE username = ?;";
    private static final String UPDATE_USER_SQL = "UPDATE tbl_user SET display_name = ? WHERE username = ?;";
    private static final String UPDATE_USER_PASSWORD_SQL = "UPDATE tbl_user SET password = ? WHERE username = ?;";



    private DatabaseConnectionService databaseConnectionService;

    private static UserService service;

    private UserService(){
    }

    public static UserService getInstance() {
        if(service == null){
            service = new UserService();
            service.setDatabaseConnectionService(DatabaseConnectionService.getInstance());
        }
        return service;
    }
    public void setDatabaseConnectionService(DatabaseConnectionService databaseConnectionService) {
        this.databaseConnectionService = databaseConnectionService;
    }


    public void createUser(String username, String password, String displayName) throws UserServiceException {
        try (Connection connection = databaseConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_USER_SQL);
        ){
            // setting username column 1
            ps.setString(1, username);
            // setting password column 1
            ps.setString(2, BCrypt.hashpw(password, BCrypt.gensalt()));
            // setting display name column 1
            ps.setString(3, displayName);
            ps.executeUpdate();

            connection.commit();
        } catch (SQLIntegrityConstraintViolationException e){
            throw new UsernameNotUniqueException(String.format("Username %s has already been taken.", username));

        } catch (SQLException throwables){
            throw new UserServiceException(throwables.getMessage());
        }
    }

    public User findByUsername(String username){
        try (
            Connection connection = databaseConnectionService.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_USER_SQL);

        ){
            // setting username column 1
            ps.setString(1, username);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            return new User(
                    resultSet.getLong("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("display_name")
            );

        }  catch (SQLException throwables){
            return null;
        }
    }

    /**
     * list all users in the database
     * @return list of users
     */
    public List<User> findAll(){
        List<User> users = new ArrayList<>();
        try(
                Connection connection = databaseConnectionService.getConnection();
                PreparedStatement ps = connection.prepareStatement(SELECT_ALL_USER_SQL);
        ){
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                users.add(
                        new User(
                                resultSet.getLong("id"),
                                resultSet.getString("username"),
                                resultSet.getString("password"),
                                resultSet.getString("display_name")));
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return users;
    }

    public boolean deleteUserByUsername(String username){
        try (
                Connection connection = databaseConnectionService.getConnection();
                PreparedStatement ps = connection.prepareStatement(DELETE_USER_SQL);

        ){
            // setting username column 1
            ps.setString(1, username);
            int deleteCount = ps.executeUpdate();
            connection.commit();
            return deleteCount> 0;

        }  catch (SQLException throwables){
            return false;
        }
    }



    // delete user
    public boolean deleteUserById(Long id){
        throw new UnsupportedOperationException("not yet implemented");

    }

    // update user by user id

    /**
     *
     * @param username
     * @param displayName
     */
    public void updateUserByUsername(String username, String displayName) throws UserServiceException{
        try (Connection connection = databaseConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_USER_SQL);
        ){

            // setting display name column 1
            ps.setString(1, displayName);
            // setting username column 1
            ps.setString(2, username);


            ps.executeUpdate();

            connection.commit();
        } catch (SQLException throwables){
            throw new UserServiceException(throwables.getMessage());
        }

    }

    public void changePassword(String username, String newPassword) throws UserServiceException{
        try (Connection connection = databaseConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_USER_PASSWORD_SQL);
        ){

            // setting display name column 1
            ps.setString(1, BCrypt.hashpw(newPassword, BCrypt.gensalt()));
            // setting username column 1
            ps.setString(2, username);


            ps.executeUpdate();

            connection.commit();
        } catch (SQLException throwables){
            throw new UserServiceException(throwables.getMessage());
        }

    }






    // create new user







    public static void main(String[] args) throws UserServiceException {
        UserService userService = UserService.getInstance();
        userService.createUser("admin","123456","Admin");
/*
        List<User> users = userService.findAll();
        for (User user: users) {
            System.out.println(user.getUsername());
        }

 */


    }


}
