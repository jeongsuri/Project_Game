package org.choongang.score.services;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.AbstractController;
import org.choongang.global.configs.DBConn;
import org.choongang.global.constants.Menu;
import org.choongang.score.entities.Score;
import org.choongang.score.mapper.ScoreMapper;
import org.choongang.template.Templates;

import java.util.List;
import java.util.Scanner;

public class RankService extends AbstractController {
    @Override
    public void show() {
        ScoreMapper mapper = DBConn.getSession().getMapper(ScoreMapper.class);

        Templates.getInstance().render(Menu.RANK, mapper.getScore2());

    }
}