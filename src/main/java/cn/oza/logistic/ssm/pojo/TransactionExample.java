package cn.oza.logistic.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class TransactionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransactionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTransactionIdIsNull() {
            addCriterion("transaction_id is null");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIsNotNull() {
            addCriterion("transaction_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionIdEqualTo(Long value) {
            addCriterion("transaction_id =", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotEqualTo(Long value) {
            addCriterion("transaction_id <>", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdGreaterThan(Long value) {
            addCriterion("transaction_id >", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("transaction_id >=", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLessThan(Long value) {
            addCriterion("transaction_id <", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLessThanOrEqualTo(Long value) {
            addCriterion("transaction_id <=", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIn(List<Long> values) {
            addCriterion("transaction_id in", values, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotIn(List<Long> values) {
            addCriterion("transaction_id not in", values, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdBetween(Long value1, Long value2) {
            addCriterion("transaction_id between", value1, value2, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotBetween(Long value1, Long value2) {
            addCriterion("transaction_id not between", value1, value2, "transactionId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPickUpFeeIsNull() {
            addCriterion("pick_up_fee is null");
            return (Criteria) this;
        }

        public Criteria andPickUpFeeIsNotNull() {
            addCriterion("pick_up_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPickUpFeeEqualTo(Integer value) {
            addCriterion("pick_up_fee =", value, "pickUpFee");
            return (Criteria) this;
        }

        public Criteria andPickUpFeeNotEqualTo(Integer value) {
            addCriterion("pick_up_fee <>", value, "pickUpFee");
            return (Criteria) this;
        }

        public Criteria andPickUpFeeGreaterThan(Integer value) {
            addCriterion("pick_up_fee >", value, "pickUpFee");
            return (Criteria) this;
        }

        public Criteria andPickUpFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pick_up_fee >=", value, "pickUpFee");
            return (Criteria) this;
        }

        public Criteria andPickUpFeeLessThan(Integer value) {
            addCriterion("pick_up_fee <", value, "pickUpFee");
            return (Criteria) this;
        }

        public Criteria andPickUpFeeLessThanOrEqualTo(Integer value) {
            addCriterion("pick_up_fee <=", value, "pickUpFee");
            return (Criteria) this;
        }

        public Criteria andPickUpFeeIn(List<Integer> values) {
            addCriterion("pick_up_fee in", values, "pickUpFee");
            return (Criteria) this;
        }

        public Criteria andPickUpFeeNotIn(List<Integer> values) {
            addCriterion("pick_up_fee not in", values, "pickUpFee");
            return (Criteria) this;
        }

        public Criteria andPickUpFeeBetween(Integer value1, Integer value2) {
            addCriterion("pick_up_fee between", value1, value2, "pickUpFee");
            return (Criteria) this;
        }

        public Criteria andPickUpFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("pick_up_fee not between", value1, value2, "pickUpFee");
            return (Criteria) this;
        }

        public Criteria andVolumeRateIsNull() {
            addCriterion("volume_rate is null");
            return (Criteria) this;
        }

        public Criteria andVolumeRateIsNotNull() {
            addCriterion("volume_rate is not null");
            return (Criteria) this;
        }

        public Criteria andVolumeRateEqualTo(Double value) {
            addCriterion("volume_rate =", value, "volumeRate");
            return (Criteria) this;
        }

        public Criteria andVolumeRateNotEqualTo(Double value) {
            addCriterion("volume_rate <>", value, "volumeRate");
            return (Criteria) this;
        }

        public Criteria andVolumeRateGreaterThan(Double value) {
            addCriterion("volume_rate >", value, "volumeRate");
            return (Criteria) this;
        }

        public Criteria andVolumeRateGreaterThanOrEqualTo(Double value) {
            addCriterion("volume_rate >=", value, "volumeRate");
            return (Criteria) this;
        }

        public Criteria andVolumeRateLessThan(Double value) {
            addCriterion("volume_rate <", value, "volumeRate");
            return (Criteria) this;
        }

        public Criteria andVolumeRateLessThanOrEqualTo(Double value) {
            addCriterion("volume_rate <=", value, "volumeRate");
            return (Criteria) this;
        }

        public Criteria andVolumeRateIn(List<Double> values) {
            addCriterion("volume_rate in", values, "volumeRate");
            return (Criteria) this;
        }

        public Criteria andVolumeRateNotIn(List<Double> values) {
            addCriterion("volume_rate not in", values, "volumeRate");
            return (Criteria) this;
        }

        public Criteria andVolumeRateBetween(Double value1, Double value2) {
            addCriterion("volume_rate between", value1, value2, "volumeRate");
            return (Criteria) this;
        }

        public Criteria andVolumeRateNotBetween(Double value1, Double value2) {
            addCriterion("volume_rate not between", value1, value2, "volumeRate");
            return (Criteria) this;
        }

        public Criteria andWeightRateIsNull() {
            addCriterion("weight_rate is null");
            return (Criteria) this;
        }

        public Criteria andWeightRateIsNotNull() {
            addCriterion("weight_rate is not null");
            return (Criteria) this;
        }

        public Criteria andWeightRateEqualTo(Double value) {
            addCriterion("weight_rate =", value, "weightRate");
            return (Criteria) this;
        }

        public Criteria andWeightRateNotEqualTo(Double value) {
            addCriterion("weight_rate <>", value, "weightRate");
            return (Criteria) this;
        }

        public Criteria andWeightRateGreaterThan(Double value) {
            addCriterion("weight_rate >", value, "weightRate");
            return (Criteria) this;
        }

        public Criteria andWeightRateGreaterThanOrEqualTo(Double value) {
            addCriterion("weight_rate >=", value, "weightRate");
            return (Criteria) this;
        }

        public Criteria andWeightRateLessThan(Double value) {
            addCriterion("weight_rate <", value, "weightRate");
            return (Criteria) this;
        }

        public Criteria andWeightRateLessThanOrEqualTo(Double value) {
            addCriterion("weight_rate <=", value, "weightRate");
            return (Criteria) this;
        }

        public Criteria andWeightRateIn(List<Double> values) {
            addCriterion("weight_rate in", values, "weightRate");
            return (Criteria) this;
        }

        public Criteria andWeightRateNotIn(List<Double> values) {
            addCriterion("weight_rate not in", values, "weightRate");
            return (Criteria) this;
        }

        public Criteria andWeightRateBetween(Double value1, Double value2) {
            addCriterion("weight_rate between", value1, value2, "weightRate");
            return (Criteria) this;
        }

        public Criteria andWeightRateNotBetween(Double value1, Double value2) {
            addCriterion("weight_rate not between", value1, value2, "weightRate");
            return (Criteria) this;
        }

        public Criteria andStorageIdIsNull() {
            addCriterion("storage_id is null");
            return (Criteria) this;
        }

        public Criteria andStorageIdIsNotNull() {
            addCriterion("storage_id is not null");
            return (Criteria) this;
        }

        public Criteria andStorageIdEqualTo(Long value) {
            addCriterion("storage_id =", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdNotEqualTo(Long value) {
            addCriterion("storage_id <>", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdGreaterThan(Long value) {
            addCriterion("storage_id >", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("storage_id >=", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdLessThan(Long value) {
            addCriterion("storage_id <", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdLessThanOrEqualTo(Long value) {
            addCriterion("storage_id <=", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdIn(List<Long> values) {
            addCriterion("storage_id in", values, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdNotIn(List<Long> values) {
            addCriterion("storage_id not in", values, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdBetween(Long value1, Long value2) {
            addCriterion("storage_id between", value1, value2, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdNotBetween(Long value1, Long value2) {
            addCriterion("storage_id not between", value1, value2, "storageId");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNull() {
            addCriterion("total_fee is null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNotNull() {
            addCriterion("total_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeEqualTo(String value) {
            addCriterion("total_fee =", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotEqualTo(String value) {
            addCriterion("total_fee <>", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThan(String value) {
            addCriterion("total_fee >", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(String value) {
            addCriterion("total_fee >=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThan(String value) {
            addCriterion("total_fee <", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(String value) {
            addCriterion("total_fee <=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLike(String value) {
            addCriterion("total_fee like", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotLike(String value) {
            addCriterion("total_fee not like", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIn(List<String> values) {
            addCriterion("total_fee in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotIn(List<String> values) {
            addCriterion("total_fee not in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeBetween(String value1, String value2) {
            addCriterion("total_fee between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotBetween(String value1, String value2) {
            addCriterion("total_fee not between", value1, value2, "totalFee");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}