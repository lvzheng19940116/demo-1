package ad.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AbAdvertOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AbAdvertOrderExample() {
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

        public Criteria andOrderNameIsNull() {
            addCriterion("order_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderNameIsNotNull() {
            addCriterion("order_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNameEqualTo(String value) {
            addCriterion("order_name =", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotEqualTo(String value) {
            addCriterion("order_name <>", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameGreaterThan(String value) {
            addCriterion("order_name >", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_name >=", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLessThan(String value) {
            addCriterion("order_name <", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLessThanOrEqualTo(String value) {
            addCriterion("order_name <=", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLike(String value) {
            addCriterion("order_name like", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotLike(String value) {
            addCriterion("order_name not like", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameIn(List<String> values) {
            addCriterion("order_name in", values, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotIn(List<String> values) {
            addCriterion("order_name not in", values, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameBetween(String value1, String value2) {
            addCriterion("order_name between", value1, value2, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotBetween(String value1, String value2) {
            addCriterion("order_name not between", value1, value2, "orderName");
            return (Criteria) this;
        }

        public Criteria andSalesUserIsNull() {
            addCriterion("sales_user is null");
            return (Criteria) this;
        }

        public Criteria andSalesUserIsNotNull() {
            addCriterion("sales_user is not null");
            return (Criteria) this;
        }

        public Criteria andSalesUserEqualTo(String value) {
            addCriterion("sales_user =", value, "salesUser");
            return (Criteria) this;
        }

        public Criteria andSalesUserNotEqualTo(String value) {
            addCriterion("sales_user <>", value, "salesUser");
            return (Criteria) this;
        }

        public Criteria andSalesUserGreaterThan(String value) {
            addCriterion("sales_user >", value, "salesUser");
            return (Criteria) this;
        }

        public Criteria andSalesUserGreaterThanOrEqualTo(String value) {
            addCriterion("sales_user >=", value, "salesUser");
            return (Criteria) this;
        }

        public Criteria andSalesUserLessThan(String value) {
            addCriterion("sales_user <", value, "salesUser");
            return (Criteria) this;
        }

        public Criteria andSalesUserLessThanOrEqualTo(String value) {
            addCriterion("sales_user <=", value, "salesUser");
            return (Criteria) this;
        }

        public Criteria andSalesUserLike(String value) {
            addCriterion("sales_user like", value, "salesUser");
            return (Criteria) this;
        }

        public Criteria andSalesUserNotLike(String value) {
            addCriterion("sales_user not like", value, "salesUser");
            return (Criteria) this;
        }

        public Criteria andSalesUserIn(List<String> values) {
            addCriterion("sales_user in", values, "salesUser");
            return (Criteria) this;
        }

        public Criteria andSalesUserNotIn(List<String> values) {
            addCriterion("sales_user not in", values, "salesUser");
            return (Criteria) this;
        }

        public Criteria andSalesUserBetween(String value1, String value2) {
            addCriterion("sales_user between", value1, value2, "salesUser");
            return (Criteria) this;
        }

        public Criteria andSalesUserNotBetween(String value1, String value2) {
            addCriterion("sales_user not between", value1, value2, "salesUser");
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

        public Criteria andTotalAdverSalesIsNull() {
            addCriterion("total_adver_sales is null");
            return (Criteria) this;
        }

        public Criteria andTotalAdverSalesIsNotNull() {
            addCriterion("total_adver_sales is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAdverSalesEqualTo(Float value) {
            addCriterion("total_adver_sales =", value, "totalAdverSales");
            return (Criteria) this;
        }

        public Criteria andTotalAdverSalesNotEqualTo(Float value) {
            addCriterion("total_adver_sales <>", value, "totalAdverSales");
            return (Criteria) this;
        }

        public Criteria andTotalAdverSalesGreaterThan(Float value) {
            addCriterion("total_adver_sales >", value, "totalAdverSales");
            return (Criteria) this;
        }

        public Criteria andTotalAdverSalesGreaterThanOrEqualTo(Float value) {
            addCriterion("total_adver_sales >=", value, "totalAdverSales");
            return (Criteria) this;
        }

        public Criteria andTotalAdverSalesLessThan(Float value) {
            addCriterion("total_adver_sales <", value, "totalAdverSales");
            return (Criteria) this;
        }

        public Criteria andTotalAdverSalesLessThanOrEqualTo(Float value) {
            addCriterion("total_adver_sales <=", value, "totalAdverSales");
            return (Criteria) this;
        }

        public Criteria andTotalAdverSalesIn(List<Float> values) {
            addCriterion("total_adver_sales in", values, "totalAdverSales");
            return (Criteria) this;
        }

        public Criteria andTotalAdverSalesNotIn(List<Float> values) {
            addCriterion("total_adver_sales not in", values, "totalAdverSales");
            return (Criteria) this;
        }

        public Criteria andTotalAdverSalesBetween(Float value1, Float value2) {
            addCriterion("total_adver_sales between", value1, value2, "totalAdverSales");
            return (Criteria) this;
        }

        public Criteria andTotalAdverSalesNotBetween(Float value1, Float value2) {
            addCriterion("total_adver_sales not between", value1, value2, "totalAdverSales");
            return (Criteria) this;
        }

        public Criteria andTotalAdverManageIsNull() {
            addCriterion("total_adver_manage is null");
            return (Criteria) this;
        }

        public Criteria andTotalAdverManageIsNotNull() {
            addCriterion("total_adver_manage is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAdverManageEqualTo(Float value) {
            addCriterion("total_adver_manage =", value, "totalAdverManage");
            return (Criteria) this;
        }

        public Criteria andTotalAdverManageNotEqualTo(Float value) {
            addCriterion("total_adver_manage <>", value, "totalAdverManage");
            return (Criteria) this;
        }

        public Criteria andTotalAdverManageGreaterThan(Float value) {
            addCriterion("total_adver_manage >", value, "totalAdverManage");
            return (Criteria) this;
        }

        public Criteria andTotalAdverManageGreaterThanOrEqualTo(Float value) {
            addCriterion("total_adver_manage >=", value, "totalAdverManage");
            return (Criteria) this;
        }

        public Criteria andTotalAdverManageLessThan(Float value) {
            addCriterion("total_adver_manage <", value, "totalAdverManage");
            return (Criteria) this;
        }

        public Criteria andTotalAdverManageLessThanOrEqualTo(Float value) {
            addCriterion("total_adver_manage <=", value, "totalAdverManage");
            return (Criteria) this;
        }

        public Criteria andTotalAdverManageIn(List<Float> values) {
            addCriterion("total_adver_manage in", values, "totalAdverManage");
            return (Criteria) this;
        }

        public Criteria andTotalAdverManageNotIn(List<Float> values) {
            addCriterion("total_adver_manage not in", values, "totalAdverManage");
            return (Criteria) this;
        }

        public Criteria andTotalAdverManageBetween(Float value1, Float value2) {
            addCriterion("total_adver_manage between", value1, value2, "totalAdverManage");
            return (Criteria) this;
        }

        public Criteria andTotalAdverManageNotBetween(Float value1, Float value2) {
            addCriterion("total_adver_manage not between", value1, value2, "totalAdverManage");
            return (Criteria) this;
        }

        public Criteria andAttachmentAddressIsNull() {
            addCriterion("attachment_address is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentAddressIsNotNull() {
            addCriterion("attachment_address is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentAddressEqualTo(String value) {
            addCriterion("attachment_address =", value, "attachmentAddress");
            return (Criteria) this;
        }

        public Criteria andAttachmentAddressNotEqualTo(String value) {
            addCriterion("attachment_address <>", value, "attachmentAddress");
            return (Criteria) this;
        }

        public Criteria andAttachmentAddressGreaterThan(String value) {
            addCriterion("attachment_address >", value, "attachmentAddress");
            return (Criteria) this;
        }

        public Criteria andAttachmentAddressGreaterThanOrEqualTo(String value) {
            addCriterion("attachment_address >=", value, "attachmentAddress");
            return (Criteria) this;
        }

        public Criteria andAttachmentAddressLessThan(String value) {
            addCriterion("attachment_address <", value, "attachmentAddress");
            return (Criteria) this;
        }

        public Criteria andAttachmentAddressLessThanOrEqualTo(String value) {
            addCriterion("attachment_address <=", value, "attachmentAddress");
            return (Criteria) this;
        }

        public Criteria andAttachmentAddressLike(String value) {
            addCriterion("attachment_address like", value, "attachmentAddress");
            return (Criteria) this;
        }

        public Criteria andAttachmentAddressNotLike(String value) {
            addCriterion("attachment_address not like", value, "attachmentAddress");
            return (Criteria) this;
        }

        public Criteria andAttachmentAddressIn(List<String> values) {
            addCriterion("attachment_address in", values, "attachmentAddress");
            return (Criteria) this;
        }

        public Criteria andAttachmentAddressNotIn(List<String> values) {
            addCriterion("attachment_address not in", values, "attachmentAddress");
            return (Criteria) this;
        }

        public Criteria andAttachmentAddressBetween(String value1, String value2) {
            addCriterion("attachment_address between", value1, value2, "attachmentAddress");
            return (Criteria) this;
        }

        public Criteria andAttachmentAddressNotBetween(String value1, String value2) {
            addCriterion("attachment_address not between", value1, value2, "attachmentAddress");
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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