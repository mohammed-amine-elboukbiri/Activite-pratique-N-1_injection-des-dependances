package dao;

import org.springframework.stereotype.Component;

@Component("dao")
public class DaoImp implements IDao {

    @Override
    public double getData() {
        System.out.println("Version Data Base");
        double t = 10;
        return t;
    }
}
