package org.webonise.listapp;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetView implements DataCollection {
    public void fetchAndViewData() throws Exception {
        ResultSet resultset = null;
        FetchData fetchData = new FetchData();
        Set<Users> usersHashSet = new HashSet<Users>();
        Set<Users> userTreeSet = new TreeSet<Users>(new UserComparator());
        DisplayCollection displayCollection = new DisplayCollection();
        resultset = fetchData.getResultSet();
        while ( resultset.next() ) {
            usersHashSet.add(fetchData.getData(resultset));
        }
        System.out.println("Size of List:"+usersHashSet.size());
        System.out.println("Before Sorting:");
        displayCollection.Display(usersHashSet);
        userTreeSet.addAll(usersHashSet);
        System.out.println("After Sorting:");
        displayCollection.Display(userTreeSet);
        resultset.close();
        fetchData.closeConnection();
    }
}
