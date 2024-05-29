package org.choongang.game.services;

import org.apache.ibatis.session.SqlSession;
import org.choongang.game.entites.GameScore;
import org.choongang.game.mapper.GameMapper;
import org.choongang.global.Service;
import org.choongang.global.configs.DBConn;

public class SaveScoreService implements Service<GameScore> {
    @Override
    public void process(GameScore form) {
        SqlSession session = DBConn.getSession();
        String userId = form.getUserId();

        GameMapper mapper =  session.getMapper(GameMapper.class);

        GameScore game = GameScore.builder()
                .userId(form.getUserId())
                .score(form.getScore())
                .build();
        mapper.insertScore(game);
    }
}
