package metier;
import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("metier")//crée un objet géré par Spring
public class MetierImp implements IMetier {

    @Autowired //@Autowired injecte une implémentation de IDao (DaoImpl) dans MetierImpl
    private IDao dao;
    //@Autowired n'injecte pas l'interface IDao elle-même (une interface ne peut pas être instanciée). Il injecte un objet d'une classe qui implémente IDao, ici DaoImpl.

    @Override
    public double calcul() {
        double d = dao.getData();
        double res = Math.cos(d*2)+Math.sin(d*4);
        return res;
    }

    public MetierImp() {
   }

    //injection statique par constructuer
    public MetierImp(IDao dao) {
        this.dao = dao;
    }


    // injection statique par setter
    public void setDao(IDao dao) {
        this.dao = dao;
    }


}
