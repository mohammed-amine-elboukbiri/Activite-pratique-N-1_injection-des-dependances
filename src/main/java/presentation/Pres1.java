package presentation;
import dao.IDao;
import dao.DaoImp;
import metier.MetierImp;

public class Pres1 {
    public static void main(String[] args) {
        IDao dao = new DaoImp();

        //injection statique par constructuer

        MetierImp metier = new MetierImp(dao);


        /* injection statique par setter
        MetierImp metier = new MetierImp();
        metier.setDao(dao);
        */

        System.out.println("Le resultat est : " + metier.calcul());

    }
}
