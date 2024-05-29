package org.choongang.template;

import org.choongang.global.constants.Menu;
import org.choongang.template.game.GameTpl;
import org.choongang.template.main.MainTpl;
import org.choongang.template.member.JoinTpl;
import org.choongang.template.member.LoginTpl;
import org.choongang.template.member.MypageTpl;
import org.choongang.template.score.RankTpl;

import java.util.HashMap;
import java.util.Map;

public class Templates {
    private static Templates instance;
    private Map<Menu, Template> tpls;
    private Templates() {
        tpls = new HashMap<>();
    }
    public static Templates getInstance(){
        if(instance == null){
            instance = new Templates();
        }
        return instance;
    }
    public void render(Menu menu) {
        render(menu, null);
    }

    public <T> void render(Menu menu, T data) {

        System.out.println(find(menu,data).getTpl());
    }


    public <T> Template find(Menu menu, T data){

        Template tpl = tpls.get(menu);
        if(tpl != null){
            return tpl;
        }
        switch (menu){
            case JOIN: tpl = new JoinTpl(); break;
            case LOGIN: tpl = new LoginTpl(); break;
            case MYPAGE: tpl = new MypageTpl(); break;
            case GAME: tpl = new GameTpl(); break;
            case RANK: tpl = new RankTpl(); break;
            default: tpl = new MainTpl();
        }

        if (data != null) {
            tpl.setData(data);
        }

        tpls.put(menu,tpl);
        return tpl;
    }

    public String line(){
        return "------------------------------------------\n";
    }

    public String doubleLine(){
        return "==========================================\n";
    }
}
