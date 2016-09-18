package org.webonise.listapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListView implements DataCollection{
    public void fetchAndViewData() throws Exception {
        Statement statement=null;
        ResultSet resultset=null;
        List<Users> userList=new ArrayList<Users>();
        DisplayCollection displayCollection =new DisplayCollection();
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
        System.out.println("Size of List:"+userList.size());
        System.out.println("Before Sorting");
        displayCollection.Display(userList);
        Collections.sort(userList,new UserComparator());
        System.out.println("After Sorting");
        displayCollection.Display(userList);
        connection.close();
    }
}
