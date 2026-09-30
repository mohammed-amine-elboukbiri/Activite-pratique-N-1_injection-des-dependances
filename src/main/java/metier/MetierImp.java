package metier;
import dao.IDao;

public class MetierImp implements IMetier {

    private IDao dao;

    @Override
    public double calcul() {
        double d = dao.getData();
        double res = Math.cos(d*2)+Math.sin(d*4);
        return res;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
