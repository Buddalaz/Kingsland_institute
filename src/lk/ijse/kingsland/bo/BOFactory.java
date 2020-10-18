package lk.ijse.kingsland.bo;

import lk.ijse.kingsland.bo.custom.impl.CourseBOImpl;
import lk.ijse.kingsland.bo.custom.impl.RegistrationBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance(){
        if (boFactory==null){
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public enum BOTypes {
        COURSE, REGISTRATION;
    }

    public SuperBO getBO(BOTypes types) {
        switch (types) {
            case COURSE:
                return new CourseBOImpl();
            case REGISTRATION:
                return new RegistrationBOImpl();
            default:
                return null;

        }

    }
}
