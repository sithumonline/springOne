package com.github.sithumonline.springone.business;

import com.github.sithumonline.springone.business.custom.impl.*;

public class BOFactory {

    public enum BOTypes{
        USER
    }

    private BOFactory() {
    }

    private static BOFactory boFactory;

    public static BOFactory getInstance(){
        if (boFactory == null)
            boFactory = new BOFactory();
        return boFactory;
    }

    public SuperBO getBOFactory(BOTypes boTypes){
        switch (boTypes){
            case USER: return new UserBOImpl();
            default:return null;
        }
    }
}
