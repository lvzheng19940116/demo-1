package ad.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AbBillingInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AbBillingInfoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBillingNumberIsNull() {
            addCriterion("billing_number is null");
            return (Criteria) this;
        }

        public Criteria andBillingNumberIsNotNull() {
            addCriterion("billing_number is not null");
            return (Criteria) this;
        }

        public Criteria andBillingNumberEqualTo(String value) {
            addCriterion("billing_number =", value, "billingNumber");
            return (Criteria) this;
        }

        public Criteria andBillingNumberNotEqualTo(String value) {
            addCriterion("billing_number <>", value, "billingNumber");
            return (Criteria) this;
        }

        public Criteria andBillingNumberGreaterThan(String value) {
            addCriterion("billing_number >", value, "billingNumber");
            return (Criteria) this;
        }

        public Criteria andBillingNumberGreaterThanOrEqualTo(String value) {
            addCriterion("billing_number >=", value, "billingNumber");
            return (Criteria) this;
        }

        public Criteria andBillingNumberLessThan(String value) {
            addCriterion("billing_number <", value, "billingNumber");
            return (Criteria) this;
        }

        public Criteria andBillingNumberLessThanOrEqualTo(String value) {
            addCriterion("billing_number <=", value, "billingNumber");
            return (Criteria) this;
        }

        public Criteria andBillingNumberLike(String value) {
            addCriterion("billing_number like", value, "billingNumber");
            return (Criteria) this;
        }

        public Criteria andBillingNumberNotLike(String value) {
            addCriterion("billing_number not like", value, "billingNumber");
            return (Criteria) this;
        }

        public Criteria andBillingNumberIn(List<String> values) {
            addCriterion("billing_number in", values, "billingNumber");
            return (Criteria) this;
        }

        public Criteria andBillingNumberNotIn(List<String> values) {
            addCriterion("billing_number not in", values, "billingNumber");
            return (Criteria) this;
        }

        public Criteria andBillingNumberBetween(String value1, String value2) {
            addCriterion("billing_number between", value1, value2, "billingNumber");
            return (Criteria) this;
        }

        public Criteria andBillingNumberNotBetween(String value1, String value2) {
            addCriterion("billing_number not between", value1, value2, "billingNumber");
            return (Criteria) this;
        }

        public Criteria andBillingUserIdIsNull() {
            addCriterion("billing_user_id is null");
            return (Criteria) this;
        }

        public Criteria andBillingUserIdIsNotNull() {
            addCriterion("billing_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andBillingUserIdEqualTo(Integer value) {
            addCriterion("billing_user_id =", value, "billingUserId");
            return (Criteria) this;
        }

        public Criteria andBillingUserIdNotEqualTo(Integer value) {
            addCriterion("billing_user_id <>", value, "billingUserId");
            return (Criteria) this;
        }

        public Criteria andBillingUserIdGreaterThan(Integer value) {
            addCriterion("billing_user_id >", value, "billingUserId");
            return (Criteria) this;
        }

        public Criteria andBillingUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("billing_user_id >=", value, "billingUserId");
            return (Criteria) this;
        }

        public Criteria andBillingUserIdLessThan(Integer value) {
            addCriterion("billing_user_id <", value, "billingUserId");
            return (Criteria) this;
        }

        public Criteria andBillingUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("billing_user_id <=", value, "billingUserId");
            return (Criteria) this;
        }

        public Criteria andBillingUserIdIn(List<Integer> values) {
            addCriterion("billing_user_id in", values, "billingUserId");
            return (Criteria) this;
        }

        public Criteria andBillingUserIdNotIn(List<Integer> values) {
            addCriterion("billing_user_id not in", values, "billingUserId");
            return (Criteria) this;
        }

        public Criteria andBillingUserIdBetween(Integer value1, Integer value2) {
            addCriterion("billing_user_id between", value1, value2, "billingUserId");
            return (Criteria) this;
        }

        public Criteria andBillingUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("billing_user_id not between", value1, value2, "billingUserId");
            return (Criteria) this;
        }

        public Criteria andBankCardIdIsNull() {
            addCriterion("bank_card_id is null");
            return (Criteria) this;
        }

        public Criteria andBankCardIdIsNotNull() {
            addCriterion("bank_card_id is not null");
            return (Criteria) this;
        }

        public Criteria andBankCardIdEqualTo(Integer value) {
            addCriterion("bank_card_id =", value, "bankCardId");
            return (Criteria) this;
        }

        public Criteria andBankCardIdNotEqualTo(Integer value) {
            addCriterion("bank_card_id <>", value, "bankCardId");
            return (Criteria) this;
        }

        public Criteria andBankCardIdGreaterThan(Integer value) {
            addCriterion("bank_card_id >", value, "bankCardId");
            return (Criteria) this;
        }

        public Criteria andBankCardIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bank_card_id >=", value, "bankCardId");
            return (Criteria) this;
        }

        public Criteria andBankCardIdLessThan(Integer value) {
            addCriterion("bank_card_id <", value, "bankCardId");
            return (Criteria) this;
        }

        public Criteria andBankCardIdLessThanOrEqualTo(Integer value) {
            addCriterion("bank_card_id <=", value, "bankCardId");
            return (Criteria) this;
        }

        public Criteria andBankCardIdIn(List<Integer> values) {
            addCriterion("bank_card_id in", values, "bankCardId");
            return (Criteria) this;
        }

        public Criteria andBankCardIdNotIn(List<Integer> values) {
            addCriterion("bank_card_id not in", values, "bankCardId");
            return (Criteria) this;
        }

        public Criteria andBankCardIdBetween(Integer value1, Integer value2) {
            addCriterion("bank_card_id between", value1, value2, "bankCardId");
            return (Criteria) this;
        }

        public Criteria andBankCardIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bank_card_id not between", value1, value2, "bankCardId");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountIsNull() {
            addCriterion("settlement_amount is null");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountIsNotNull() {
            addCriterion("settlement_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountEqualTo(Float value) {
            addCriterion("settlement_amount =", value, "settlementAmount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountNotEqualTo(Float value) {
            addCriterion("settlement_amount <>", value, "settlementAmount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountGreaterThan(Float value) {
            addCriterion("settlement_amount >", value, "settlementAmount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountGreaterThanOrEqualTo(Float value) {
            addCriterion("settlement_amount >=", value, "settlementAmount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountLessThan(Float value) {
            addCriterion("settlement_amount <", value, "settlementAmount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountLessThanOrEqualTo(Float value) {
            addCriterion("settlement_amount <=", value, "settlementAmount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountIn(List<Float> values) {
            addCriterion("settlement_amount in", values, "settlementAmount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountNotIn(List<Float> values) {
            addCriterion("settlement_amount not in", values, "settlementAmount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountBetween(Float value1, Float value2) {
            addCriterion("settlement_amount between", value1, value2, "settlementAmount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountNotBetween(Float value1, Float value2) {
            addCriterion("settlement_amount not between", value1, value2, "settlementAmount");
            return (Criteria) this;
        }

        public Criteria andBillingStatusIsNull() {
            addCriterion("billing_status is null");
            return (Criteria) this;
        }

        public Criteria andBillingStatusIsNotNull() {
            addCriterion("billing_status is not null");
            return (Criteria) this;
        }

        public Criteria andBillingStatusEqualTo(Integer value) {
            addCriterion("billing_status =", value, "billingStatus");
            return (Criteria) this;
        }

        public Criteria andBillingStatusNotEqualTo(Integer value) {
            addCriterion("billing_status <>", value, "billingStatus");
            return (Criteria) this;
        }

        public Criteria andBillingStatusGreaterThan(Integer value) {
            addCriterion("billing_status >", value, "billingStatus");
            return (Criteria) this;
        }

        public Criteria andBillingStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("billing_status >=", value, "billingStatus");
            return (Criteria) this;
        }

        public Criteria andBillingStatusLessThan(Integer value) {
            addCriterion("billing_status <", value, "billingStatus");
            return (Criteria) this;
        }

        public Criteria andBillingStatusLessThanOrEqualTo(Integer value) {
            addCriterion("billing_status <=", value, "billingStatus");
            return (Criteria) this;
        }

        public Criteria andBillingStatusIn(List<Integer> values) {
            addCriterion("billing_status in", values, "billingStatus");
            return (Criteria) this;
        }

        public Criteria andBillingStatusNotIn(List<Integer> values) {
            addCriterion("billing_status not in", values, "billingStatus");
            return (Criteria) this;
        }

        public Criteria andBillingStatusBetween(Integer value1, Integer value2) {
            addCriterion("billing_status between", value1, value2, "billingStatus");
            return (Criteria) this;
        }

        public Criteria andBillingStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("billing_status not between", value1, value2, "billingStatus");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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