package org.choongang.template.game;
import org.choongang.template.Template;
import org.choongang.template.Templates;

public class GameTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("묵찌빠 게임 시작\n");
        sb.append("1.가위 2.바위 3.보\n");
        sb.append(Templates.getInstance().line());
        return sb.toString();
    }
}