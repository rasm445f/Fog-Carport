package dat.startcode.model.persistence;

import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

public interface IUserMapper
{
    public User login(String email, String password) throws DatabaseException;
    public User createUser(String email, String password, String name,String address, String city, int zipcode, int phoneNumber) throws DatabaseException;

}
