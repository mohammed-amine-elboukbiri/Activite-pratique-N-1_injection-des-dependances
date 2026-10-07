package presentation;

import dao.IDao;
import metier.IMetier;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres2 {
    // FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
    public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("config.txt"));

        String daoClassName = scanner.nextLine();//lire la classe
        Class Cdao = Class.forName(daoClassName);//charger la classe dans la memoire
        IDao dao = (IDao) Cdao.newInstance();//instancier la classe
        System.out.println(dao.getData());

        String metierClassName = scanner.nextLine();
        Class Cmetier = Class.forName(metierClassName);
        
        //instantion via le constructeur
        //IMetier metier = (IMetier) Cmetier.getConstructor(IDao.class).newInstance(dao);

        // instantion via le setter
        IMetier metier = (IMetier) Cmetier.getConstructor().newInstance();
        Method SetDao = Cmetier.getDeclaredMethod("setDao", IDao.class);
        SetDao.invoke(metier,dao);

        System.out.println("Le resultat est :"+metier.calcul());
    }
}
