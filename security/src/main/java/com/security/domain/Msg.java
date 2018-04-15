package com.security.domain;

/**
 * @classDesc: 自定义信息返回类
 * @author: Vipin Zheng
 * @createDate: 2018-04-15 21:44:46
 * @version: v1.0
 */
public class Msg {
    private String title;
    private String content;
    private String extraInfo;

    public Msg() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public Msg(String title, String content, String extraInfo) {
        this.title = title;
        this.content = content;
        this.extraInfo = extraInfo;
    }
}
