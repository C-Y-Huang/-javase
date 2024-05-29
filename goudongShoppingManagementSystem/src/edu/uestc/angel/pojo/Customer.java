package edu.uestc.angel.pojo;


public class Customer {
    private Integer vipId;
    private String vipCard;
    private String birthday;
    private Float integral;

    @Override
    public String toString() {
        return "Customer{" +
                "vipId=" + vipId +
                ", vipCard='" + vipCard + '\'' +
                ", birthday='" + birthday + '\'' +
                ", integral=" + integral +
                '}';
    }

    public Integer getVipId() {
        return vipId;
    }

    public void setVipId(Integer vipId) {
        this.vipId = vipId;
    }

    public String getVipCard() {
        return vipCard;
    }

    public void setVipCard(String vipCard) {
        this.vipCard = vipCard;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Float getIntegral() {
        return integral;
    }

    public void setIntegral(Float integral) {
        this.integral = integral;
    }
}
