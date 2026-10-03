package ext;

import dao.IDao;

public class DaoImpV2 implements IDao {
    @Override
    public double getData() {
        System.out.println("Vestion concepteur");
        double t = 8;
        return t;
    }
}
