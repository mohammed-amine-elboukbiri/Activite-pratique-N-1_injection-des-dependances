package presentation;
import dao.IDao;
import dao.DaoImp;
import metier.MetierImp;
import ext.DaoImpV2;

public class Pres1 {
    public static void main(String[] args) {
        //en utilisant version data
         // IDao dao = new DaoImp();

        //en utilisant version capteur
        IDao dao = new DaoImpV2();

        //injection statique par constructuer

        //MetierImp metier = new MetierImp(dao);


        /* injection statique par setter
        MetierImp metier = new MetierImp();
        metier.setDao(dao);
        */

        //System.out.println("Le resultat est : " + metier.calcul());

    }
}
