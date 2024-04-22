package cn.oza.logistic.ssm.pojo;

import java.util.List;

public class Transaction {
    private Long transactionId;

    private Long orderId;

    private Long userId;

    private Integer pickUpFee;

    private Double volumeRate;

    private Double weightRate;

    private Long storageId;

    private String totalFee;

    private List<TransactionDetail> transactionDetails;

    public List<TransactionDetail> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(List<TransactionDetail> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getPickUpFee() {
        return pickUpFee;
    }

    public void setPickUpFee(Integer pickUpFee) {
        this.pickUpFee = pickUpFee;
    }

    public Double getVolumeRate() {
        return volumeRate;
    }

    public void setVolumeRate(Double volumeRate) {
        this.volumeRate = volumeRate;
    }

    public Double getWeightRate() {
        return weightRate;
    }

    public void setWeightRate(Double weightRate) {
        this.weightRate = weightRate;
    }

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee == null ? null : totalFee.trim();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", orderId=" + orderId +
                ", userId=" + userId +
                ", pickUpFee=" + pickUpFee +
                ", volumeRate=" + volumeRate +
                ", weightRate=" + weightRate +
                ", storageId=" + storageId +
                ", totalFee='" + totalFee + '\'' +
                ", transactionDetails=" + transactionDetails +
                '}';
    }
}