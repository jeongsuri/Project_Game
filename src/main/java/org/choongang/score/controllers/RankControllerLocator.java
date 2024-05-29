package org.choongang.score.controllers;

import org.choongang.global.*;
import org.choongang.global.constants.Menu;

public class RankControllerLocator extends AbstractControllerLocator {

    private static ControllerLocator instance;

    public static ControllerLocator getInstance() {
        if (instance == null) {
            instance = new RankControllerLocator();
        }

        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if (controller != null) {
            return controller;
        }

        switch (menu) {
            case RANK: controller = new RankController();
        }

        controllers.put(menu, controller);

        return controller;
    }
}
