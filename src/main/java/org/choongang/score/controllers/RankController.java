package org.choongang.score.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.configs.DBConn;
import org.choongang.global.constants.Menu;
import org.choongang.score.entities.Score;
import org.choongang.score.mapper.ScoreMapper;
import org.choongang.template.Templates;

public class RankController extends AbstractController {
    @Override
    public void show() {
        ScoreMapper mapper = DBConn.getSession().getMapper(ScoreMapper.class);

        Templates.getInstance().render(Menu.RANK, mapper.getScore2());

    }
}
