package org.choongang.template.score;

import org.choongang.score.entities.Rank;
import org.choongang.template.Template;

import java.util.List;
import java.util.function.Supplier;

public class RankTpl implements Template {

    private Supplier<String> hook;

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("순위보기\n");
        if (hook != null) {
            sb.append(hook.get());
        }
        return sb.toString();
    }


}
