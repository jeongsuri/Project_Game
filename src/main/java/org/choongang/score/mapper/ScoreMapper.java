package org.choongang.score.mapper;

import org.choongang.score.entities.Rank;
import org.choongang.score.entities.Score;

import java.util.List;

public interface ScoreMapper {
    int plusScore(Score score);

    List<Rank> getScore1();

    List<Score> getScore2();

    Integer getScoreOne(String USER_ID);

}
