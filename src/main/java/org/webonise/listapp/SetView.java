package org.webonise.listapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetView implements DataCollection{
    public void fetchAndViewData() throws Exception {
        Statement statement=null;
        ResultSet resultset=null;
        Set<Users> usersHashSet=new HashSet<Users>();
        Set<Users> userTreeSet=new TreeSet<Users>(new UserComparator());
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
            usersHashSet.add(user);
        }
        System.out.println("Size of List:"+usersHashSet.size());
        System.out.println("Before Sorting:");
        displayCollection.Display(usersHashSet);
        userTreeSet.addAll(usersHashSet);
        System.out.println("After Sorting:");
        displayCollection.Display(userTreeSet);
        connection.close();
    }
}
