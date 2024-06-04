package org.choongang.game.services;

import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.constants.Menu;

public class GameServiceLocator extends AbstractServiceLocator {

    public static ServiceLocator getInstance(){
        if(instance == null){
            instance = new GameServiceLocator();
        }
        return instance;
    }

    @Override
    public Service find(Menu menu) {
        Service service = services.get(menu);
        if(service !=  null){
            return service;
        }
        switch (menu){
            case GAME: service = new GameService(); break; // GAME -> GameService
            case SAVE: service = new SaveScoreService(); break; // SAVE -> SaveScoreService
            default: service = new GameService(); break;
        }
        return service;
    }
}
