package org.choongang.template.score;

import org.choongang.score.entities.Rank;
import org.choongang.template.Template;

import java.util.List;

public class RankTpl implements Template {

    private List<Rank> ranks;

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);


        if (ranks == null || ranks.isEmpty()) {
           sb.append("등록된 순위가 없습니다.");
        } else {
            for (Rank rank : ranks) {
                String str = String.format("%d. :  %d점 : %s%n", rank.getRANK(), rank.getMAX_SCORE(), rank.getUSER_ID());
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public void setData(List<Rank> data) {
        ranks = data;
    }
}
