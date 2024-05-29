package org.choongang.template.score;

import org.choongang.score.entities.Rank;
import org.choongang.score.entities.Score;
import org.choongang.template.Template;

import java.util.List;

public class RankTpl implements Template {

    private List<Score> scores;

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);


        if (scores == null || scores.isEmpty()) {
           sb.append("등록된 순위가 없습니다.");
        } else {
            for (int i = 0; i < scores.size(); i++) {
                Score score = scores.get(i);
                String str = String.format("%d. :  %d점 : %s%n",  i + 1, score.getSCORE(), score.getUSER_ID());
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public void setData(List<Score> data) {
        System.out.println(data);
        scores = data;
    }
}
