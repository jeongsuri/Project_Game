package org.choongang.game.services;

import org.apache.ibatis.session.SqlSession;
import org.choongang.game.entities.GameScore;

import org.choongang.game.mapper.GameMapper;
import org.choongang.global.Service;
import org.choongang.global.configs.DBConn;
import org.choongang.member.entities.Member;

public class SaveScoreService implements Service<GameScore> { // 점수 저장
    @Override
    public void process(GameScore form) {
        SqlSession session = DBConn.getSession();
        String inputId = form.getUserId();

        GameMapper mapper = session.getMapper(GameMapper.class);

        GameScore score = GameScore.builder() // userId + score
                .userId(form.getUserId())
                .score(form.getScore())
                .build();
        int cnt = mapper.insertScore(score);
    }
}
