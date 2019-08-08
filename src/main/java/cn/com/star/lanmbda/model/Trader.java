package cn.com.star.lanmbda.model;

public class Trader {
    private String traderName;
    private String city;

    public Trader(String traderName, String city) {
        this.traderName = traderName;
        this.city = city;
    }

    public String getTraderName() {
        return traderName;
    }

    public void setTraderName(String traderName) {
        this.traderName = traderName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
