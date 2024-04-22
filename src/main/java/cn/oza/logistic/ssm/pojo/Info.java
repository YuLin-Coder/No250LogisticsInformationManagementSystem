package cn.oza.logistic.ssm.pojo;

public class Info {
    private Long orderId;

    private Double totalVolume;

    private Double totalWeight;

    private Double totalValue;

    private Double taxRate;

    private Double weightFee;

    private Double volumeFee;

    private Double taxFee;

    private Double totalFee;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(Double totalVolume) {
        this.totalVolume = totalVolume;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public Double getWeightFee() {
        return weightFee;
    }

    public void setWeightFee(Double weightFee) {
        this.weightFee = weightFee;
    }

    public Double getVolumeFee() {
        return volumeFee;
    }

    public void setVolumeFee(Double volumeFee) {
        this.volumeFee = volumeFee;
    }

    public Double getTaxFee() {
        return taxFee;
    }

    public void setTaxFee(Double taxFee) {
        this.taxFee = taxFee;
    }

    public Double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }

    @Override
    public String toString() {
        return "Info{" +
                "orderId=" + orderId +
                ", totalVolume=" + totalVolume +
                ", totalWeight=" + totalWeight +
                ", totalValue=" + totalValue +
                ", taxRate=" + taxRate +
                ", weightFee=" + weightFee +
                ", volumeFee=" + volumeFee +
                ", taxFee=" + taxFee +
                ", totalFee=" + totalFee +
                '}';
    }
}