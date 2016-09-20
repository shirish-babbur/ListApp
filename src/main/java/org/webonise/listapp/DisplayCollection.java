package org.webonise.listapp;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DisplayCollection {
    public void Display(Map userMap) {
        if(!userMap.isEmpty()) {
            Iterator iterator = userMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry)iterator.next();
                System.out.print("Key:"+entry.getKey()+"\t Value:");
                Users user = (Users) entry.getValue();
                user.showDetails();
            }
        } else {
            System.out.println("Map is Empty!");
        }
    }
    public void Display(List userList) {
        if(!userList.isEmpty()) {
            Iterator<Users> iterator = userList.iterator();
            while (iterator.hasNext()) {
                Users user = iterator.next();
                user.showDetails();
            }
        } else {
            System.out.println("List is Empty!");
        }
    }
    public void Display(Set userSet) {
        if(!userSet.isEmpty()) {
            Iterator<Users> iterator = userSet.iterator();
            while (iterator.hasNext()) {
                Users user = iterator.next();
                user.showDetails();
            }
        } else {
            System.out.println("Set is Empty!");
        }
    }
}
