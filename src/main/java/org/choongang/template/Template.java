package org.choongang.template;

public interface Template {
    String getTpl();

    default <T> void setData(T data) {

    }
}
