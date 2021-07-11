package com.github.sithumonline.springone.repository;

import com.github.sithumonline.springone.repository.custom.impl.*;

public class RepositoryFactory {

    public enum RepositoryFactoryTypes{
        USER
    }

    private RepositoryFactory() {
    }

    private static RepositoryFactory repositoryFactory;

    public static RepositoryFactory getInstance(){
        if (repositoryFactory == null)
            repositoryFactory = new RepositoryFactory();
        return repositoryFactory;
    }

    public SuperRepository getRepository(RepositoryFactoryTypes repositoryFactoryTypes){
        switch (repositoryFactoryTypes){
            case USER: return new UserRepositoryImpl();
            default: return null;
        }
    }
}
