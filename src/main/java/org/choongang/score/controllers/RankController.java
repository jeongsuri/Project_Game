package org.choongang.score.controllers;

import org.choongang.game.entities.GamePlay;
import org.choongang.game.services.GameServiceLocator;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.constants.Menu;
import org.choongang.main.MainRouter;
import org.choongang.template.Templates;

import java.util.ArrayList;

public class RankController extends AbstractController {
    @Override
    public void show() {

    }

    @Override
    public void prompt() {
        Templates.getInstance().render(Menu.RANK);
    }
}
