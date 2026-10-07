package presentation;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresSpringAnnota {
    public static void main(String[] args) {
        ApplicationContext appContext =
                new AnnotationConfigApplicationContext("dao", "metier");
        IMetier metier = appContext.getBean(IMetier.class);
        System.out.println("Le resultat avec spring Annotation est :"+metier.calcul());


    }
}
