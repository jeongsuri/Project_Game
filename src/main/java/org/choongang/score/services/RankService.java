package org.choongang.score.services;


import org.choongang.global.AbstractController;
import org.choongang.global.Service;
import org.choongang.global.configs.DBConn;
import org.choongang.global.constants.Menu;
import org.choongang.score.entities.Score;
import org.choongang.score.mapper.ScoreMapper;
import org.choongang.template.Templates;

import java.util.List;

public class RankService implements Service<List<Score>> {
    @Override
    public List<Score> process() {
        ScoreMapper mapper = DBConn.getSession().getMapper(ScoreMapper.class);
        return mapper.getScore2();
    }
    /*
    @Override
    public void show() {


    } */
}