package ext;

import dao.IDao;
import org.springframework.stereotype.Component;

@Component("dao2")
public class DaoImpV2 implements IDao {
    @Override
    public double getData() {
        System.out.println("Vestion concepteur");
        double t = 8;
        return t;
    }
}
