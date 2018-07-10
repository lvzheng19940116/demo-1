package ad.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AbAdvertProxyAssociationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AbAdvertProxyAssociationExample() {
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

        public Criteria andAdverIdIsNull() {
            addCriterion("adver_id is null");
            return (Criteria) this;
        }

        public Criteria andAdverIdIsNotNull() {
            addCriterion("adver_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdverIdEqualTo(Integer value) {
            addCriterion("adver_id =", value, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdNotEqualTo(Integer value) {
            addCriterion("adver_id <>", value, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdGreaterThan(Integer value) {
            addCriterion("adver_id >", value, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("adver_id >=", value, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdLessThan(Integer value) {
            addCriterion("adver_id <", value, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdLessThanOrEqualTo(Integer value) {
            addCriterion("adver_id <=", value, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdIn(List<Integer> values) {
            addCriterion("adver_id in", values, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdNotIn(List<Integer> values) {
            addCriterion("adver_id not in", values, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdBetween(Integer value1, Integer value2) {
            addCriterion("adver_id between", value1, value2, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdNotBetween(Integer value1, Integer value2) {
            addCriterion("adver_id not between", value1, value2, "adverId");
            return (Criteria) this;
        }

        public Criteria andProxyIdIsNull() {
            addCriterion("proxy_id is null");
            return (Criteria) this;
        }

        public Criteria andProxyIdIsNotNull() {
            addCriterion("proxy_id is not null");
            return (Criteria) this;
        }

        public Criteria andProxyIdEqualTo(Integer value) {
            addCriterion("proxy_id =", value, "proxyId");
            return (Criteria) this;
        }

        public Criteria andProxyIdNotEqualTo(Integer value) {
            addCriterion("proxy_id <>", value, "proxyId");
            return (Criteria) this;
        }

        public Criteria andProxyIdGreaterThan(Integer value) {
            addCriterion("proxy_id >", value, "proxyId");
            return (Criteria) this;
        }

        public Criteria andProxyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("proxy_id >=", value, "proxyId");
            return (Criteria) this;
        }

        public Criteria andProxyIdLessThan(Integer value) {
            addCriterion("proxy_id <", value, "proxyId");
            return (Criteria) this;
        }

        public Criteria andProxyIdLessThanOrEqualTo(Integer value) {
            addCriterion("proxy_id <=", value, "proxyId");
            return (Criteria) this;
        }

        public Criteria andProxyIdIn(List<Integer> values) {
            addCriterion("proxy_id in", values, "proxyId");
            return (Criteria) this;
        }

        public Criteria andProxyIdNotIn(List<Integer> values) {
            addCriterion("proxy_id not in", values, "proxyId");
            return (Criteria) this;
        }

        public Criteria andProxyIdBetween(Integer value1, Integer value2) {
            addCriterion("proxy_id between", value1, value2, "proxyId");
            return (Criteria) this;
        }

        public Criteria andProxyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("proxy_id not between", value1, value2, "proxyId");
            return (Criteria) this;
        }

        public Criteria andProxyGradeIsNull() {
            addCriterion("proxy_grade is null");
            return (Criteria) this;
        }

        public Criteria andProxyGradeIsNotNull() {
            addCriterion("proxy_grade is not null");
            return (Criteria) this;
        }

        public Criteria andProxyGradeEqualTo(Integer value) {
            addCriterion("proxy_grade =", value, "proxyGrade");
            return (Criteria) this;
        }

        public Criteria andProxyGradeNotEqualTo(Integer value) {
            addCriterion("proxy_grade <>", value, "proxyGrade");
            return (Criteria) this;
        }

        public Criteria andProxyGradeGreaterThan(Integer value) {
            addCriterion("proxy_grade >", value, "proxyGrade");
            return (Criteria) this;
        }

        public Criteria andProxyGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("proxy_grade >=", value, "proxyGrade");
            return (Criteria) this;
        }

        public Criteria andProxyGradeLessThan(Integer value) {
            addCriterion("proxy_grade <", value, "proxyGrade");
            return (Criteria) this;
        }

        public Criteria andProxyGradeLessThanOrEqualTo(Integer value) {
            addCriterion("proxy_grade <=", value, "proxyGrade");
            return (Criteria) this;
        }

        public Criteria andProxyGradeIn(List<Integer> values) {
            addCriterion("proxy_grade in", values, "proxyGrade");
            return (Criteria) this;
        }

        public Criteria andProxyGradeNotIn(List<Integer> values) {
            addCriterion("proxy_grade not in", values, "proxyGrade");
            return (Criteria) this;
        }

        public Criteria andProxyGradeBetween(Integer value1, Integer value2) {
            addCriterion("proxy_grade between", value1, value2, "proxyGrade");
            return (Criteria) this;
        }

        public Criteria andProxyGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("proxy_grade not between", value1, value2, "proxyGrade");
            return (Criteria) this;
        }

        public Criteria andFatherProxyIdIsNull() {
            addCriterion("father_proxy_id is null");
            return (Criteria) this;
        }

        public Criteria andFatherProxyIdIsNotNull() {
            addCriterion("father_proxy_id is not null");
            return (Criteria) this;
        }

        public Criteria andFatherProxyIdEqualTo(Integer value) {
            addCriterion("father_proxy_id =", value, "fatherProxyId");
            return (Criteria) this;
        }

        public Criteria andFatherProxyIdNotEqualTo(Integer value) {
            addCriterion("father_proxy_id <>", value, "fatherProxyId");
            return (Criteria) this;
        }

        public Criteria andFatherProxyIdGreaterThan(Integer value) {
            addCriterion("father_proxy_id >", value, "fatherProxyId");
            return (Criteria) this;
        }

        public Criteria andFatherProxyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("father_proxy_id >=", value, "fatherProxyId");
            return (Criteria) this;
        }

        public Criteria andFatherProxyIdLessThan(Integer value) {
            addCriterion("father_proxy_id <", value, "fatherProxyId");
            return (Criteria) this;
        }

        public Criteria andFatherProxyIdLessThanOrEqualTo(Integer value) {
            addCriterion("father_proxy_id <=", value, "fatherProxyId");
            return (Criteria) this;
        }

        public Criteria andFatherProxyIdIn(List<Integer> values) {
            addCriterion("father_proxy_id in", values, "fatherProxyId");
            return (Criteria) this;
        }

        public Criteria andFatherProxyIdNotIn(List<Integer> values) {
            addCriterion("father_proxy_id not in", values, "fatherProxyId");
            return (Criteria) this;
        }

        public Criteria andFatherProxyIdBetween(Integer value1, Integer value2) {
            addCriterion("father_proxy_id between", value1, value2, "fatherProxyId");
            return (Criteria) this;
        }

        public Criteria andFatherProxyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("father_proxy_id not between", value1, value2, "fatherProxyId");
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

        public Criteria andDistributionRatioIsNull() {
            addCriterion("distribution_ratio is null");
            return (Criteria) this;
        }

        public Criteria andDistributionRatioIsNotNull() {
            addCriterion("distribution_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andDistributionRatioEqualTo(Float value) {
            addCriterion("distribution_ratio =", value, "distributionRatio");
            return (Criteria) this;
        }

        public Criteria andDistributionRatioNotEqualTo(Float value) {
            addCriterion("distribution_ratio <>", value, "distributionRatio");
            return (Criteria) this;
        }

        public Criteria andDistributionRatioGreaterThan(Float value) {
            addCriterion("distribution_ratio >", value, "distributionRatio");
            return (Criteria) this;
        }

        public Criteria andDistributionRatioGreaterThanOrEqualTo(Float value) {
            addCriterion("distribution_ratio >=", value, "distributionRatio");
            return (Criteria) this;
        }

        public Criteria andDistributionRatioLessThan(Float value) {
            addCriterion("distribution_ratio <", value, "distributionRatio");
            return (Criteria) this;
        }

        public Criteria andDistributionRatioLessThanOrEqualTo(Float value) {
            addCriterion("distribution_ratio <=", value, "distributionRatio");
            return (Criteria) this;
        }

        public Criteria andDistributionRatioIn(List<Float> values) {
            addCriterion("distribution_ratio in", values, "distributionRatio");
            return (Criteria) this;
        }

        public Criteria andDistributionRatioNotIn(List<Float> values) {
            addCriterion("distribution_ratio not in", values, "distributionRatio");
            return (Criteria) this;
        }

        public Criteria andDistributionRatioBetween(Float value1, Float value2) {
            addCriterion("distribution_ratio between", value1, value2, "distributionRatio");
            return (Criteria) this;
        }

        public Criteria andDistributionRatioNotBetween(Float value1, Float value2) {
            addCriterion("distribution_ratio not between", value1, value2, "distributionRatio");
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