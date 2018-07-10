package ad.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AbBillingCycleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AbBillingCycleExample() {
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

        public Criteria andBillingTypeIsNull() {
            addCriterion("billing_type is null");
            return (Criteria) this;
        }

        public Criteria andBillingTypeIsNotNull() {
            addCriterion("billing_type is not null");
            return (Criteria) this;
        }

        public Criteria andBillingTypeEqualTo(Integer value) {
            addCriterion("billing_type =", value, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeNotEqualTo(Integer value) {
            addCriterion("billing_type <>", value, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeGreaterThan(Integer value) {
            addCriterion("billing_type >", value, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("billing_type >=", value, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeLessThan(Integer value) {
            addCriterion("billing_type <", value, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeLessThanOrEqualTo(Integer value) {
            addCriterion("billing_type <=", value, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeIn(List<Integer> values) {
            addCriterion("billing_type in", values, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeNotIn(List<Integer> values) {
            addCriterion("billing_type not in", values, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeBetween(Integer value1, Integer value2) {
            addCriterion("billing_type between", value1, value2, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("billing_type not between", value1, value2, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingDayIsNull() {
            addCriterion("billing_day is null");
            return (Criteria) this;
        }

        public Criteria andBillingDayIsNotNull() {
            addCriterion("billing_day is not null");
            return (Criteria) this;
        }

        public Criteria andBillingDayEqualTo(Integer value) {
            addCriterion("billing_day =", value, "billingDay");
            return (Criteria) this;
        }

        public Criteria andBillingDayNotEqualTo(Integer value) {
            addCriterion("billing_day <>", value, "billingDay");
            return (Criteria) this;
        }

        public Criteria andBillingDayGreaterThan(Integer value) {
            addCriterion("billing_day >", value, "billingDay");
            return (Criteria) this;
        }

        public Criteria andBillingDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("billing_day >=", value, "billingDay");
            return (Criteria) this;
        }

        public Criteria andBillingDayLessThan(Integer value) {
            addCriterion("billing_day <", value, "billingDay");
            return (Criteria) this;
        }

        public Criteria andBillingDayLessThanOrEqualTo(Integer value) {
            addCriterion("billing_day <=", value, "billingDay");
            return (Criteria) this;
        }

        public Criteria andBillingDayIn(List<Integer> values) {
            addCriterion("billing_day in", values, "billingDay");
            return (Criteria) this;
        }

        public Criteria andBillingDayNotIn(List<Integer> values) {
            addCriterion("billing_day not in", values, "billingDay");
            return (Criteria) this;
        }

        public Criteria andBillingDayBetween(Integer value1, Integer value2) {
            addCriterion("billing_day between", value1, value2, "billingDay");
            return (Criteria) this;
        }

        public Criteria andBillingDayNotBetween(Integer value1, Integer value2) {
            addCriterion("billing_day not between", value1, value2, "billingDay");
            return (Criteria) this;
        }

        public Criteria andSettlementDate1IsNull() {
            addCriterion("settlement_date1 is null");
            return (Criteria) this;
        }

        public Criteria andSettlementDate1IsNotNull() {
            addCriterion("settlement_date1 is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementDate1EqualTo(String value) {
            addCriterion("settlement_date1 =", value, "settlementDate1");
            return (Criteria) this;
        }

        public Criteria andSettlementDate1NotEqualTo(String value) {
            addCriterion("settlement_date1 <>", value, "settlementDate1");
            return (Criteria) this;
        }

        public Criteria andSettlementDate1GreaterThan(String value) {
            addCriterion("settlement_date1 >", value, "settlementDate1");
            return (Criteria) this;
        }

        public Criteria andSettlementDate1GreaterThanOrEqualTo(String value) {
            addCriterion("settlement_date1 >=", value, "settlementDate1");
            return (Criteria) this;
        }

        public Criteria andSettlementDate1LessThan(String value) {
            addCriterion("settlement_date1 <", value, "settlementDate1");
            return (Criteria) this;
        }

        public Criteria andSettlementDate1LessThanOrEqualTo(String value) {
            addCriterion("settlement_date1 <=", value, "settlementDate1");
            return (Criteria) this;
        }

        public Criteria andSettlementDate1Like(String value) {
            addCriterion("settlement_date1 like", value, "settlementDate1");
            return (Criteria) this;
        }

        public Criteria andSettlementDate1NotLike(String value) {
            addCriterion("settlement_date1 not like", value, "settlementDate1");
            return (Criteria) this;
        }

        public Criteria andSettlementDate1In(List<String> values) {
            addCriterion("settlement_date1 in", values, "settlementDate1");
            return (Criteria) this;
        }

        public Criteria andSettlementDate1NotIn(List<String> values) {
            addCriterion("settlement_date1 not in", values, "settlementDate1");
            return (Criteria) this;
        }

        public Criteria andSettlementDate1Between(String value1, String value2) {
            addCriterion("settlement_date1 between", value1, value2, "settlementDate1");
            return (Criteria) this;
        }

        public Criteria andSettlementDate1NotBetween(String value1, String value2) {
            addCriterion("settlement_date1 not between", value1, value2, "settlementDate1");
            return (Criteria) this;
        }

        public Criteria andSettlementDate2IsNull() {
            addCriterion("settlement_date2 is null");
            return (Criteria) this;
        }

        public Criteria andSettlementDate2IsNotNull() {
            addCriterion("settlement_date2 is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementDate2EqualTo(String value) {
            addCriterion("settlement_date2 =", value, "settlementDate2");
            return (Criteria) this;
        }

        public Criteria andSettlementDate2NotEqualTo(String value) {
            addCriterion("settlement_date2 <>", value, "settlementDate2");
            return (Criteria) this;
        }

        public Criteria andSettlementDate2GreaterThan(String value) {
            addCriterion("settlement_date2 >", value, "settlementDate2");
            return (Criteria) this;
        }

        public Criteria andSettlementDate2GreaterThanOrEqualTo(String value) {
            addCriterion("settlement_date2 >=", value, "settlementDate2");
            return (Criteria) this;
        }

        public Criteria andSettlementDate2LessThan(String value) {
            addCriterion("settlement_date2 <", value, "settlementDate2");
            return (Criteria) this;
        }

        public Criteria andSettlementDate2LessThanOrEqualTo(String value) {
            addCriterion("settlement_date2 <=", value, "settlementDate2");
            return (Criteria) this;
        }

        public Criteria andSettlementDate2Like(String value) {
            addCriterion("settlement_date2 like", value, "settlementDate2");
            return (Criteria) this;
        }

        public Criteria andSettlementDate2NotLike(String value) {
            addCriterion("settlement_date2 not like", value, "settlementDate2");
            return (Criteria) this;
        }

        public Criteria andSettlementDate2In(List<String> values) {
            addCriterion("settlement_date2 in", values, "settlementDate2");
            return (Criteria) this;
        }

        public Criteria andSettlementDate2NotIn(List<String> values) {
            addCriterion("settlement_date2 not in", values, "settlementDate2");
            return (Criteria) this;
        }

        public Criteria andSettlementDate2Between(String value1, String value2) {
            addCriterion("settlement_date2 between", value1, value2, "settlementDate2");
            return (Criteria) this;
        }

        public Criteria andSettlementDate2NotBetween(String value1, String value2) {
            addCriterion("settlement_date2 not between", value1, value2, "settlementDate2");
            return (Criteria) this;
        }

        public Criteria andSettlementDate3IsNull() {
            addCriterion("settlement_date3 is null");
            return (Criteria) this;
        }

        public Criteria andSettlementDate3IsNotNull() {
            addCriterion("settlement_date3 is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementDate3EqualTo(String value) {
            addCriterion("settlement_date3 =", value, "settlementDate3");
            return (Criteria) this;
        }

        public Criteria andSettlementDate3NotEqualTo(String value) {
            addCriterion("settlement_date3 <>", value, "settlementDate3");
            return (Criteria) this;
        }

        public Criteria andSettlementDate3GreaterThan(String value) {
            addCriterion("settlement_date3 >", value, "settlementDate3");
            return (Criteria) this;
        }

        public Criteria andSettlementDate3GreaterThanOrEqualTo(String value) {
            addCriterion("settlement_date3 >=", value, "settlementDate3");
            return (Criteria) this;
        }

        public Criteria andSettlementDate3LessThan(String value) {
            addCriterion("settlement_date3 <", value, "settlementDate3");
            return (Criteria) this;
        }

        public Criteria andSettlementDate3LessThanOrEqualTo(String value) {
            addCriterion("settlement_date3 <=", value, "settlementDate3");
            return (Criteria) this;
        }

        public Criteria andSettlementDate3Like(String value) {
            addCriterion("settlement_date3 like", value, "settlementDate3");
            return (Criteria) this;
        }

        public Criteria andSettlementDate3NotLike(String value) {
            addCriterion("settlement_date3 not like", value, "settlementDate3");
            return (Criteria) this;
        }

        public Criteria andSettlementDate3In(List<String> values) {
            addCriterion("settlement_date3 in", values, "settlementDate3");
            return (Criteria) this;
        }

        public Criteria andSettlementDate3NotIn(List<String> values) {
            addCriterion("settlement_date3 not in", values, "settlementDate3");
            return (Criteria) this;
        }

        public Criteria andSettlementDate3Between(String value1, String value2) {
            addCriterion("settlement_date3 between", value1, value2, "settlementDate3");
            return (Criteria) this;
        }

        public Criteria andSettlementDate3NotBetween(String value1, String value2) {
            addCriterion("settlement_date3 not between", value1, value2, "settlementDate3");
            return (Criteria) this;
        }

        public Criteria andSettlementDate4IsNull() {
            addCriterion("settlement_date4 is null");
            return (Criteria) this;
        }

        public Criteria andSettlementDate4IsNotNull() {
            addCriterion("settlement_date4 is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementDate4EqualTo(String value) {
            addCriterion("settlement_date4 =", value, "settlementDate4");
            return (Criteria) this;
        }

        public Criteria andSettlementDate4NotEqualTo(String value) {
            addCriterion("settlement_date4 <>", value, "settlementDate4");
            return (Criteria) this;
        }

        public Criteria andSettlementDate4GreaterThan(String value) {
            addCriterion("settlement_date4 >", value, "settlementDate4");
            return (Criteria) this;
        }

        public Criteria andSettlementDate4GreaterThanOrEqualTo(String value) {
            addCriterion("settlement_date4 >=", value, "settlementDate4");
            return (Criteria) this;
        }

        public Criteria andSettlementDate4LessThan(String value) {
            addCriterion("settlement_date4 <", value, "settlementDate4");
            return (Criteria) this;
        }

        public Criteria andSettlementDate4LessThanOrEqualTo(String value) {
            addCriterion("settlement_date4 <=", value, "settlementDate4");
            return (Criteria) this;
        }

        public Criteria andSettlementDate4Like(String value) {
            addCriterion("settlement_date4 like", value, "settlementDate4");
            return (Criteria) this;
        }

        public Criteria andSettlementDate4NotLike(String value) {
            addCriterion("settlement_date4 not like", value, "settlementDate4");
            return (Criteria) this;
        }

        public Criteria andSettlementDate4In(List<String> values) {
            addCriterion("settlement_date4 in", values, "settlementDate4");
            return (Criteria) this;
        }

        public Criteria andSettlementDate4NotIn(List<String> values) {
            addCriterion("settlement_date4 not in", values, "settlementDate4");
            return (Criteria) this;
        }

        public Criteria andSettlementDate4Between(String value1, String value2) {
            addCriterion("settlement_date4 between", value1, value2, "settlementDate4");
            return (Criteria) this;
        }

        public Criteria andSettlementDate4NotBetween(String value1, String value2) {
            addCriterion("settlement_date4 not between", value1, value2, "settlementDate4");
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