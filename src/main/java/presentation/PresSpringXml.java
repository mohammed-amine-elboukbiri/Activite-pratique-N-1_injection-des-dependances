package presentation;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresSpringXml {
    public static void main (String[] args) {
        ApplicationContext springContext = new ClassPathXmlApplicationContext("config.xml");
        //en utilisant id
        //IMetier metier = (IMetier) springContext.getBean("metier");
        //en utilisant le nom de la class
        IMetier metier = springContext.getBean(IMetier.class);
        System.out.println("Le resultat avec spring Xml est :"+metier.calcul());
    }
}
