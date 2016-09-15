package org.webonise.listapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/**
 * Created by webonise on 15/9/16.
 */
public class ListApp {

    public static void main(String[] args) throws Exception{
        Statement statement=null;
        ResultSet resultset=null;
        List <Users> userList=new ArrayList<Users>();
        Connection connection=DbConnection.getConnection();
        statement = connection.createStatement();
        resultset = statement.executeQuery( "SELECT * FROM Users;" );
        while ( resultset.next() ) {
            Users user=new Users();
            user.setId(resultset.getInt("id"));
            user.setFirstName(resultset.getString("firstname"));
            user.setAge(resultset.getInt("age"));
            user.setLastName(resultset.getString("lastname"));
            user.setEmail(resultset.getString("email"));
            user.setSalary(resultset.getInt("salary"));
            userList.add(user);
        }
        Collections.sort(userList,new UserComparator());
        Iterator<Users> iterator= userList.iterator();
        while(iterator.hasNext()){
            Users user=(Users)iterator.next();
            user.showDetails();
        }
        connection.close();
    }

}
