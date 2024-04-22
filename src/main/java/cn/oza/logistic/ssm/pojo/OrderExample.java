package cn.oza.logistic.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Long value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Long value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Long value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Long value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Long value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Long> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Long> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Long value1, Long value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Long value1, Long value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andShippingAddressIsNull() {
            addCriterion("shipping_address is null");
            return (Criteria) this;
        }

        public Criteria andShippingAddressIsNotNull() {
            addCriterion("shipping_address is not null");
            return (Criteria) this;
        }

        public Criteria andShippingAddressEqualTo(String value) {
            addCriterion("shipping_address =", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressNotEqualTo(String value) {
            addCriterion("shipping_address <>", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressGreaterThan(String value) {
            addCriterion("shipping_address >", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_address >=", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressLessThan(String value) {
            addCriterion("shipping_address <", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressLessThanOrEqualTo(String value) {
            addCriterion("shipping_address <=", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressLike(String value) {
            addCriterion("shipping_address like", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressNotLike(String value) {
            addCriterion("shipping_address not like", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressIn(List<String> values) {
            addCriterion("shipping_address in", values, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressNotIn(List<String> values) {
            addCriterion("shipping_address not in", values, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressBetween(String value1, String value2) {
            addCriterion("shipping_address between", value1, value2, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressNotBetween(String value1, String value2) {
            addCriterion("shipping_address not between", value1, value2, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingNameIsNull() {
            addCriterion("shipping_name is null");
            return (Criteria) this;
        }

        public Criteria andShippingNameIsNotNull() {
            addCriterion("shipping_name is not null");
            return (Criteria) this;
        }

        public Criteria andShippingNameEqualTo(String value) {
            addCriterion("shipping_name =", value, "shippingName");
            return (Criteria) this;
        }

        public Criteria andShippingNameNotEqualTo(String value) {
            addCriterion("shipping_name <>", value, "shippingName");
            return (Criteria) this;
        }

        public Criteria andShippingNameGreaterThan(String value) {
            addCriterion("shipping_name >", value, "shippingName");
            return (Criteria) this;
        }

        public Criteria andShippingNameGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_name >=", value, "shippingName");
            return (Criteria) this;
        }

        public Criteria andShippingNameLessThan(String value) {
            addCriterion("shipping_name <", value, "shippingName");
            return (Criteria) this;
        }

        public Criteria andShippingNameLessThanOrEqualTo(String value) {
            addCriterion("shipping_name <=", value, "shippingName");
            return (Criteria) this;
        }

        public Criteria andShippingNameLike(String value) {
            addCriterion("shipping_name like", value, "shippingName");
            return (Criteria) this;
        }

        public Criteria andShippingNameNotLike(String value) {
            addCriterion("shipping_name not like", value, "shippingName");
            return (Criteria) this;
        }

        public Criteria andShippingNameIn(List<String> values) {
            addCriterion("shipping_name in", values, "shippingName");
            return (Criteria) this;
        }

        public Criteria andShippingNameNotIn(List<String> values) {
            addCriterion("shipping_name not in", values, "shippingName");
            return (Criteria) this;
        }

        public Criteria andShippingNameBetween(String value1, String value2) {
            addCriterion("shipping_name between", value1, value2, "shippingName");
            return (Criteria) this;
        }

        public Criteria andShippingNameNotBetween(String value1, String value2) {
            addCriterion("shipping_name not between", value1, value2, "shippingName");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneIsNull() {
            addCriterion("shipping_phone is null");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneIsNotNull() {
            addCriterion("shipping_phone is not null");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneEqualTo(String value) {
            addCriterion("shipping_phone =", value, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneNotEqualTo(String value) {
            addCriterion("shipping_phone <>", value, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneGreaterThan(String value) {
            addCriterion("shipping_phone >", value, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_phone >=", value, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneLessThan(String value) {
            addCriterion("shipping_phone <", value, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneLessThanOrEqualTo(String value) {
            addCriterion("shipping_phone <=", value, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneLike(String value) {
            addCriterion("shipping_phone like", value, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneNotLike(String value) {
            addCriterion("shipping_phone not like", value, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneIn(List<String> values) {
            addCriterion("shipping_phone in", values, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneNotIn(List<String> values) {
            addCriterion("shipping_phone not in", values, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneBetween(String value1, String value2) {
            addCriterion("shipping_phone between", value1, value2, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneNotBetween(String value1, String value2) {
            addCriterion("shipping_phone not between", value1, value2, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andTakeNameIsNull() {
            addCriterion("take_name is null");
            return (Criteria) this;
        }

        public Criteria andTakeNameIsNotNull() {
            addCriterion("take_name is not null");
            return (Criteria) this;
        }

        public Criteria andTakeNameEqualTo(String value) {
            addCriterion("take_name =", value, "takeName");
            return (Criteria) this;
        }

        public Criteria andTakeNameNotEqualTo(String value) {
            addCriterion("take_name <>", value, "takeName");
            return (Criteria) this;
        }

        public Criteria andTakeNameGreaterThan(String value) {
            addCriterion("take_name >", value, "takeName");
            return (Criteria) this;
        }

        public Criteria andTakeNameGreaterThanOrEqualTo(String value) {
            addCriterion("take_name >=", value, "takeName");
            return (Criteria) this;
        }

        public Criteria andTakeNameLessThan(String value) {
            addCriterion("take_name <", value, "takeName");
            return (Criteria) this;
        }

        public Criteria andTakeNameLessThanOrEqualTo(String value) {
            addCriterion("take_name <=", value, "takeName");
            return (Criteria) this;
        }

        public Criteria andTakeNameLike(String value) {
            addCriterion("take_name like", value, "takeName");
            return (Criteria) this;
        }

        public Criteria andTakeNameNotLike(String value) {
            addCriterion("take_name not like", value, "takeName");
            return (Criteria) this;
        }

        public Criteria andTakeNameIn(List<String> values) {
            addCriterion("take_name in", values, "takeName");
            return (Criteria) this;
        }

        public Criteria andTakeNameNotIn(List<String> values) {
            addCriterion("take_name not in", values, "takeName");
            return (Criteria) this;
        }

        public Criteria andTakeNameBetween(String value1, String value2) {
            addCriterion("take_name between", value1, value2, "takeName");
            return (Criteria) this;
        }

        public Criteria andTakeNameNotBetween(String value1, String value2) {
            addCriterion("take_name not between", value1, value2, "takeName");
            return (Criteria) this;
        }

        public Criteria andTakeAddressIsNull() {
            addCriterion("take_address is null");
            return (Criteria) this;
        }

        public Criteria andTakeAddressIsNotNull() {
            addCriterion("take_address is not null");
            return (Criteria) this;
        }

        public Criteria andTakeAddressEqualTo(String value) {
            addCriterion("take_address =", value, "takeAddress");
            return (Criteria) this;
        }

        public Criteria andTakeAddressNotEqualTo(String value) {
            addCriterion("take_address <>", value, "takeAddress");
            return (Criteria) this;
        }

        public Criteria andTakeAddressGreaterThan(String value) {
            addCriterion("take_address >", value, "takeAddress");
            return (Criteria) this;
        }

        public Criteria andTakeAddressGreaterThanOrEqualTo(String value) {
            addCriterion("take_address >=", value, "takeAddress");
            return (Criteria) this;
        }

        public Criteria andTakeAddressLessThan(String value) {
            addCriterion("take_address <", value, "takeAddress");
            return (Criteria) this;
        }

        public Criteria andTakeAddressLessThanOrEqualTo(String value) {
            addCriterion("take_address <=", value, "takeAddress");
            return (Criteria) this;
        }

        public Criteria andTakeAddressLike(String value) {
            addCriterion("take_address like", value, "takeAddress");
            return (Criteria) this;
        }

        public Criteria andTakeAddressNotLike(String value) {
            addCriterion("take_address not like", value, "takeAddress");
            return (Criteria) this;
        }

        public Criteria andTakeAddressIn(List<String> values) {
            addCriterion("take_address in", values, "takeAddress");
            return (Criteria) this;
        }

        public Criteria andTakeAddressNotIn(List<String> values) {
            addCriterion("take_address not in", values, "takeAddress");
            return (Criteria) this;
        }

        public Criteria andTakeAddressBetween(String value1, String value2) {
            addCriterion("take_address between", value1, value2, "takeAddress");
            return (Criteria) this;
        }

        public Criteria andTakeAddressNotBetween(String value1, String value2) {
            addCriterion("take_address not between", value1, value2, "takeAddress");
            return (Criteria) this;
        }

        public Criteria andTakePhoneIsNull() {
            addCriterion("take_phone is null");
            return (Criteria) this;
        }

        public Criteria andTakePhoneIsNotNull() {
            addCriterion("take_phone is not null");
            return (Criteria) this;
        }

        public Criteria andTakePhoneEqualTo(String value) {
            addCriterion("take_phone =", value, "takePhone");
            return (Criteria) this;
        }

        public Criteria andTakePhoneNotEqualTo(String value) {
            addCriterion("take_phone <>", value, "takePhone");
            return (Criteria) this;
        }

        public Criteria andTakePhoneGreaterThan(String value) {
            addCriterion("take_phone >", value, "takePhone");
            return (Criteria) this;
        }

        public Criteria andTakePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("take_phone >=", value, "takePhone");
            return (Criteria) this;
        }

        public Criteria andTakePhoneLessThan(String value) {
            addCriterion("take_phone <", value, "takePhone");
            return (Criteria) this;
        }

        public Criteria andTakePhoneLessThanOrEqualTo(String value) {
            addCriterion("take_phone <=", value, "takePhone");
            return (Criteria) this;
        }

        public Criteria andTakePhoneLike(String value) {
            addCriterion("take_phone like", value, "takePhone");
            return (Criteria) this;
        }

        public Criteria andTakePhoneNotLike(String value) {
            addCriterion("take_phone not like", value, "takePhone");
            return (Criteria) this;
        }

        public Criteria andTakePhoneIn(List<String> values) {
            addCriterion("take_phone in", values, "takePhone");
            return (Criteria) this;
        }

        public Criteria andTakePhoneNotIn(List<String> values) {
            addCriterion("take_phone not in", values, "takePhone");
            return (Criteria) this;
        }

        public Criteria andTakePhoneBetween(String value1, String value2) {
            addCriterion("take_phone between", value1, value2, "takePhone");
            return (Criteria) this;
        }

        public Criteria andTakePhoneNotBetween(String value1, String value2) {
            addCriterion("take_phone not between", value1, value2, "takePhone");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(Integer value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(Integer value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(Integer value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(Integer value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<Integer> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<Integer> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIdIsNull() {
            addCriterion("payment_method_id is null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIdIsNotNull() {
            addCriterion("payment_method_id is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIdEqualTo(Long value) {
            addCriterion("payment_method_id =", value, "paymentMethodId");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIdNotEqualTo(Long value) {
            addCriterion("payment_method_id <>", value, "paymentMethodId");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIdGreaterThan(Long value) {
            addCriterion("payment_method_id >", value, "paymentMethodId");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIdGreaterThanOrEqualTo(Long value) {
            addCriterion("payment_method_id >=", value, "paymentMethodId");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIdLessThan(Long value) {
            addCriterion("payment_method_id <", value, "paymentMethodId");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIdLessThanOrEqualTo(Long value) {
            addCriterion("payment_method_id <=", value, "paymentMethodId");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIdIn(List<Long> values) {
            addCriterion("payment_method_id in", values, "paymentMethodId");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIdNotIn(List<Long> values) {
            addCriterion("payment_method_id not in", values, "paymentMethodId");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIdBetween(Long value1, Long value2) {
            addCriterion("payment_method_id between", value1, value2, "paymentMethodId");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIdNotBetween(Long value1, Long value2) {
            addCriterion("payment_method_id not between", value1, value2, "paymentMethodId");
            return (Criteria) this;
        }

        public Criteria andIntervalIdIsNull() {
            addCriterion("interval_id is null");
            return (Criteria) this;
        }

        public Criteria andIntervalIdIsNotNull() {
            addCriterion("interval_id is not null");
            return (Criteria) this;
        }

        public Criteria andIntervalIdEqualTo(Long value) {
            addCriterion("interval_id =", value, "intervalId");
            return (Criteria) this;
        }

        public Criteria andIntervalIdNotEqualTo(Long value) {
            addCriterion("interval_id <>", value, "intervalId");
            return (Criteria) this;
        }

        public Criteria andIntervalIdGreaterThan(Long value) {
            addCriterion("interval_id >", value, "intervalId");
            return (Criteria) this;
        }

        public Criteria andIntervalIdGreaterThanOrEqualTo(Long value) {
            addCriterion("interval_id >=", value, "intervalId");
            return (Criteria) this;
        }

        public Criteria andIntervalIdLessThan(Long value) {
            addCriterion("interval_id <", value, "intervalId");
            return (Criteria) this;
        }

        public Criteria andIntervalIdLessThanOrEqualTo(Long value) {
            addCriterion("interval_id <=", value, "intervalId");
            return (Criteria) this;
        }

        public Criteria andIntervalIdIn(List<Long> values) {
            addCriterion("interval_id in", values, "intervalId");
            return (Criteria) this;
        }

        public Criteria andIntervalIdNotIn(List<Long> values) {
            addCriterion("interval_id not in", values, "intervalId");
            return (Criteria) this;
        }

        public Criteria andIntervalIdBetween(Long value1, Long value2) {
            addCriterion("interval_id between", value1, value2, "intervalId");
            return (Criteria) this;
        }

        public Criteria andIntervalIdNotBetween(Long value1, Long value2) {
            addCriterion("interval_id not between", value1, value2, "intervalId");
            return (Criteria) this;
        }

        public Criteria andTakeMethodIdIsNull() {
            addCriterion("take_method_id is null");
            return (Criteria) this;
        }

        public Criteria andTakeMethodIdIsNotNull() {
            addCriterion("take_method_id is not null");
            return (Criteria) this;
        }

        public Criteria andTakeMethodIdEqualTo(Long value) {
            addCriterion("take_method_id =", value, "takeMethodId");
            return (Criteria) this;
        }

        public Criteria andTakeMethodIdNotEqualTo(Long value) {
            addCriterion("take_method_id <>", value, "takeMethodId");
            return (Criteria) this;
        }

        public Criteria andTakeMethodIdGreaterThan(Long value) {
            addCriterion("take_method_id >", value, "takeMethodId");
            return (Criteria) this;
        }

        public Criteria andTakeMethodIdGreaterThanOrEqualTo(Long value) {
            addCriterion("take_method_id >=", value, "takeMethodId");
            return (Criteria) this;
        }

        public Criteria andTakeMethodIdLessThan(Long value) {
            addCriterion("take_method_id <", value, "takeMethodId");
            return (Criteria) this;
        }

        public Criteria andTakeMethodIdLessThanOrEqualTo(Long value) {
            addCriterion("take_method_id <=", value, "takeMethodId");
            return (Criteria) this;
        }

        public Criteria andTakeMethodIdIn(List<Long> values) {
            addCriterion("take_method_id in", values, "takeMethodId");
            return (Criteria) this;
        }

        public Criteria andTakeMethodIdNotIn(List<Long> values) {
            addCriterion("take_method_id not in", values, "takeMethodId");
            return (Criteria) this;
        }

        public Criteria andTakeMethodIdBetween(Long value1, Long value2) {
            addCriterion("take_method_id between", value1, value2, "takeMethodId");
            return (Criteria) this;
        }

        public Criteria andTakeMethodIdNotBetween(Long value1, Long value2) {
            addCriterion("take_method_id not between", value1, value2, "takeMethodId");
            return (Criteria) this;
        }

        public Criteria andFreightMethodIdIsNull() {
            addCriterion("freight_method_id is null");
            return (Criteria) this;
        }

        public Criteria andFreightMethodIdIsNotNull() {
            addCriterion("freight_method_id is not null");
            return (Criteria) this;
        }

        public Criteria andFreightMethodIdEqualTo(Long value) {
            addCriterion("freight_method_id =", value, "freightMethodId");
            return (Criteria) this;
        }

        public Criteria andFreightMethodIdNotEqualTo(Long value) {
            addCriterion("freight_method_id <>", value, "freightMethodId");
            return (Criteria) this;
        }

        public Criteria andFreightMethodIdGreaterThan(Long value) {
            addCriterion("freight_method_id >", value, "freightMethodId");
            return (Criteria) this;
        }

        public Criteria andFreightMethodIdGreaterThanOrEqualTo(Long value) {
            addCriterion("freight_method_id >=", value, "freightMethodId");
            return (Criteria) this;
        }

        public Criteria andFreightMethodIdLessThan(Long value) {
            addCriterion("freight_method_id <", value, "freightMethodId");
            return (Criteria) this;
        }

        public Criteria andFreightMethodIdLessThanOrEqualTo(Long value) {
            addCriterion("freight_method_id <=", value, "freightMethodId");
            return (Criteria) this;
        }

        public Criteria andFreightMethodIdIn(List<Long> values) {
            addCriterion("freight_method_id in", values, "freightMethodId");
            return (Criteria) this;
        }

        public Criteria andFreightMethodIdNotIn(List<Long> values) {
            addCriterion("freight_method_id not in", values, "freightMethodId");
            return (Criteria) this;
        }

        public Criteria andFreightMethodIdBetween(Long value1, Long value2) {
            addCriterion("freight_method_id between", value1, value2, "freightMethodId");
            return (Criteria) this;
        }

        public Criteria andFreightMethodIdNotBetween(Long value1, Long value2) {
            addCriterion("freight_method_id not between", value1, value2, "freightMethodId");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIsNull() {
            addCriterion("order_remark is null");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIsNotNull() {
            addCriterion("order_remark is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkEqualTo(String value) {
            addCriterion("order_remark =", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotEqualTo(String value) {
            addCriterion("order_remark <>", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkGreaterThan(String value) {
            addCriterion("order_remark >", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("order_remark >=", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLessThan(String value) {
            addCriterion("order_remark <", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLessThanOrEqualTo(String value) {
            addCriterion("order_remark <=", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLike(String value) {
            addCriterion("order_remark like", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotLike(String value) {
            addCriterion("order_remark not like", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIn(List<String> values) {
            addCriterion("order_remark in", values, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotIn(List<String> values) {
            addCriterion("order_remark not in", values, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkBetween(String value1, String value2) {
            addCriterion("order_remark between", value1, value2, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotBetween(String value1, String value2) {
            addCriterion("order_remark not between", value1, value2, "orderRemark");
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