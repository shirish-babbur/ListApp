package org.webonise.listapp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapView implements DataCollection{

    public void fetchAndViewData() throws Exception{
        Statement statement=null;
        ResultSet resultset=null;
        DisplayCollection displayCollection =new DisplayCollection();
        Map<Integer,Users> usersMap=new HashMap<Integer,Users>();
        Map<Integer,Users> sortedUserMap=new TreeMap<Integer, Users>();
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
            usersMap.put(user.getId(),user);
        }
        System.out.println("Size of List:"+usersMap.size());
        System.out.println("Before Sorting:");
        displayCollection.Display(usersMap);
        sortedUserMap.putAll(usersMap);
        System.out.println("After Sorting:");
        displayCollection.Display(sortedUserMap);
        connection.close();
    }
}
