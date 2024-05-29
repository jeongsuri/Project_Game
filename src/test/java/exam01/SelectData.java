package exam01;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.choongang.global.configs.DBConn;
import org.choongang.score.entities.Rank;
import org.choongang.score.entities.Score;
import org.choongang.score.mapper.ScoreMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SelectData {
    @Test
    void test1() { // 전체랭킹 조회
        SqlSession session = DBConn.getSession();
        ScoreMapper mapper = session.getMapper(ScoreMapper.class);
        List<Rank> ranks = mapper.getScore1();
        ranks.forEach(System.out::println);
    }

    @Test
    void test2() { // 전체 랭킹 조회
        SqlSession session = DBConn.getSession();
        List<Score> rank = session.selectList("org.choongang.score.mapper.ScoreMapper.getScore2");
        rank.forEach(System.out::println);
    }

    @Test
    void test3() { // 유저아이디 입력 시 개인랭킹 조회
        SqlSession session = DBConn.getSession();
        ScoreMapper mapper = session.getMapper(ScoreMapper.class);
        int score = mapper.getScoreOne("user01");
        System.out.println("순위: " + score);
    }
}
