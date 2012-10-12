package ZombieApocalypse;

import java.security.PrivateKey;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        ArrayList<Person> listOne = new ArrayList<Person>();

        Person p1 = new Person("test",10,10,10,10,10,false,10);
        listOne.add(p1) ;
        listOne.add(p1) ;
        listOne.add(p1) ;
        listOne.add(p1) ;
        System.out.print(listOne.size());
        Encounter.encounter(listOne,listOne);
        System.out.print(listOne.size());
        
        //testing new push
    }
}