package cn.oza.logistic.ssm.pojo;

public class Export {
    private Long orderId;

    private String area;

    private String shippingAddress;

    private String payment;

    private String pickupMehtod;

    private String storageStaff;

    private Double weightFee;

    private Double volumeFee;

    private Double taxFee;

    private Integer pickUpFee;

    private Double totalFee;

    private Double totalVolume;

    private Double totalWeight;

    private Double totalValue;

    private String shippingName;

    private String shippingPhone;

    private String shippingMethod;

    private String storage;

    private String staff;

    private String customerName;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress == null ? null : shippingAddress.trim();
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment == null ? null : payment.trim();
    }

    public String getPickupMehtod() {
        return pickupMehtod;
    }

    public void setPickupMehtod(String pickupMehtod) {
        this.pickupMehtod = pickupMehtod == null ? null : pickupMehtod.trim();
    }

    public String getStorageStaff() {
        return storageStaff;
    }

    public void setStorageStaff(String storageStaff) {
        this.storageStaff = storageStaff == null ? null : storageStaff.trim();
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

    public Integer getPickUpFee() {
        return pickUpFee;
    }

    public void setPickUpFee(Integer pickUpFee) {
        this.pickUpFee = pickUpFee;
    }

    public Double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
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

    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName == null ? null : shippingName.trim();
    }

    public String getShippingPhone() {
        return shippingPhone;
    }

    public void setShippingPhone(String shippingPhone) {
        this.shippingPhone = shippingPhone == null ? null : shippingPhone.trim();
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod == null ? null : shippingMethod.trim();
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage == null ? null : storage.trim();
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff == null ? null : staff.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }
}