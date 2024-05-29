package org.choongang.template;

public interface Template {
    String getTpl();

    default  void setData(Object data) {

    }
}
