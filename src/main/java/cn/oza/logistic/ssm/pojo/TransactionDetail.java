package cn.oza.logistic.ssm.pojo;

public class TransactionDetail {
    private Long transactionDetailId;

    private Long orderDetailId;

    private Long length;

    private Long width;

    private Long height;

    private Double volume;

    private Double weight;

    public Long getTransactionDetailId() {
        return transactionDetailId;
    }

    public void setTransactionDetailId(Long transactionDetailId) {
        this.transactionDetailId = transactionDetailId;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "TransactionDetail{" +
                "transactionDetailId=" + transactionDetailId +
                ", orderDetailId=" + orderDetailId +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", volume=" + volume +
                ", weight=" + weight +
                '}';
    }
}