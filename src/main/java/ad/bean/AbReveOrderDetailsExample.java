package ad.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AbReveOrderDetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AbReveOrderDetailsExample() {
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

        public Criteria andSubProxyIdIsNull() {
            addCriterion("sub_proxy_id is null");
            return (Criteria) this;
        }

        public Criteria andSubProxyIdIsNotNull() {
            addCriterion("sub_proxy_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubProxyIdEqualTo(Integer value) {
            addCriterion("sub_proxy_id =", value, "subProxyId");
            return (Criteria) this;
        }

        public Criteria andSubProxyIdNotEqualTo(Integer value) {
            addCriterion("sub_proxy_id <>", value, "subProxyId");
            return (Criteria) this;
        }

        public Criteria andSubProxyIdGreaterThan(Integer value) {
            addCriterion("sub_proxy_id >", value, "subProxyId");
            return (Criteria) this;
        }

        public Criteria andSubProxyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_proxy_id >=", value, "subProxyId");
            return (Criteria) this;
        }

        public Criteria andSubProxyIdLessThan(Integer value) {
            addCriterion("sub_proxy_id <", value, "subProxyId");
            return (Criteria) this;
        }

        public Criteria andSubProxyIdLessThanOrEqualTo(Integer value) {
            addCriterion("sub_proxy_id <=", value, "subProxyId");
            return (Criteria) this;
        }

        public Criteria andSubProxyIdIn(List<Integer> values) {
            addCriterion("sub_proxy_id in", values, "subProxyId");
            return (Criteria) this;
        }

        public Criteria andSubProxyIdNotIn(List<Integer> values) {
            addCriterion("sub_proxy_id not in", values, "subProxyId");
            return (Criteria) this;
        }

        public Criteria andSubProxyIdBetween(Integer value1, Integer value2) {
            addCriterion("sub_proxy_id between", value1, value2, "subProxyId");
            return (Criteria) this;
        }

        public Criteria andSubProxyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sub_proxy_id not between", value1, value2, "subProxyId");
            return (Criteria) this;
        }

        public Criteria andClickUserIdIsNull() {
            addCriterion("click_user_id is null");
            return (Criteria) this;
        }

        public Criteria andClickUserIdIsNotNull() {
            addCriterion("click_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andClickUserIdEqualTo(String value) {
            addCriterion("click_user_id =", value, "clickUserId");
            return (Criteria) this;
        }

        public Criteria andClickUserIdNotEqualTo(String value) {
            addCriterion("click_user_id <>", value, "clickUserId");
            return (Criteria) this;
        }

        public Criteria andClickUserIdGreaterThan(String value) {
            addCriterion("click_user_id >", value, "clickUserId");
            return (Criteria) this;
        }

        public Criteria andClickUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("click_user_id >=", value, "clickUserId");
            return (Criteria) this;
        }

        public Criteria andClickUserIdLessThan(String value) {
            addCriterion("click_user_id <", value, "clickUserId");
            return (Criteria) this;
        }

        public Criteria andClickUserIdLessThanOrEqualTo(String value) {
            addCriterion("click_user_id <=", value, "clickUserId");
            return (Criteria) this;
        }

        public Criteria andClickUserIdLike(String value) {
            addCriterion("click_user_id like", value, "clickUserId");
            return (Criteria) this;
        }

        public Criteria andClickUserIdNotLike(String value) {
            addCriterion("click_user_id not like", value, "clickUserId");
            return (Criteria) this;
        }

        public Criteria andClickUserIdIn(List<String> values) {
            addCriterion("click_user_id in", values, "clickUserId");
            return (Criteria) this;
        }

        public Criteria andClickUserIdNotIn(List<String> values) {
            addCriterion("click_user_id not in", values, "clickUserId");
            return (Criteria) this;
        }

        public Criteria andClickUserIdBetween(String value1, String value2) {
            addCriterion("click_user_id between", value1, value2, "clickUserId");
            return (Criteria) this;
        }

        public Criteria andClickUserIdNotBetween(String value1, String value2) {
            addCriterion("click_user_id not between", value1, value2, "clickUserId");
            return (Criteria) this;
        }

        public Criteria andEarningsAmountIsNull() {
            addCriterion("earnings_amount is null");
            return (Criteria) this;
        }

        public Criteria andEarningsAmountIsNotNull() {
            addCriterion("earnings_amount is not null");
            return (Criteria) this;
        }

        public Criteria andEarningsAmountEqualTo(Float value) {
            addCriterion("earnings_amount =", value, "earningsAmount");
            return (Criteria) this;
        }

        public Criteria andEarningsAmountNotEqualTo(Float value) {
            addCriterion("earnings_amount <>", value, "earningsAmount");
            return (Criteria) this;
        }

        public Criteria andEarningsAmountGreaterThan(Float value) {
            addCriterion("earnings_amount >", value, "earningsAmount");
            return (Criteria) this;
        }

        public Criteria andEarningsAmountGreaterThanOrEqualTo(Float value) {
            addCriterion("earnings_amount >=", value, "earningsAmount");
            return (Criteria) this;
        }

        public Criteria andEarningsAmountLessThan(Float value) {
            addCriterion("earnings_amount <", value, "earningsAmount");
            return (Criteria) this;
        }

        public Criteria andEarningsAmountLessThanOrEqualTo(Float value) {
            addCriterion("earnings_amount <=", value, "earningsAmount");
            return (Criteria) this;
        }

        public Criteria andEarningsAmountIn(List<Float> values) {
            addCriterion("earnings_amount in", values, "earningsAmount");
            return (Criteria) this;
        }

        public Criteria andEarningsAmountNotIn(List<Float> values) {
            addCriterion("earnings_amount not in", values, "earningsAmount");
            return (Criteria) this;
        }

        public Criteria andEarningsAmountBetween(Float value1, Float value2) {
            addCriterion("earnings_amount between", value1, value2, "earningsAmount");
            return (Criteria) this;
        }

        public Criteria andEarningsAmountNotBetween(Float value1, Float value2) {
            addCriterion("earnings_amount not between", value1, value2, "earningsAmount");
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

        public Criteria andAdvertiserIdIsNull() {
            addCriterion("advertiser_id is null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdIsNotNull() {
            addCriterion("advertiser_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdEqualTo(Integer value) {
            addCriterion("advertiser_id =", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdNotEqualTo(Integer value) {
            addCriterion("advertiser_id <>", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdGreaterThan(Integer value) {
            addCriterion("advertiser_id >", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("advertiser_id >=", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdLessThan(Integer value) {
            addCriterion("advertiser_id <", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdLessThanOrEqualTo(Integer value) {
            addCriterion("advertiser_id <=", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdIn(List<Integer> values) {
            addCriterion("advertiser_id in", values, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdNotIn(List<Integer> values) {
            addCriterion("advertiser_id not in", values, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdBetween(Integer value1, Integer value2) {
            addCriterion("advertiser_id between", value1, value2, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("advertiser_id not between", value1, value2, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andBillingMethodIsNull() {
            addCriterion("billing_method is null");
            return (Criteria) this;
        }

        public Criteria andBillingMethodIsNotNull() {
            addCriterion("billing_method is not null");
            return (Criteria) this;
        }

        public Criteria andBillingMethodEqualTo(String value) {
            addCriterion("billing_method =", value, "billingMethod");
            return (Criteria) this;
        }

        public Criteria andBillingMethodNotEqualTo(String value) {
            addCriterion("billing_method <>", value, "billingMethod");
            return (Criteria) this;
        }

        public Criteria andBillingMethodGreaterThan(String value) {
            addCriterion("billing_method >", value, "billingMethod");
            return (Criteria) this;
        }

        public Criteria andBillingMethodGreaterThanOrEqualTo(String value) {
            addCriterion("billing_method >=", value, "billingMethod");
            return (Criteria) this;
        }

        public Criteria andBillingMethodLessThan(String value) {
            addCriterion("billing_method <", value, "billingMethod");
            return (Criteria) this;
        }

        public Criteria andBillingMethodLessThanOrEqualTo(String value) {
            addCriterion("billing_method <=", value, "billingMethod");
            return (Criteria) this;
        }

        public Criteria andBillingMethodLike(String value) {
            addCriterion("billing_method like", value, "billingMethod");
            return (Criteria) this;
        }

        public Criteria andBillingMethodNotLike(String value) {
            addCriterion("billing_method not like", value, "billingMethod");
            return (Criteria) this;
        }

        public Criteria andBillingMethodIn(List<String> values) {
            addCriterion("billing_method in", values, "billingMethod");
            return (Criteria) this;
        }

        public Criteria andBillingMethodNotIn(List<String> values) {
            addCriterion("billing_method not in", values, "billingMethod");
            return (Criteria) this;
        }

        public Criteria andBillingMethodBetween(String value1, String value2) {
            addCriterion("billing_method between", value1, value2, "billingMethod");
            return (Criteria) this;
        }

        public Criteria andBillingMethodNotBetween(String value1, String value2) {
            addCriterion("billing_method not between", value1, value2, "billingMethod");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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

        public Criteria andEquipmentIdIsNull() {
            addCriterion("equipment_id is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIsNotNull() {
            addCriterion("equipment_id is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdEqualTo(String value) {
            addCriterion("equipment_id =", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotEqualTo(String value) {
            addCriterion("equipment_id <>", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThan(String value) {
            addCriterion("equipment_id >", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_id >=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThan(String value) {
            addCriterion("equipment_id <", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThanOrEqualTo(String value) {
            addCriterion("equipment_id <=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLike(String value) {
            addCriterion("equipment_id like", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotLike(String value) {
            addCriterion("equipment_id not like", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIn(List<String> values) {
            addCriterion("equipment_id in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotIn(List<String> values) {
            addCriterion("equipment_id not in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdBetween(String value1, String value2) {
            addCriterion("equipment_id between", value1, value2, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotBetween(String value1, String value2) {
            addCriterion("equipment_id not between", value1, value2, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andAppNameIsNull() {
            addCriterion("app_name is null");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNotNull() {
            addCriterion("app_name is not null");
            return (Criteria) this;
        }

        public Criteria andAppNameEqualTo(String value) {
            addCriterion("app_name =", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotEqualTo(String value) {
            addCriterion("app_name <>", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThan(String value) {
            addCriterion("app_name >", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("app_name >=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThan(String value) {
            addCriterion("app_name <", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThanOrEqualTo(String value) {
            addCriterion("app_name <=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLike(String value) {
            addCriterion("app_name like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotLike(String value) {
            addCriterion("app_name not like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameIn(List<String> values) {
            addCriterion("app_name in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotIn(List<String> values) {
            addCriterion("app_name not in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameBetween(String value1, String value2) {
            addCriterion("app_name between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotBetween(String value1, String value2) {
            addCriterion("app_name not between", value1, value2, "appName");
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