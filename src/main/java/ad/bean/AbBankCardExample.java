package ad.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AbBankCardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AbBankCardExample() {
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

        public Criteria andBankCardNumberIsNull() {
            addCriterion("bank_card_number is null");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberIsNotNull() {
            addCriterion("bank_card_number is not null");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberEqualTo(String value) {
            addCriterion("bank_card_number =", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberNotEqualTo(String value) {
            addCriterion("bank_card_number <>", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberGreaterThan(String value) {
            addCriterion("bank_card_number >", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberGreaterThanOrEqualTo(String value) {
            addCriterion("bank_card_number >=", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberLessThan(String value) {
            addCriterion("bank_card_number <", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberLessThanOrEqualTo(String value) {
            addCriterion("bank_card_number <=", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberLike(String value) {
            addCriterion("bank_card_number like", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberNotLike(String value) {
            addCriterion("bank_card_number not like", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberIn(List<String> values) {
            addCriterion("bank_card_number in", values, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberNotIn(List<String> values) {
            addCriterion("bank_card_number not in", values, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberBetween(String value1, String value2) {
            addCriterion("bank_card_number between", value1, value2, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberNotBetween(String value1, String value2) {
            addCriterion("bank_card_number not between", value1, value2, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameIsNull() {
            addCriterion("bank_account_name is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameIsNotNull() {
            addCriterion("bank_account_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameEqualTo(String value) {
            addCriterion("bank_account_name =", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameNotEqualTo(String value) {
            addCriterion("bank_account_name <>", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameGreaterThan(String value) {
            addCriterion("bank_account_name >", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account_name >=", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameLessThan(String value) {
            addCriterion("bank_account_name <", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameLessThanOrEqualTo(String value) {
            addCriterion("bank_account_name <=", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameLike(String value) {
            addCriterion("bank_account_name like", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameNotLike(String value) {
            addCriterion("bank_account_name not like", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameIn(List<String> values) {
            addCriterion("bank_account_name in", values, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameNotIn(List<String> values) {
            addCriterion("bank_account_name not in", values, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameBetween(String value1, String value2) {
            addCriterion("bank_account_name between", value1, value2, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameNotBetween(String value1, String value2) {
            addCriterion("bank_account_name not between", value1, value2, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("bank_name is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bank_name =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bank_name <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bank_name >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_name >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bank_name <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bank_name <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bank_name like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bank_name not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("bank_name in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("bank_name not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bank_name between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bank_name not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankBranchesNameIsNull() {
            addCriterion("bank_branches_name is null");
            return (Criteria) this;
        }

        public Criteria andBankBranchesNameIsNotNull() {
            addCriterion("bank_branches_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankBranchesNameEqualTo(String value) {
            addCriterion("bank_branches_name =", value, "bankBranchesName");
            return (Criteria) this;
        }

        public Criteria andBankBranchesNameNotEqualTo(String value) {
            addCriterion("bank_branches_name <>", value, "bankBranchesName");
            return (Criteria) this;
        }

        public Criteria andBankBranchesNameGreaterThan(String value) {
            addCriterion("bank_branches_name >", value, "bankBranchesName");
            return (Criteria) this;
        }

        public Criteria andBankBranchesNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_branches_name >=", value, "bankBranchesName");
            return (Criteria) this;
        }

        public Criteria andBankBranchesNameLessThan(String value) {
            addCriterion("bank_branches_name <", value, "bankBranchesName");
            return (Criteria) this;
        }

        public Criteria andBankBranchesNameLessThanOrEqualTo(String value) {
            addCriterion("bank_branches_name <=", value, "bankBranchesName");
            return (Criteria) this;
        }

        public Criteria andBankBranchesNameLike(String value) {
            addCriterion("bank_branches_name like", value, "bankBranchesName");
            return (Criteria) this;
        }

        public Criteria andBankBranchesNameNotLike(String value) {
            addCriterion("bank_branches_name not like", value, "bankBranchesName");
            return (Criteria) this;
        }

        public Criteria andBankBranchesNameIn(List<String> values) {
            addCriterion("bank_branches_name in", values, "bankBranchesName");
            return (Criteria) this;
        }

        public Criteria andBankBranchesNameNotIn(List<String> values) {
            addCriterion("bank_branches_name not in", values, "bankBranchesName");
            return (Criteria) this;
        }

        public Criteria andBankBranchesNameBetween(String value1, String value2) {
            addCriterion("bank_branches_name between", value1, value2, "bankBranchesName");
            return (Criteria) this;
        }

        public Criteria andBankBranchesNameNotBetween(String value1, String value2) {
            addCriterion("bank_branches_name not between", value1, value2, "bankBranchesName");
            return (Criteria) this;
        }

        public Criteria andBankReservePhoneIsNull() {
            addCriterion("bank_reserve_phone is null");
            return (Criteria) this;
        }

        public Criteria andBankReservePhoneIsNotNull() {
            addCriterion("bank_reserve_phone is not null");
            return (Criteria) this;
        }

        public Criteria andBankReservePhoneEqualTo(String value) {
            addCriterion("bank_reserve_phone =", value, "bankReservePhone");
            return (Criteria) this;
        }

        public Criteria andBankReservePhoneNotEqualTo(String value) {
            addCriterion("bank_reserve_phone <>", value, "bankReservePhone");
            return (Criteria) this;
        }

        public Criteria andBankReservePhoneGreaterThan(String value) {
            addCriterion("bank_reserve_phone >", value, "bankReservePhone");
            return (Criteria) this;
        }

        public Criteria andBankReservePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("bank_reserve_phone >=", value, "bankReservePhone");
            return (Criteria) this;
        }

        public Criteria andBankReservePhoneLessThan(String value) {
            addCriterion("bank_reserve_phone <", value, "bankReservePhone");
            return (Criteria) this;
        }

        public Criteria andBankReservePhoneLessThanOrEqualTo(String value) {
            addCriterion("bank_reserve_phone <=", value, "bankReservePhone");
            return (Criteria) this;
        }

        public Criteria andBankReservePhoneLike(String value) {
            addCriterion("bank_reserve_phone like", value, "bankReservePhone");
            return (Criteria) this;
        }

        public Criteria andBankReservePhoneNotLike(String value) {
            addCriterion("bank_reserve_phone not like", value, "bankReservePhone");
            return (Criteria) this;
        }

        public Criteria andBankReservePhoneIn(List<String> values) {
            addCriterion("bank_reserve_phone in", values, "bankReservePhone");
            return (Criteria) this;
        }

        public Criteria andBankReservePhoneNotIn(List<String> values) {
            addCriterion("bank_reserve_phone not in", values, "bankReservePhone");
            return (Criteria) this;
        }

        public Criteria andBankReservePhoneBetween(String value1, String value2) {
            addCriterion("bank_reserve_phone between", value1, value2, "bankReservePhone");
            return (Criteria) this;
        }

        public Criteria andBankReservePhoneNotBetween(String value1, String value2) {
            addCriterion("bank_reserve_phone not between", value1, value2, "bankReservePhone");
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