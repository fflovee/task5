package com.jnshu.pojo;

public class Job {
    private Integer id;

    private String direction;

    private String jobName;

    private String description;

    private String introduction;

    private Byte threshold;

    private Byte difficult;

    private Long growth;

    private Long demand;

    private String payOne;

    private String paySec;

    private String payThr;

    private String image;

    private Long createAt;

    private Long updateAt;

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", direction='" + direction + '\'' +
                ", jobName='" + jobName + '\'' +
                ", description='" + description + '\'' +
                ", introduction='" + introduction + '\'' +
                ", threshold=" + threshold +
                ", difficult=" + difficult +
                ", growth=" + growth +
                ", demand=" + demand +
                ", payOne='" + payOne + '\'' +
                ", paySec='" + paySec + '\'' +
                ", payThr='" + payThr + '\'' +
                ", image='" + image + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Byte getThreshold() {
        return threshold;
    }

    public void setThreshold(Byte threshold) {
        this.threshold = threshold;
    }

    public Byte getDifficult() {
        return difficult;
    }

    public void setDifficult(Byte difficult) {
        this.difficult = difficult;
    }

    public Long getGrowth() {
        return growth;
    }

    public void setGrowth(Long growth) {
        this.growth = growth;
    }

    public Long getDemand() {
        return demand;
    }

    public void setDemand(Long demand) {
        this.demand = demand;
    }

    public String getPayOne() {
        return payOne;
    }

    public void setPayOne(String payOne) {
        this.payOne = payOne;
    }

    public String getPaySec() {
        return paySec;
    }

    public void setPaySec(String paySec) {
        this.paySec = paySec;
    }

    public String getPayThr() {
        return payThr;
    }

    public void setPayThr(String payThr) {
        this.payThr = payThr;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }
}