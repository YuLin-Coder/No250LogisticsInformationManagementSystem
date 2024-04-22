package cn.oza.logistic.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class InfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InfoExample() {
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

        public Criteria andTotalVolumeIsNull() {
            addCriterion("total_volume is null");
            return (Criteria) this;
        }

        public Criteria andTotalVolumeIsNotNull() {
            addCriterion("total_volume is not null");
            return (Criteria) this;
        }

        public Criteria andTotalVolumeEqualTo(Double value) {
            addCriterion("total_volume =", value, "totalVolume");
            return (Criteria) this;
        }

        public Criteria andTotalVolumeNotEqualTo(Double value) {
            addCriterion("total_volume <>", value, "totalVolume");
            return (Criteria) this;
        }

        public Criteria andTotalVolumeGreaterThan(Double value) {
            addCriterion("total_volume >", value, "totalVolume");
            return (Criteria) this;
        }

        public Criteria andTotalVolumeGreaterThanOrEqualTo(Double value) {
            addCriterion("total_volume >=", value, "totalVolume");
            return (Criteria) this;
        }

        public Criteria andTotalVolumeLessThan(Double value) {
            addCriterion("total_volume <", value, "totalVolume");
            return (Criteria) this;
        }

        public Criteria andTotalVolumeLessThanOrEqualTo(Double value) {
            addCriterion("total_volume <=", value, "totalVolume");
            return (Criteria) this;
        }

        public Criteria andTotalVolumeIn(List<Double> values) {
            addCriterion("total_volume in", values, "totalVolume");
            return (Criteria) this;
        }

        public Criteria andTotalVolumeNotIn(List<Double> values) {
            addCriterion("total_volume not in", values, "totalVolume");
            return (Criteria) this;
        }

        public Criteria andTotalVolumeBetween(Double value1, Double value2) {
            addCriterion("total_volume between", value1, value2, "totalVolume");
            return (Criteria) this;
        }

        public Criteria andTotalVolumeNotBetween(Double value1, Double value2) {
            addCriterion("total_volume not between", value1, value2, "totalVolume");
            return (Criteria) this;
        }

        public Criteria andTotalWeightIsNull() {
            addCriterion("total_weight is null");
            return (Criteria) this;
        }

        public Criteria andTotalWeightIsNotNull() {
            addCriterion("total_weight is not null");
            return (Criteria) this;
        }

        public Criteria andTotalWeightEqualTo(Double value) {
            addCriterion("total_weight =", value, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightNotEqualTo(Double value) {
            addCriterion("total_weight <>", value, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightGreaterThan(Double value) {
            addCriterion("total_weight >", value, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("total_weight >=", value, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightLessThan(Double value) {
            addCriterion("total_weight <", value, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightLessThanOrEqualTo(Double value) {
            addCriterion("total_weight <=", value, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightIn(List<Double> values) {
            addCriterion("total_weight in", values, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightNotIn(List<Double> values) {
            addCriterion("total_weight not in", values, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightBetween(Double value1, Double value2) {
            addCriterion("total_weight between", value1, value2, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightNotBetween(Double value1, Double value2) {
            addCriterion("total_weight not between", value1, value2, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalValueIsNull() {
            addCriterion("total_value is null");
            return (Criteria) this;
        }

        public Criteria andTotalValueIsNotNull() {
            addCriterion("total_value is not null");
            return (Criteria) this;
        }

        public Criteria andTotalValueEqualTo(Double value) {
            addCriterion("total_value =", value, "totalValue");
            return (Criteria) this;
        }

        public Criteria andTotalValueNotEqualTo(Double value) {
            addCriterion("total_value <>", value, "totalValue");
            return (Criteria) this;
        }

        public Criteria andTotalValueGreaterThan(Double value) {
            addCriterion("total_value >", value, "totalValue");
            return (Criteria) this;
        }

        public Criteria andTotalValueGreaterThanOrEqualTo(Double value) {
            addCriterion("total_value >=", value, "totalValue");
            return (Criteria) this;
        }

        public Criteria andTotalValueLessThan(Double value) {
            addCriterion("total_value <", value, "totalValue");
            return (Criteria) this;
        }

        public Criteria andTotalValueLessThanOrEqualTo(Double value) {
            addCriterion("total_value <=", value, "totalValue");
            return (Criteria) this;
        }

        public Criteria andTotalValueIn(List<Double> values) {
            addCriterion("total_value in", values, "totalValue");
            return (Criteria) this;
        }

        public Criteria andTotalValueNotIn(List<Double> values) {
            addCriterion("total_value not in", values, "totalValue");
            return (Criteria) this;
        }

        public Criteria andTotalValueBetween(Double value1, Double value2) {
            addCriterion("total_value between", value1, value2, "totalValue");
            return (Criteria) this;
        }

        public Criteria andTotalValueNotBetween(Double value1, Double value2) {
            addCriterion("total_value not between", value1, value2, "totalValue");
            return (Criteria) this;
        }

        public Criteria andTaxRateIsNull() {
            addCriterion("tax_rate is null");
            return (Criteria) this;
        }

        public Criteria andTaxRateIsNotNull() {
            addCriterion("tax_rate is not null");
            return (Criteria) this;
        }

        public Criteria andTaxRateEqualTo(Double value) {
            addCriterion("tax_rate =", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotEqualTo(Double value) {
            addCriterion("tax_rate <>", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateGreaterThan(Double value) {
            addCriterion("tax_rate >", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateGreaterThanOrEqualTo(Double value) {
            addCriterion("tax_rate >=", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateLessThan(Double value) {
            addCriterion("tax_rate <", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateLessThanOrEqualTo(Double value) {
            addCriterion("tax_rate <=", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateIn(List<Double> values) {
            addCriterion("tax_rate in", values, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotIn(List<Double> values) {
            addCriterion("tax_rate not in", values, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateBetween(Double value1, Double value2) {
            addCriterion("tax_rate between", value1, value2, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotBetween(Double value1, Double value2) {
            addCriterion("tax_rate not between", value1, value2, "taxRate");
            return (Criteria) this;
        }

        public Criteria andWeightFeeIsNull() {
            addCriterion("weight_fee is null");
            return (Criteria) this;
        }

        public Criteria andWeightFeeIsNotNull() {
            addCriterion("weight_fee is not null");
            return (Criteria) this;
        }

        public Criteria andWeightFeeEqualTo(Double value) {
            addCriterion("weight_fee =", value, "weightFee");
            return (Criteria) this;
        }

        public Criteria andWeightFeeNotEqualTo(Double value) {
            addCriterion("weight_fee <>", value, "weightFee");
            return (Criteria) this;
        }

        public Criteria andWeightFeeGreaterThan(Double value) {
            addCriterion("weight_fee >", value, "weightFee");
            return (Criteria) this;
        }

        public Criteria andWeightFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("weight_fee >=", value, "weightFee");
            return (Criteria) this;
        }

        public Criteria andWeightFeeLessThan(Double value) {
            addCriterion("weight_fee <", value, "weightFee");
            return (Criteria) this;
        }

        public Criteria andWeightFeeLessThanOrEqualTo(Double value) {
            addCriterion("weight_fee <=", value, "weightFee");
            return (Criteria) this;
        }

        public Criteria andWeightFeeIn(List<Double> values) {
            addCriterion("weight_fee in", values, "weightFee");
            return (Criteria) this;
        }

        public Criteria andWeightFeeNotIn(List<Double> values) {
            addCriterion("weight_fee not in", values, "weightFee");
            return (Criteria) this;
        }

        public Criteria andWeightFeeBetween(Double value1, Double value2) {
            addCriterion("weight_fee between", value1, value2, "weightFee");
            return (Criteria) this;
        }

        public Criteria andWeightFeeNotBetween(Double value1, Double value2) {
            addCriterion("weight_fee not between", value1, value2, "weightFee");
            return (Criteria) this;
        }

        public Criteria andVolumeFeeIsNull() {
            addCriterion("volume_fee is null");
            return (Criteria) this;
        }

        public Criteria andVolumeFeeIsNotNull() {
            addCriterion("volume_fee is not null");
            return (Criteria) this;
        }

        public Criteria andVolumeFeeEqualTo(Double value) {
            addCriterion("volume_fee =", value, "volumeFee");
            return (Criteria) this;
        }

        public Criteria andVolumeFeeNotEqualTo(Double value) {
            addCriterion("volume_fee <>", value, "volumeFee");
            return (Criteria) this;
        }

        public Criteria andVolumeFeeGreaterThan(Double value) {
            addCriterion("volume_fee >", value, "volumeFee");
            return (Criteria) this;
        }

        public Criteria andVolumeFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("volume_fee >=", value, "volumeFee");
            return (Criteria) this;
        }

        public Criteria andVolumeFeeLessThan(Double value) {
            addCriterion("volume_fee <", value, "volumeFee");
            return (Criteria) this;
        }

        public Criteria andVolumeFeeLessThanOrEqualTo(Double value) {
            addCriterion("volume_fee <=", value, "volumeFee");
            return (Criteria) this;
        }

        public Criteria andVolumeFeeIn(List<Double> values) {
            addCriterion("volume_fee in", values, "volumeFee");
            return (Criteria) this;
        }

        public Criteria andVolumeFeeNotIn(List<Double> values) {
            addCriterion("volume_fee not in", values, "volumeFee");
            return (Criteria) this;
        }

        public Criteria andVolumeFeeBetween(Double value1, Double value2) {
            addCriterion("volume_fee between", value1, value2, "volumeFee");
            return (Criteria) this;
        }

        public Criteria andVolumeFeeNotBetween(Double value1, Double value2) {
            addCriterion("volume_fee not between", value1, value2, "volumeFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeIsNull() {
            addCriterion("tax_fee is null");
            return (Criteria) this;
        }

        public Criteria andTaxFeeIsNotNull() {
            addCriterion("tax_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTaxFeeEqualTo(Double value) {
            addCriterion("tax_fee =", value, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeNotEqualTo(Double value) {
            addCriterion("tax_fee <>", value, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeGreaterThan(Double value) {
            addCriterion("tax_fee >", value, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("tax_fee >=", value, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeLessThan(Double value) {
            addCriterion("tax_fee <", value, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeLessThanOrEqualTo(Double value) {
            addCriterion("tax_fee <=", value, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeIn(List<Double> values) {
            addCriterion("tax_fee in", values, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeNotIn(List<Double> values) {
            addCriterion("tax_fee not in", values, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeBetween(Double value1, Double value2) {
            addCriterion("tax_fee between", value1, value2, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeNotBetween(Double value1, Double value2) {
            addCriterion("tax_fee not between", value1, value2, "taxFee");
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

        public Criteria andTotalFeeEqualTo(Double value) {
            addCriterion("total_fee =", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotEqualTo(Double value) {
            addCriterion("total_fee <>", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThan(Double value) {
            addCriterion("total_fee >", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("total_fee >=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThan(Double value) {
            addCriterion("total_fee <", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(Double value) {
            addCriterion("total_fee <=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIn(List<Double> values) {
            addCriterion("total_fee in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotIn(List<Double> values) {
            addCriterion("total_fee not in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeBetween(Double value1, Double value2) {
            addCriterion("total_fee between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotBetween(Double value1, Double value2) {
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