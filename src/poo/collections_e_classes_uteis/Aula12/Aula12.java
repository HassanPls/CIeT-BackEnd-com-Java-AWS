package poo.collections_e_classes_uteis.Aula12;

import poo.collections_e_classes_uteis.Aula12.dao.GenericDAO;
import poo.collections_e_classes_uteis.Aula12.dao.UserDAO;
import poo.collections_e_classes_uteis.Aula12.domain.UserDomain;

public class Aula12 {
    private static final GenericDAO<Integer, UserDomain> dao = new UserDAO();
    public static void main(String[] args) {
        UserDomain user1 = new UserDomain(1, "Pedro", 26);
        UserDomain user2 = new UserDomain(2, "Paulo", 27);
        System.out.println(dao.count());
        System.out.println(dao.save(user1, user2));
        System.out.println(dao.findAll());
        System.out.println(dao.find(d -> d.getId().equals(1)));
        System.out.println(dao.find(d -> d.getId().equals(2)));
        System.out.println(dao.count());
        System.out.println(dao.delete(new UserDomain(-1, "", -1)));
        System.out.println(dao.delete(user1));
        System.out.println(dao.findAll());
        System.out.println(dao.count());
    }
}
