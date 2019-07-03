package com.jnshu.pojo;

public class Lucky {
    private Long id;

    private String luckyName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLuckyName() {
        return luckyName;
    }

    public void setLuckyName(String luckyName) {
        this.luckyName = luckyName;
    }

    @Override
    public String toString() {
        return "Lucky{" +
                "id=" + id +
                ", luckyName='" + luckyName + '\'' +
                '}';
    }
}