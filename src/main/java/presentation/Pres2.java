package presentation;

import dao.IDao;
import metier.IMetier;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Pres2 {
    // FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
    public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("config.txt"));

        String daoClassName = scanner.nextLine();
        Class Cdao = Class.forName(daoClassName);
        IDao dao = (IDao) Cdao.newInstance();
        System.out.println(dao.getData());

        String metierClassName = scanner.nextLine();
        Class Cmetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) Cmetier.getConstructor(IDao.class).newInstance(dao);
        System.out.println("Le resultat est :"+metier.calcul());
    }
}
