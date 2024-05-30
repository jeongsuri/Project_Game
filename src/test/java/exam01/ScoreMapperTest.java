package exam01;

import org.choongang.global.configs.DBConn;
import org.choongang.score.mapper.ScoreMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScoreMapperTest {

    private ScoreMapper mapper;

    @BeforeEach
    void init() {
        mapper = DBConn.getSession().getMapper(ScoreMapper.class);
    }

    @Test
    void mapperTest1() {
        int score = mapper.getScoreOne("user01");
        System.out.println(score);
    }
}
