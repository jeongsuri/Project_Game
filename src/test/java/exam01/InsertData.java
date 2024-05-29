package exam01;

import org.apache.ibatis.session.SqlSession;
import org.choongang.member.entities.Member;
import org.choongang.global.configs.DBConn;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.score.entities.Score;
import org.choongang.score.mapper.ScoreMapper;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class InsertData {

    private SqlSession session = DBConn.getSession();

    @Test
    void test1() {
        MemberMapper mapper = session.getMapper(MemberMapper.class);
        Member member = Member.builder()
                .userId("user02")
                .userPw("12345678")
                .userNm("사용자02")
                .build();
        int plus1 = mapper.plusMember(member);
        System.out.println(plus1);
    }

    @Test
    void test2() {
        ScoreMapper mapper = session.getMapper(ScoreMapper.class);

        for (int i = 0; i < 10; i++) {
            int score = (int)(Math.random() * 10) + 1;
            Score param = Score.builder()
                            .SCORE(score)
                            .USER_ID("user02")
                            .build();
            mapper.plusScore(param);
        }
    }
}
