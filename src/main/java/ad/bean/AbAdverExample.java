package ad.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AbAdverExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AbAdverExample() {
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

        public Criteria andAdverIdEqualTo(String value) {
            addCriterion("adver_id =", value, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdNotEqualTo(String value) {
            addCriterion("adver_id <>", value, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdGreaterThan(String value) {
            addCriterion("adver_id >", value, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdGreaterThanOrEqualTo(String value) {
            addCriterion("adver_id >=", value, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdLessThan(String value) {
            addCriterion("adver_id <", value, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdLessThanOrEqualTo(String value) {
            addCriterion("adver_id <=", value, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdLike(String value) {
            addCriterion("adver_id like", value, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdNotLike(String value) {
            addCriterion("adver_id not like", value, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdIn(List<String> values) {
            addCriterion("adver_id in", values, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdNotIn(List<String> values) {
            addCriterion("adver_id not in", values, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdBetween(String value1, String value2) {
            addCriterion("adver_id between", value1, value2, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdNotBetween(String value1, String value2) {
            addCriterion("adver_id not between", value1, value2, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverTitleIsNull() {
            addCriterion("adver_title is null");
            return (Criteria) this;
        }

        public Criteria andAdverTitleIsNotNull() {
            addCriterion("adver_title is not null");
            return (Criteria) this;
        }

        public Criteria andAdverTitleEqualTo(String value) {
            addCriterion("adver_title =", value, "adverTitle");
            return (Criteria) this;
        }

        public Criteria andAdverTitleNotEqualTo(String value) {
            addCriterion("adver_title <>", value, "adverTitle");
            return (Criteria) this;
        }

        public Criteria andAdverTitleGreaterThan(String value) {
            addCriterion("adver_title >", value, "adverTitle");
            return (Criteria) this;
        }

        public Criteria andAdverTitleGreaterThanOrEqualTo(String value) {
            addCriterion("adver_title >=", value, "adverTitle");
            return (Criteria) this;
        }

        public Criteria andAdverTitleLessThan(String value) {
            addCriterion("adver_title <", value, "adverTitle");
            return (Criteria) this;
        }

        public Criteria andAdverTitleLessThanOrEqualTo(String value) {
            addCriterion("adver_title <=", value, "adverTitle");
            return (Criteria) this;
        }

        public Criteria andAdverTitleLike(String value) {
            addCriterion("adver_title like", value, "adverTitle");
            return (Criteria) this;
        }

        public Criteria andAdverTitleNotLike(String value) {
            addCriterion("adver_title not like", value, "adverTitle");
            return (Criteria) this;
        }

        public Criteria andAdverTitleIn(List<String> values) {
            addCriterion("adver_title in", values, "adverTitle");
            return (Criteria) this;
        }

        public Criteria andAdverTitleNotIn(List<String> values) {
            addCriterion("adver_title not in", values, "adverTitle");
            return (Criteria) this;
        }

        public Criteria andAdverTitleBetween(String value1, String value2) {
            addCriterion("adver_title between", value1, value2, "adverTitle");
            return (Criteria) this;
        }

        public Criteria andAdverTitleNotBetween(String value1, String value2) {
            addCriterion("adver_title not between", value1, value2, "adverTitle");
            return (Criteria) this;
        }

        public Criteria andAdverStatusIsNull() {
            addCriterion("adver_status is null");
            return (Criteria) this;
        }

        public Criteria andAdverStatusIsNotNull() {
            addCriterion("adver_status is not null");
            return (Criteria) this;
        }

        public Criteria andAdverStatusEqualTo(Integer value) {
            addCriterion("adver_status =", value, "adverStatus");
            return (Criteria) this;
        }

        public Criteria andAdverStatusNotEqualTo(Integer value) {
            addCriterion("adver_status <>", value, "adverStatus");
            return (Criteria) this;
        }

        public Criteria andAdverStatusGreaterThan(Integer value) {
            addCriterion("adver_status >", value, "adverStatus");
            return (Criteria) this;
        }

        public Criteria andAdverStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("adver_status >=", value, "adverStatus");
            return (Criteria) this;
        }

        public Criteria andAdverStatusLessThan(Integer value) {
            addCriterion("adver_status <", value, "adverStatus");
            return (Criteria) this;
        }

        public Criteria andAdverStatusLessThanOrEqualTo(Integer value) {
            addCriterion("adver_status <=", value, "adverStatus");
            return (Criteria) this;
        }

        public Criteria andAdverStatusIn(List<Integer> values) {
            addCriterion("adver_status in", values, "adverStatus");
            return (Criteria) this;
        }

        public Criteria andAdverStatusNotIn(List<Integer> values) {
            addCriterion("adver_status not in", values, "adverStatus");
            return (Criteria) this;
        }

        public Criteria andAdverStatusBetween(Integer value1, Integer value2) {
            addCriterion("adver_status between", value1, value2, "adverStatus");
            return (Criteria) this;
        }

        public Criteria andAdverStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("adver_status not between", value1, value2, "adverStatus");
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

        public Criteria andAdvertiserIdEqualTo(String value) {
            addCriterion("advertiser_id =", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdNotEqualTo(String value) {
            addCriterion("advertiser_id <>", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdGreaterThan(String value) {
            addCriterion("advertiser_id >", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdGreaterThanOrEqualTo(String value) {
            addCriterion("advertiser_id >=", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdLessThan(String value) {
            addCriterion("advertiser_id <", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdLessThanOrEqualTo(String value) {
            addCriterion("advertiser_id <=", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdLike(String value) {
            addCriterion("advertiser_id like", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdNotLike(String value) {
            addCriterion("advertiser_id not like", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdIn(List<String> values) {
            addCriterion("advertiser_id in", values, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdNotIn(List<String> values) {
            addCriterion("advertiser_id not in", values, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdBetween(String value1, String value2) {
            addCriterion("advertiser_id between", value1, value2, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdNotBetween(String value1, String value2) {
            addCriterion("advertiser_id not between", value1, value2, "advertiserId");
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

        public Criteria andAdverPositionIsNull() {
            addCriterion("adver_position is null");
            return (Criteria) this;
        }

        public Criteria andAdverPositionIsNotNull() {
            addCriterion("adver_position is not null");
            return (Criteria) this;
        }

        public Criteria andAdverPositionEqualTo(Integer value) {
            addCriterion("adver_position =", value, "adverPosition");
            return (Criteria) this;
        }

        public Criteria andAdverPositionNotEqualTo(Integer value) {
            addCriterion("adver_position <>", value, "adverPosition");
            return (Criteria) this;
        }

        public Criteria andAdverPositionGreaterThan(Integer value) {
            addCriterion("adver_position >", value, "adverPosition");
            return (Criteria) this;
        }

        public Criteria andAdverPositionGreaterThanOrEqualTo(Integer value) {
            addCriterion("adver_position >=", value, "adverPosition");
            return (Criteria) this;
        }

        public Criteria andAdverPositionLessThan(Integer value) {
            addCriterion("adver_position <", value, "adverPosition");
            return (Criteria) this;
        }

        public Criteria andAdverPositionLessThanOrEqualTo(Integer value) {
            addCriterion("adver_position <=", value, "adverPosition");
            return (Criteria) this;
        }

        public Criteria andAdverPositionIn(List<Integer> values) {
            addCriterion("adver_position in", values, "adverPosition");
            return (Criteria) this;
        }

        public Criteria andAdverPositionNotIn(List<Integer> values) {
            addCriterion("adver_position not in", values, "adverPosition");
            return (Criteria) this;
        }

        public Criteria andAdverPositionBetween(Integer value1, Integer value2) {
            addCriterion("adver_position between", value1, value2, "adverPosition");
            return (Criteria) this;
        }

        public Criteria andAdverPositionNotBetween(Integer value1, Integer value2) {
            addCriterion("adver_position not between", value1, value2, "adverPosition");
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

        public Criteria andTotalAdverPriceIsNull() {
            addCriterion("total_adver_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalAdverPriceIsNotNull() {
            addCriterion("total_adver_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAdverPriceEqualTo(Float value) {
            addCriterion("total_adver_price =", value, "totalAdverPrice");
            return (Criteria) this;
        }

        public Criteria andTotalAdverPriceNotEqualTo(Float value) {
            addCriterion("total_adver_price <>", value, "totalAdverPrice");
            return (Criteria) this;
        }

        public Criteria andTotalAdverPriceGreaterThan(Float value) {
            addCriterion("total_adver_price >", value, "totalAdverPrice");
            return (Criteria) this;
        }

        public Criteria andTotalAdverPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("total_adver_price >=", value, "totalAdverPrice");
            return (Criteria) this;
        }

        public Criteria andTotalAdverPriceLessThan(Float value) {
            addCriterion("total_adver_price <", value, "totalAdverPrice");
            return (Criteria) this;
        }

        public Criteria andTotalAdverPriceLessThanOrEqualTo(Float value) {
            addCriterion("total_adver_price <=", value, "totalAdverPrice");
            return (Criteria) this;
        }

        public Criteria andTotalAdverPriceIn(List<Float> values) {
            addCriterion("total_adver_price in", values, "totalAdverPrice");
            return (Criteria) this;
        }

        public Criteria andTotalAdverPriceNotIn(List<Float> values) {
            addCriterion("total_adver_price not in", values, "totalAdverPrice");
            return (Criteria) this;
        }

        public Criteria andTotalAdverPriceBetween(Float value1, Float value2) {
            addCriterion("total_adver_price between", value1, value2, "totalAdverPrice");
            return (Criteria) this;
        }

        public Criteria andTotalAdverPriceNotBetween(Float value1, Float value2) {
            addCriterion("total_adver_price not between", value1, value2, "totalAdverPrice");
            return (Criteria) this;
        }

        public Criteria andAdUnitPriceIsNull() {
            addCriterion("ad_unit_price is null");
            return (Criteria) this;
        }

        public Criteria andAdUnitPriceIsNotNull() {
            addCriterion("ad_unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andAdUnitPriceEqualTo(Float value) {
            addCriterion("ad_unit_price =", value, "adUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAdUnitPriceNotEqualTo(Float value) {
            addCriterion("ad_unit_price <>", value, "adUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAdUnitPriceGreaterThan(Float value) {
            addCriterion("ad_unit_price >", value, "adUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAdUnitPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("ad_unit_price >=", value, "adUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAdUnitPriceLessThan(Float value) {
            addCriterion("ad_unit_price <", value, "adUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAdUnitPriceLessThanOrEqualTo(Float value) {
            addCriterion("ad_unit_price <=", value, "adUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAdUnitPriceIn(List<Float> values) {
            addCriterion("ad_unit_price in", values, "adUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAdUnitPriceNotIn(List<Float> values) {
            addCriterion("ad_unit_price not in", values, "adUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAdUnitPriceBetween(Float value1, Float value2) {
            addCriterion("ad_unit_price between", value1, value2, "adUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAdUnitPriceNotBetween(Float value1, Float value2) {
            addCriterion("ad_unit_price not between", value1, value2, "adUnitPrice");
            return (Criteria) this;
        }

        public Criteria andNumberClicksIsNull() {
            addCriterion("number_clicks is null");
            return (Criteria) this;
        }

        public Criteria andNumberClicksIsNotNull() {
            addCriterion("number_clicks is not null");
            return (Criteria) this;
        }

        public Criteria andNumberClicksEqualTo(Long value) {
            addCriterion("number_clicks =", value, "numberClicks");
            return (Criteria) this;
        }

        public Criteria andNumberClicksNotEqualTo(Long value) {
            addCriterion("number_clicks <>", value, "numberClicks");
            return (Criteria) this;
        }

        public Criteria andNumberClicksGreaterThan(Long value) {
            addCriterion("number_clicks >", value, "numberClicks");
            return (Criteria) this;
        }

        public Criteria andNumberClicksGreaterThanOrEqualTo(Long value) {
            addCriterion("number_clicks >=", value, "numberClicks");
            return (Criteria) this;
        }

        public Criteria andNumberClicksLessThan(Long value) {
            addCriterion("number_clicks <", value, "numberClicks");
            return (Criteria) this;
        }

        public Criteria andNumberClicksLessThanOrEqualTo(Long value) {
            addCriterion("number_clicks <=", value, "numberClicks");
            return (Criteria) this;
        }

        public Criteria andNumberClicksIn(List<Long> values) {
            addCriterion("number_clicks in", values, "numberClicks");
            return (Criteria) this;
        }

        public Criteria andNumberClicksNotIn(List<Long> values) {
            addCriterion("number_clicks not in", values, "numberClicks");
            return (Criteria) this;
        }

        public Criteria andNumberClicksBetween(Long value1, Long value2) {
            addCriterion("number_clicks between", value1, value2, "numberClicks");
            return (Criteria) this;
        }

        public Criteria andNumberClicksNotBetween(Long value1, Long value2) {
            addCriterion("number_clicks not between", value1, value2, "numberClicks");
            return (Criteria) this;
        }

        public Criteria andImpressionsIsNull() {
            addCriterion("impressions is null");
            return (Criteria) this;
        }

        public Criteria andImpressionsIsNotNull() {
            addCriterion("impressions is not null");
            return (Criteria) this;
        }

        public Criteria andImpressionsEqualTo(Long value) {
            addCriterion("impressions =", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsNotEqualTo(Long value) {
            addCriterion("impressions <>", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsGreaterThan(Long value) {
            addCriterion("impressions >", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsGreaterThanOrEqualTo(Long value) {
            addCriterion("impressions >=", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsLessThan(Long value) {
            addCriterion("impressions <", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsLessThanOrEqualTo(Long value) {
            addCriterion("impressions <=", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsIn(List<Long> values) {
            addCriterion("impressions in", values, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsNotIn(List<Long> values) {
            addCriterion("impressions not in", values, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsBetween(Long value1, Long value2) {
            addCriterion("impressions between", value1, value2, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsNotBetween(Long value1, Long value2) {
            addCriterion("impressions not between", value1, value2, "impressions");
            return (Criteria) this;
        }

        public Criteria andDividedPropIsNull() {
            addCriterion("divided_prop is null");
            return (Criteria) this;
        }

        public Criteria andDividedPropIsNotNull() {
            addCriterion("divided_prop is not null");
            return (Criteria) this;
        }

        public Criteria andDividedPropEqualTo(Float value) {
            addCriterion("divided_prop =", value, "dividedProp");
            return (Criteria) this;
        }

        public Criteria andDividedPropNotEqualTo(Float value) {
            addCriterion("divided_prop <>", value, "dividedProp");
            return (Criteria) this;
        }

        public Criteria andDividedPropGreaterThan(Float value) {
            addCriterion("divided_prop >", value, "dividedProp");
            return (Criteria) this;
        }

        public Criteria andDividedPropGreaterThanOrEqualTo(Float value) {
            addCriterion("divided_prop >=", value, "dividedProp");
            return (Criteria) this;
        }

        public Criteria andDividedPropLessThan(Float value) {
            addCriterion("divided_prop <", value, "dividedProp");
            return (Criteria) this;
        }

        public Criteria andDividedPropLessThanOrEqualTo(Float value) {
            addCriterion("divided_prop <=", value, "dividedProp");
            return (Criteria) this;
        }

        public Criteria andDividedPropIn(List<Float> values) {
            addCriterion("divided_prop in", values, "dividedProp");
            return (Criteria) this;
        }

        public Criteria andDividedPropNotIn(List<Float> values) {
            addCriterion("divided_prop not in", values, "dividedProp");
            return (Criteria) this;
        }

        public Criteria andDividedPropBetween(Float value1, Float value2) {
            addCriterion("divided_prop between", value1, value2, "dividedProp");
            return (Criteria) this;
        }

        public Criteria andDividedPropNotBetween(Float value1, Float value2) {
            addCriterion("divided_prop not between", value1, value2, "dividedProp");
            return (Criteria) this;
        }

        public Criteria andAdverTypeIsNull() {
            addCriterion("adver_type is null");
            return (Criteria) this;
        }

        public Criteria andAdverTypeIsNotNull() {
            addCriterion("adver_type is not null");
            return (Criteria) this;
        }

        public Criteria andAdverTypeEqualTo(String value) {
            addCriterion("adver_type =", value, "adverType");
            return (Criteria) this;
        }

        public Criteria andAdverTypeNotEqualTo(String value) {
            addCriterion("adver_type <>", value, "adverType");
            return (Criteria) this;
        }

        public Criteria andAdverTypeGreaterThan(String value) {
            addCriterion("adver_type >", value, "adverType");
            return (Criteria) this;
        }

        public Criteria andAdverTypeGreaterThanOrEqualTo(String value) {
            addCriterion("adver_type >=", value, "adverType");
            return (Criteria) this;
        }

        public Criteria andAdverTypeLessThan(String value) {
            addCriterion("adver_type <", value, "adverType");
            return (Criteria) this;
        }

        public Criteria andAdverTypeLessThanOrEqualTo(String value) {
            addCriterion("adver_type <=", value, "adverType");
            return (Criteria) this;
        }

        public Criteria andAdverTypeLike(String value) {
            addCriterion("adver_type like", value, "adverType");
            return (Criteria) this;
        }

        public Criteria andAdverTypeNotLike(String value) {
            addCriterion("adver_type not like", value, "adverType");
            return (Criteria) this;
        }

        public Criteria andAdverTypeIn(List<String> values) {
            addCriterion("adver_type in", values, "adverType");
            return (Criteria) this;
        }

        public Criteria andAdverTypeNotIn(List<String> values) {
            addCriterion("adver_type not in", values, "adverType");
            return (Criteria) this;
        }

        public Criteria andAdverTypeBetween(String value1, String value2) {
            addCriterion("adver_type between", value1, value2, "adverType");
            return (Criteria) this;
        }

        public Criteria andAdverTypeNotBetween(String value1, String value2) {
            addCriterion("adver_type not between", value1, value2, "adverType");
            return (Criteria) this;
        }

        public Criteria andAdverFile1UrlIsNull() {
            addCriterion("adver_file1_url is null");
            return (Criteria) this;
        }

        public Criteria andAdverFile1UrlIsNotNull() {
            addCriterion("adver_file1_url is not null");
            return (Criteria) this;
        }

        public Criteria andAdverFile1UrlEqualTo(String value) {
            addCriterion("adver_file1_url =", value, "adverFile1Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile1UrlNotEqualTo(String value) {
            addCriterion("adver_file1_url <>", value, "adverFile1Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile1UrlGreaterThan(String value) {
            addCriterion("adver_file1_url >", value, "adverFile1Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile1UrlGreaterThanOrEqualTo(String value) {
            addCriterion("adver_file1_url >=", value, "adverFile1Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile1UrlLessThan(String value) {
            addCriterion("adver_file1_url <", value, "adverFile1Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile1UrlLessThanOrEqualTo(String value) {
            addCriterion("adver_file1_url <=", value, "adverFile1Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile1UrlLike(String value) {
            addCriterion("adver_file1_url like", value, "adverFile1Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile1UrlNotLike(String value) {
            addCriterion("adver_file1_url not like", value, "adverFile1Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile1UrlIn(List<String> values) {
            addCriterion("adver_file1_url in", values, "adverFile1Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile1UrlNotIn(List<String> values) {
            addCriterion("adver_file1_url not in", values, "adverFile1Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile1UrlBetween(String value1, String value2) {
            addCriterion("adver_file1_url between", value1, value2, "adverFile1Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile1UrlNotBetween(String value1, String value2) {
            addCriterion("adver_file1_url not between", value1, value2, "adverFile1Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile2UrlIsNull() {
            addCriterion("adver_file2_url is null");
            return (Criteria) this;
        }

        public Criteria andAdverFile2UrlIsNotNull() {
            addCriterion("adver_file2_url is not null");
            return (Criteria) this;
        }

        public Criteria andAdverFile2UrlEqualTo(String value) {
            addCriterion("adver_file2_url =", value, "adverFile2Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile2UrlNotEqualTo(String value) {
            addCriterion("adver_file2_url <>", value, "adverFile2Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile2UrlGreaterThan(String value) {
            addCriterion("adver_file2_url >", value, "adverFile2Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile2UrlGreaterThanOrEqualTo(String value) {
            addCriterion("adver_file2_url >=", value, "adverFile2Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile2UrlLessThan(String value) {
            addCriterion("adver_file2_url <", value, "adverFile2Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile2UrlLessThanOrEqualTo(String value) {
            addCriterion("adver_file2_url <=", value, "adverFile2Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile2UrlLike(String value) {
            addCriterion("adver_file2_url like", value, "adverFile2Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile2UrlNotLike(String value) {
            addCriterion("adver_file2_url not like", value, "adverFile2Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile2UrlIn(List<String> values) {
            addCriterion("adver_file2_url in", values, "adverFile2Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile2UrlNotIn(List<String> values) {
            addCriterion("adver_file2_url not in", values, "adverFile2Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile2UrlBetween(String value1, String value2) {
            addCriterion("adver_file2_url between", value1, value2, "adverFile2Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile2UrlNotBetween(String value1, String value2) {
            addCriterion("adver_file2_url not between", value1, value2, "adverFile2Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile3UrlIsNull() {
            addCriterion("adver_file3_url is null");
            return (Criteria) this;
        }

        public Criteria andAdverFile3UrlIsNotNull() {
            addCriterion("adver_file3_url is not null");
            return (Criteria) this;
        }

        public Criteria andAdverFile3UrlEqualTo(String value) {
            addCriterion("adver_file3_url =", value, "adverFile3Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile3UrlNotEqualTo(String value) {
            addCriterion("adver_file3_url <>", value, "adverFile3Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile3UrlGreaterThan(String value) {
            addCriterion("adver_file3_url >", value, "adverFile3Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile3UrlGreaterThanOrEqualTo(String value) {
            addCriterion("adver_file3_url >=", value, "adverFile3Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile3UrlLessThan(String value) {
            addCriterion("adver_file3_url <", value, "adverFile3Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile3UrlLessThanOrEqualTo(String value) {
            addCriterion("adver_file3_url <=", value, "adverFile3Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile3UrlLike(String value) {
            addCriterion("adver_file3_url like", value, "adverFile3Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile3UrlNotLike(String value) {
            addCriterion("adver_file3_url not like", value, "adverFile3Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile3UrlIn(List<String> values) {
            addCriterion("adver_file3_url in", values, "adverFile3Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile3UrlNotIn(List<String> values) {
            addCriterion("adver_file3_url not in", values, "adverFile3Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile3UrlBetween(String value1, String value2) {
            addCriterion("adver_file3_url between", value1, value2, "adverFile3Url");
            return (Criteria) this;
        }

        public Criteria andAdverFile3UrlNotBetween(String value1, String value2) {
            addCriterion("adver_file3_url not between", value1, value2, "adverFile3Url");
            return (Criteria) this;
        }

        public Criteria andImgResolution1IsNull() {
            addCriterion("img_resolution_1 is null");
            return (Criteria) this;
        }

        public Criteria andImgResolution1IsNotNull() {
            addCriterion("img_resolution_1 is not null");
            return (Criteria) this;
        }

        public Criteria andImgResolution1EqualTo(String value) {
            addCriterion("img_resolution_1 =", value, "imgResolution1");
            return (Criteria) this;
        }

        public Criteria andImgResolution1NotEqualTo(String value) {
            addCriterion("img_resolution_1 <>", value, "imgResolution1");
            return (Criteria) this;
        }

        public Criteria andImgResolution1GreaterThan(String value) {
            addCriterion("img_resolution_1 >", value, "imgResolution1");
            return (Criteria) this;
        }

        public Criteria andImgResolution1GreaterThanOrEqualTo(String value) {
            addCriterion("img_resolution_1 >=", value, "imgResolution1");
            return (Criteria) this;
        }

        public Criteria andImgResolution1LessThan(String value) {
            addCriterion("img_resolution_1 <", value, "imgResolution1");
            return (Criteria) this;
        }

        public Criteria andImgResolution1LessThanOrEqualTo(String value) {
            addCriterion("img_resolution_1 <=", value, "imgResolution1");
            return (Criteria) this;
        }

        public Criteria andImgResolution1Like(String value) {
            addCriterion("img_resolution_1 like", value, "imgResolution1");
            return (Criteria) this;
        }

        public Criteria andImgResolution1NotLike(String value) {
            addCriterion("img_resolution_1 not like", value, "imgResolution1");
            return (Criteria) this;
        }

        public Criteria andImgResolution1In(List<String> values) {
            addCriterion("img_resolution_1 in", values, "imgResolution1");
            return (Criteria) this;
        }

        public Criteria andImgResolution1NotIn(List<String> values) {
            addCriterion("img_resolution_1 not in", values, "imgResolution1");
            return (Criteria) this;
        }

        public Criteria andImgResolution1Between(String value1, String value2) {
            addCriterion("img_resolution_1 between", value1, value2, "imgResolution1");
            return (Criteria) this;
        }

        public Criteria andImgResolution1NotBetween(String value1, String value2) {
            addCriterion("img_resolution_1 not between", value1, value2, "imgResolution1");
            return (Criteria) this;
        }

        public Criteria andImgResolution2IsNull() {
            addCriterion("img_resolution_2 is null");
            return (Criteria) this;
        }

        public Criteria andImgResolution2IsNotNull() {
            addCriterion("img_resolution_2 is not null");
            return (Criteria) this;
        }

        public Criteria andImgResolution2EqualTo(String value) {
            addCriterion("img_resolution_2 =", value, "imgResolution2");
            return (Criteria) this;
        }

        public Criteria andImgResolution2NotEqualTo(String value) {
            addCriterion("img_resolution_2 <>", value, "imgResolution2");
            return (Criteria) this;
        }

        public Criteria andImgResolution2GreaterThan(String value) {
            addCriterion("img_resolution_2 >", value, "imgResolution2");
            return (Criteria) this;
        }

        public Criteria andImgResolution2GreaterThanOrEqualTo(String value) {
            addCriterion("img_resolution_2 >=", value, "imgResolution2");
            return (Criteria) this;
        }

        public Criteria andImgResolution2LessThan(String value) {
            addCriterion("img_resolution_2 <", value, "imgResolution2");
            return (Criteria) this;
        }

        public Criteria andImgResolution2LessThanOrEqualTo(String value) {
            addCriterion("img_resolution_2 <=", value, "imgResolution2");
            return (Criteria) this;
        }

        public Criteria andImgResolution2Like(String value) {
            addCriterion("img_resolution_2 like", value, "imgResolution2");
            return (Criteria) this;
        }

        public Criteria andImgResolution2NotLike(String value) {
            addCriterion("img_resolution_2 not like", value, "imgResolution2");
            return (Criteria) this;
        }

        public Criteria andImgResolution2In(List<String> values) {
            addCriterion("img_resolution_2 in", values, "imgResolution2");
            return (Criteria) this;
        }

        public Criteria andImgResolution2NotIn(List<String> values) {
            addCriterion("img_resolution_2 not in", values, "imgResolution2");
            return (Criteria) this;
        }

        public Criteria andImgResolution2Between(String value1, String value2) {
            addCriterion("img_resolution_2 between", value1, value2, "imgResolution2");
            return (Criteria) this;
        }

        public Criteria andImgResolution2NotBetween(String value1, String value2) {
            addCriterion("img_resolution_2 not between", value1, value2, "imgResolution2");
            return (Criteria) this;
        }

        public Criteria andImgResolution3IsNull() {
            addCriterion("img_resolution_3 is null");
            return (Criteria) this;
        }

        public Criteria andImgResolution3IsNotNull() {
            addCriterion("img_resolution_3 is not null");
            return (Criteria) this;
        }

        public Criteria andImgResolution3EqualTo(String value) {
            addCriterion("img_resolution_3 =", value, "imgResolution3");
            return (Criteria) this;
        }

        public Criteria andImgResolution3NotEqualTo(String value) {
            addCriterion("img_resolution_3 <>", value, "imgResolution3");
            return (Criteria) this;
        }

        public Criteria andImgResolution3GreaterThan(String value) {
            addCriterion("img_resolution_3 >", value, "imgResolution3");
            return (Criteria) this;
        }

        public Criteria andImgResolution3GreaterThanOrEqualTo(String value) {
            addCriterion("img_resolution_3 >=", value, "imgResolution3");
            return (Criteria) this;
        }

        public Criteria andImgResolution3LessThan(String value) {
            addCriterion("img_resolution_3 <", value, "imgResolution3");
            return (Criteria) this;
        }

        public Criteria andImgResolution3LessThanOrEqualTo(String value) {
            addCriterion("img_resolution_3 <=", value, "imgResolution3");
            return (Criteria) this;
        }

        public Criteria andImgResolution3Like(String value) {
            addCriterion("img_resolution_3 like", value, "imgResolution3");
            return (Criteria) this;
        }

        public Criteria andImgResolution3NotLike(String value) {
            addCriterion("img_resolution_3 not like", value, "imgResolution3");
            return (Criteria) this;
        }

        public Criteria andImgResolution3In(List<String> values) {
            addCriterion("img_resolution_3 in", values, "imgResolution3");
            return (Criteria) this;
        }

        public Criteria andImgResolution3NotIn(List<String> values) {
            addCriterion("img_resolution_3 not in", values, "imgResolution3");
            return (Criteria) this;
        }

        public Criteria andImgResolution3Between(String value1, String value2) {
            addCriterion("img_resolution_3 between", value1, value2, "imgResolution3");
            return (Criteria) this;
        }

        public Criteria andImgResolution3NotBetween(String value1, String value2) {
            addCriterion("img_resolution_3 not between", value1, value2, "imgResolution3");
            return (Criteria) this;
        }

        public Criteria andJumpLinkIsNull() {
            addCriterion("jump_link is null");
            return (Criteria) this;
        }

        public Criteria andJumpLinkIsNotNull() {
            addCriterion("jump_link is not null");
            return (Criteria) this;
        }

        public Criteria andJumpLinkEqualTo(String value) {
            addCriterion("jump_link =", value, "jumpLink");
            return (Criteria) this;
        }

        public Criteria andJumpLinkNotEqualTo(String value) {
            addCriterion("jump_link <>", value, "jumpLink");
            return (Criteria) this;
        }

        public Criteria andJumpLinkGreaterThan(String value) {
            addCriterion("jump_link >", value, "jumpLink");
            return (Criteria) this;
        }

        public Criteria andJumpLinkGreaterThanOrEqualTo(String value) {
            addCriterion("jump_link >=", value, "jumpLink");
            return (Criteria) this;
        }

        public Criteria andJumpLinkLessThan(String value) {
            addCriterion("jump_link <", value, "jumpLink");
            return (Criteria) this;
        }

        public Criteria andJumpLinkLessThanOrEqualTo(String value) {
            addCriterion("jump_link <=", value, "jumpLink");
            return (Criteria) this;
        }

        public Criteria andJumpLinkLike(String value) {
            addCriterion("jump_link like", value, "jumpLink");
            return (Criteria) this;
        }

        public Criteria andJumpLinkNotLike(String value) {
            addCriterion("jump_link not like", value, "jumpLink");
            return (Criteria) this;
        }

        public Criteria andJumpLinkIn(List<String> values) {
            addCriterion("jump_link in", values, "jumpLink");
            return (Criteria) this;
        }

        public Criteria andJumpLinkNotIn(List<String> values) {
            addCriterion("jump_link not in", values, "jumpLink");
            return (Criteria) this;
        }

        public Criteria andJumpLinkBetween(String value1, String value2) {
            addCriterion("jump_link between", value1, value2, "jumpLink");
            return (Criteria) this;
        }

        public Criteria andJumpLinkNotBetween(String value1, String value2) {
            addCriterion("jump_link not between", value1, value2, "jumpLink");
            return (Criteria) this;
        }

        public Criteria andThirdMonitorIsNull() {
            addCriterion("third_monitor is null");
            return (Criteria) this;
        }

        public Criteria andThirdMonitorIsNotNull() {
            addCriterion("third_monitor is not null");
            return (Criteria) this;
        }

        public Criteria andThirdMonitorEqualTo(String value) {
            addCriterion("third_monitor =", value, "thirdMonitor");
            return (Criteria) this;
        }

        public Criteria andThirdMonitorNotEqualTo(String value) {
            addCriterion("third_monitor <>", value, "thirdMonitor");
            return (Criteria) this;
        }

        public Criteria andThirdMonitorGreaterThan(String value) {
            addCriterion("third_monitor >", value, "thirdMonitor");
            return (Criteria) this;
        }

        public Criteria andThirdMonitorGreaterThanOrEqualTo(String value) {
            addCriterion("third_monitor >=", value, "thirdMonitor");
            return (Criteria) this;
        }

        public Criteria andThirdMonitorLessThan(String value) {
            addCriterion("third_monitor <", value, "thirdMonitor");
            return (Criteria) this;
        }

        public Criteria andThirdMonitorLessThanOrEqualTo(String value) {
            addCriterion("third_monitor <=", value, "thirdMonitor");
            return (Criteria) this;
        }

        public Criteria andThirdMonitorLike(String value) {
            addCriterion("third_monitor like", value, "thirdMonitor");
            return (Criteria) this;
        }

        public Criteria andThirdMonitorNotLike(String value) {
            addCriterion("third_monitor not like", value, "thirdMonitor");
            return (Criteria) this;
        }

        public Criteria andThirdMonitorIn(List<String> values) {
            addCriterion("third_monitor in", values, "thirdMonitor");
            return (Criteria) this;
        }

        public Criteria andThirdMonitorNotIn(List<String> values) {
            addCriterion("third_monitor not in", values, "thirdMonitor");
            return (Criteria) this;
        }

        public Criteria andThirdMonitorBetween(String value1, String value2) {
            addCriterion("third_monitor between", value1, value2, "thirdMonitor");
            return (Criteria) this;
        }

        public Criteria andThirdMonitorNotBetween(String value1, String value2) {
            addCriterion("third_monitor not between", value1, value2, "thirdMonitor");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andAuditReasonsIsNull() {
            addCriterion("audit_reasons is null");
            return (Criteria) this;
        }

        public Criteria andAuditReasonsIsNotNull() {
            addCriterion("audit_reasons is not null");
            return (Criteria) this;
        }

        public Criteria andAuditReasonsEqualTo(String value) {
            addCriterion("audit_reasons =", value, "auditReasons");
            return (Criteria) this;
        }

        public Criteria andAuditReasonsNotEqualTo(String value) {
            addCriterion("audit_reasons <>", value, "auditReasons");
            return (Criteria) this;
        }

        public Criteria andAuditReasonsGreaterThan(String value) {
            addCriterion("audit_reasons >", value, "auditReasons");
            return (Criteria) this;
        }

        public Criteria andAuditReasonsGreaterThanOrEqualTo(String value) {
            addCriterion("audit_reasons >=", value, "auditReasons");
            return (Criteria) this;
        }

        public Criteria andAuditReasonsLessThan(String value) {
            addCriterion("audit_reasons <", value, "auditReasons");
            return (Criteria) this;
        }

        public Criteria andAuditReasonsLessThanOrEqualTo(String value) {
            addCriterion("audit_reasons <=", value, "auditReasons");
            return (Criteria) this;
        }

        public Criteria andAuditReasonsLike(String value) {
            addCriterion("audit_reasons like", value, "auditReasons");
            return (Criteria) this;
        }

        public Criteria andAuditReasonsNotLike(String value) {
            addCriterion("audit_reasons not like", value, "auditReasons");
            return (Criteria) this;
        }

        public Criteria andAuditReasonsIn(List<String> values) {
            addCriterion("audit_reasons in", values, "auditReasons");
            return (Criteria) this;
        }

        public Criteria andAuditReasonsNotIn(List<String> values) {
            addCriterion("audit_reasons not in", values, "auditReasons");
            return (Criteria) this;
        }

        public Criteria andAuditReasonsBetween(String value1, String value2) {
            addCriterion("audit_reasons between", value1, value2, "auditReasons");
            return (Criteria) this;
        }

        public Criteria andAuditReasonsNotBetween(String value1, String value2) {
            addCriterion("audit_reasons not between", value1, value2, "auditReasons");
            return (Criteria) this;
        }

        public Criteria andRemainingPriceIsNull() {
            addCriterion("remaining_price is null");
            return (Criteria) this;
        }

        public Criteria andRemainingPriceIsNotNull() {
            addCriterion("remaining_price is not null");
            return (Criteria) this;
        }

        public Criteria andRemainingPriceEqualTo(Float value) {
            addCriterion("remaining_price =", value, "remainingPrice");
            return (Criteria) this;
        }

        public Criteria andRemainingPriceNotEqualTo(Float value) {
            addCriterion("remaining_price <>", value, "remainingPrice");
            return (Criteria) this;
        }

        public Criteria andRemainingPriceGreaterThan(Float value) {
            addCriterion("remaining_price >", value, "remainingPrice");
            return (Criteria) this;
        }

        public Criteria andRemainingPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("remaining_price >=", value, "remainingPrice");
            return (Criteria) this;
        }

        public Criteria andRemainingPriceLessThan(Float value) {
            addCriterion("remaining_price <", value, "remainingPrice");
            return (Criteria) this;
        }

        public Criteria andRemainingPriceLessThanOrEqualTo(Float value) {
            addCriterion("remaining_price <=", value, "remainingPrice");
            return (Criteria) this;
        }

        public Criteria andRemainingPriceIn(List<Float> values) {
            addCriterion("remaining_price in", values, "remainingPrice");
            return (Criteria) this;
        }

        public Criteria andRemainingPriceNotIn(List<Float> values) {
            addCriterion("remaining_price not in", values, "remainingPrice");
            return (Criteria) this;
        }

        public Criteria andRemainingPriceBetween(Float value1, Float value2) {
            addCriterion("remaining_price between", value1, value2, "remainingPrice");
            return (Criteria) this;
        }

        public Criteria andRemainingPriceNotBetween(Float value1, Float value2) {
            addCriterion("remaining_price not between", value1, value2, "remainingPrice");
            return (Criteria) this;
        }

        public Criteria andFtpStatusIsNull() {
            addCriterion("ftp_status is null");
            return (Criteria) this;
        }

        public Criteria andFtpStatusIsNotNull() {
            addCriterion("ftp_status is not null");
            return (Criteria) this;
        }

        public Criteria andFtpStatusEqualTo(Integer value) {
            addCriterion("ftp_status =", value, "ftpStatus");
            return (Criteria) this;
        }

        public Criteria andFtpStatusNotEqualTo(Integer value) {
            addCriterion("ftp_status <>", value, "ftpStatus");
            return (Criteria) this;
        }

        public Criteria andFtpStatusGreaterThan(Integer value) {
            addCriterion("ftp_status >", value, "ftpStatus");
            return (Criteria) this;
        }

        public Criteria andFtpStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("ftp_status >=", value, "ftpStatus");
            return (Criteria) this;
        }

        public Criteria andFtpStatusLessThan(Integer value) {
            addCriterion("ftp_status <", value, "ftpStatus");
            return (Criteria) this;
        }

        public Criteria andFtpStatusLessThanOrEqualTo(Integer value) {
            addCriterion("ftp_status <=", value, "ftpStatus");
            return (Criteria) this;
        }

        public Criteria andFtpStatusIn(List<Integer> values) {
            addCriterion("ftp_status in", values, "ftpStatus");
            return (Criteria) this;
        }

        public Criteria andFtpStatusNotIn(List<Integer> values) {
            addCriterion("ftp_status not in", values, "ftpStatus");
            return (Criteria) this;
        }

        public Criteria andFtpStatusBetween(Integer value1, Integer value2) {
            addCriterion("ftp_status between", value1, value2, "ftpStatus");
            return (Criteria) this;
        }

        public Criteria andFtpStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("ftp_status not between", value1, value2, "ftpStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Integer value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Integer value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Integer value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Integer value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Integer value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Integer> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Integer> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Integer value1, Integer value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andIslinkIsNull() {
            addCriterion("isLink is null");
            return (Criteria) this;
        }

        public Criteria andIslinkIsNotNull() {
            addCriterion("isLink is not null");
            return (Criteria) this;
        }

        public Criteria andIslinkEqualTo(Integer value) {
            addCriterion("isLink =", value, "islink");
            return (Criteria) this;
        }

        public Criteria andIslinkNotEqualTo(Integer value) {
            addCriterion("isLink <>", value, "islink");
            return (Criteria) this;
        }

        public Criteria andIslinkGreaterThan(Integer value) {
            addCriterion("isLink >", value, "islink");
            return (Criteria) this;
        }

        public Criteria andIslinkGreaterThanOrEqualTo(Integer value) {
            addCriterion("isLink >=", value, "islink");
            return (Criteria) this;
        }

        public Criteria andIslinkLessThan(Integer value) {
            addCriterion("isLink <", value, "islink");
            return (Criteria) this;
        }

        public Criteria andIslinkLessThanOrEqualTo(Integer value) {
            addCriterion("isLink <=", value, "islink");
            return (Criteria) this;
        }

        public Criteria andIslinkIn(List<Integer> values) {
            addCriterion("isLink in", values, "islink");
            return (Criteria) this;
        }

        public Criteria andIslinkNotIn(List<Integer> values) {
            addCriterion("isLink not in", values, "islink");
            return (Criteria) this;
        }

        public Criteria andIslinkBetween(Integer value1, Integer value2) {
            addCriterion("isLink between", value1, value2, "islink");
            return (Criteria) this;
        }

        public Criteria andIslinkNotBetween(Integer value1, Integer value2) {
            addCriterion("isLink not between", value1, value2, "islink");
            return (Criteria) this;
        }

        public Criteria andBillingMethodWayIsNull() {
            addCriterion("billing_method_way is null");
            return (Criteria) this;
        }

        public Criteria andBillingMethodWayIsNotNull() {
            addCriterion("billing_method_way is not null");
            return (Criteria) this;
        }

        public Criteria andBillingMethodWayEqualTo(Integer value) {
            addCriterion("billing_method_way =", value, "billingMethodWay");
            return (Criteria) this;
        }

        public Criteria andBillingMethodWayNotEqualTo(Integer value) {
            addCriterion("billing_method_way <>", value, "billingMethodWay");
            return (Criteria) this;
        }

        public Criteria andBillingMethodWayGreaterThan(Integer value) {
            addCriterion("billing_method_way >", value, "billingMethodWay");
            return (Criteria) this;
        }

        public Criteria andBillingMethodWayGreaterThanOrEqualTo(Integer value) {
            addCriterion("billing_method_way >=", value, "billingMethodWay");
            return (Criteria) this;
        }

        public Criteria andBillingMethodWayLessThan(Integer value) {
            addCriterion("billing_method_way <", value, "billingMethodWay");
            return (Criteria) this;
        }

        public Criteria andBillingMethodWayLessThanOrEqualTo(Integer value) {
            addCriterion("billing_method_way <=", value, "billingMethodWay");
            return (Criteria) this;
        }

        public Criteria andBillingMethodWayIn(List<Integer> values) {
            addCriterion("billing_method_way in", values, "billingMethodWay");
            return (Criteria) this;
        }

        public Criteria andBillingMethodWayNotIn(List<Integer> values) {
            addCriterion("billing_method_way not in", values, "billingMethodWay");
            return (Criteria) this;
        }

        public Criteria andBillingMethodWayBetween(Integer value1, Integer value2) {
            addCriterion("billing_method_way between", value1, value2, "billingMethodWay");
            return (Criteria) this;
        }

        public Criteria andBillingMethodWayNotBetween(Integer value1, Integer value2) {
            addCriterion("billing_method_way not between", value1, value2, "billingMethodWay");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andProvCnIsNull() {
            addCriterion("prov_cn is null");
            return (Criteria) this;
        }

        public Criteria andProvCnIsNotNull() {
            addCriterion("prov_cn is not null");
            return (Criteria) this;
        }

        public Criteria andProvCnEqualTo(String value) {
            addCriterion("prov_cn =", value, "provCn");
            return (Criteria) this;
        }

        public Criteria andProvCnNotEqualTo(String value) {
            addCriterion("prov_cn <>", value, "provCn");
            return (Criteria) this;
        }

        public Criteria andProvCnGreaterThan(String value) {
            addCriterion("prov_cn >", value, "provCn");
            return (Criteria) this;
        }

        public Criteria andProvCnGreaterThanOrEqualTo(String value) {
            addCriterion("prov_cn >=", value, "provCn");
            return (Criteria) this;
        }

        public Criteria andProvCnLessThan(String value) {
            addCriterion("prov_cn <", value, "provCn");
            return (Criteria) this;
        }

        public Criteria andProvCnLessThanOrEqualTo(String value) {
            addCriterion("prov_cn <=", value, "provCn");
            return (Criteria) this;
        }

        public Criteria andProvCnLike(String value) {
            addCriterion("prov_cn like", value, "provCn");
            return (Criteria) this;
        }

        public Criteria andProvCnNotLike(String value) {
            addCriterion("prov_cn not like", value, "provCn");
            return (Criteria) this;
        }

        public Criteria andProvCnIn(List<String> values) {
            addCriterion("prov_cn in", values, "provCn");
            return (Criteria) this;
        }

        public Criteria andProvCnNotIn(List<String> values) {
            addCriterion("prov_cn not in", values, "provCn");
            return (Criteria) this;
        }

        public Criteria andProvCnBetween(String value1, String value2) {
            addCriterion("prov_cn between", value1, value2, "provCn");
            return (Criteria) this;
        }

        public Criteria andProvCnNotBetween(String value1, String value2) {
            addCriterion("prov_cn not between", value1, value2, "provCn");
            return (Criteria) this;
        }

        public Criteria andAgencyIsNull() {
            addCriterion("agency is null");
            return (Criteria) this;
        }

        public Criteria andAgencyIsNotNull() {
            addCriterion("agency is not null");
            return (Criteria) this;
        }

        public Criteria andAgencyEqualTo(String value) {
            addCriterion("agency =", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyNotEqualTo(String value) {
            addCriterion("agency <>", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyGreaterThan(String value) {
            addCriterion("agency >", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyGreaterThanOrEqualTo(String value) {
            addCriterion("agency >=", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyLessThan(String value) {
            addCriterion("agency <", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyLessThanOrEqualTo(String value) {
            addCriterion("agency <=", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyLike(String value) {
            addCriterion("agency like", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyNotLike(String value) {
            addCriterion("agency not like", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyIn(List<String> values) {
            addCriterion("agency in", values, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyNotIn(List<String> values) {
            addCriterion("agency not in", values, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyBetween(String value1, String value2) {
            addCriterion("agency between", value1, value2, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyNotBetween(String value1, String value2) {
            addCriterion("agency not between", value1, value2, "agency");
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