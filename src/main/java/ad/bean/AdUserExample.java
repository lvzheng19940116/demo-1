package ad.bean;

import java.util.ArrayList;
import java.util.List;

public class AdUserExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public AdUserExample() {
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

		public Criteria andCnameIsNull() {
			addCriterion("cname is null");
			return (Criteria) this;
		}

		public Criteria andCnameIsNotNull() {
			addCriterion("cname is not null");
			return (Criteria) this;
		}

		public Criteria andCnameEqualTo(String value) {
			addCriterion("cname =", value, "cname");
			return (Criteria) this;
		}

		public Criteria andCnameNotEqualTo(String value) {
			addCriterion("cname <>", value, "cname");
			return (Criteria) this;
		}

		public Criteria andCnameGreaterThan(String value) {
			addCriterion("cname >", value, "cname");
			return (Criteria) this;
		}

		public Criteria andCnameGreaterThanOrEqualTo(String value) {
			addCriterion("cname >=", value, "cname");
			return (Criteria) this;
		}

		public Criteria andCnameLessThan(String value) {
			addCriterion("cname <", value, "cname");
			return (Criteria) this;
		}

		public Criteria andCnameLessThanOrEqualTo(String value) {
			addCriterion("cname <=", value, "cname");
			return (Criteria) this;
		}

		public Criteria andCnameLike(String value) {
			addCriterion("cname like", value, "cname");
			return (Criteria) this;
		}

		public Criteria andCnameNotLike(String value) {
			addCriterion("cname not like", value, "cname");
			return (Criteria) this;
		}

		public Criteria andCnameIn(List<String> values) {
			addCriterion("cname in", values, "cname");
			return (Criteria) this;
		}

		public Criteria andCnameNotIn(List<String> values) {
			addCriterion("cname not in", values, "cname");
			return (Criteria) this;
		}

		public Criteria andCnameBetween(String value1, String value2) {
			addCriterion("cname between", value1, value2, "cname");
			return (Criteria) this;
		}

		public Criteria andCnameNotBetween(String value1, String value2) {
			addCriterion("cname not between", value1, value2, "cname");
			return (Criteria) this;
		}

		public Criteria andAccountIsNull() {
			addCriterion("account is null");
			return (Criteria) this;
		}

		public Criteria andAccountIsNotNull() {
			addCriterion("account is not null");
			return (Criteria) this;
		}

		public Criteria andAccountEqualTo(String value) {
			addCriterion("account =", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountNotEqualTo(String value) {
			addCriterion("account <>", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountGreaterThan(String value) {
			addCriterion("account >", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountGreaterThanOrEqualTo(String value) {
			addCriterion("account >=", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountLessThan(String value) {
			addCriterion("account <", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountLessThanOrEqualTo(String value) {
			addCriterion("account <=", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountLike(String value) {
			addCriterion("account like", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountNotLike(String value) {
			addCriterion("account not like", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountIn(List<String> values) {
			addCriterion("account in", values, "account");
			return (Criteria) this;
		}

		public Criteria andAccountNotIn(List<String> values) {
			addCriterion("account not in", values, "account");
			return (Criteria) this;
		}

		public Criteria andAccountBetween(String value1, String value2) {
			addCriterion("account between", value1, value2, "account");
			return (Criteria) this;
		}

		public Criteria andAccountNotBetween(String value1, String value2) {
			addCriterion("account not between", value1, value2, "account");
			return (Criteria) this;
		}

		public Criteria andPwdIsNull() {
			addCriterion("pwd is null");
			return (Criteria) this;
		}

		public Criteria andPwdIsNotNull() {
			addCriterion("pwd is not null");
			return (Criteria) this;
		}

		public Criteria andPwdEqualTo(String value) {
			addCriterion("pwd =", value, "pwd");
			return (Criteria) this;
		}

		public Criteria andPwdNotEqualTo(String value) {
			addCriterion("pwd <>", value, "pwd");
			return (Criteria) this;
		}

		public Criteria andPwdGreaterThan(String value) {
			addCriterion("pwd >", value, "pwd");
			return (Criteria) this;
		}

		public Criteria andPwdGreaterThanOrEqualTo(String value) {
			addCriterion("pwd >=", value, "pwd");
			return (Criteria) this;
		}

		public Criteria andPwdLessThan(String value) {
			addCriterion("pwd <", value, "pwd");
			return (Criteria) this;
		}

		public Criteria andPwdLessThanOrEqualTo(String value) {
			addCriterion("pwd <=", value, "pwd");
			return (Criteria) this;
		}

		public Criteria andPwdLike(String value) {
			addCriterion("pwd like", value, "pwd");
			return (Criteria) this;
		}

		public Criteria andPwdNotLike(String value) {
			addCriterion("pwd not like", value, "pwd");
			return (Criteria) this;
		}

		public Criteria andPwdIn(List<String> values) {
			addCriterion("pwd in", values, "pwd");
			return (Criteria) this;
		}

		public Criteria andPwdNotIn(List<String> values) {
			addCriterion("pwd not in", values, "pwd");
			return (Criteria) this;
		}

		public Criteria andPwdBetween(String value1, String value2) {
			addCriterion("pwd between", value1, value2, "pwd");
			return (Criteria) this;
		}

		public Criteria andPwdNotBetween(String value1, String value2) {
			addCriterion("pwd not between", value1, value2, "pwd");
			return (Criteria) this;
		}

		public Criteria andMobileIsNull() {
			addCriterion("mobile is null");
			return (Criteria) this;
		}

		public Criteria andMobileIsNotNull() {
			addCriterion("mobile is not null");
			return (Criteria) this;
		}

		public Criteria andMobileEqualTo(String value) {
			addCriterion("mobile =", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotEqualTo(String value) {
			addCriterion("mobile <>", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileGreaterThan(String value) {
			addCriterion("mobile >", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileGreaterThanOrEqualTo(String value) {
			addCriterion("mobile >=", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLessThan(String value) {
			addCriterion("mobile <", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLessThanOrEqualTo(String value) {
			addCriterion("mobile <=", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLike(String value) {
			addCriterion("mobile like", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotLike(String value) {
			addCriterion("mobile not like", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileIn(List<String> values) {
			addCriterion("mobile in", values, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotIn(List<String> values) {
			addCriterion("mobile not in", values, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileBetween(String value1, String value2) {
			addCriterion("mobile between", value1, value2, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotBetween(String value1, String value2) {
			addCriterion("mobile not between", value1, value2, "mobile");
			return (Criteria) this;
		}

		public Criteria andEmailIsNull() {
			addCriterion("email is null");
			return (Criteria) this;
		}

		public Criteria andEmailIsNotNull() {
			addCriterion("email is not null");
			return (Criteria) this;
		}

		public Criteria andEmailEqualTo(String value) {
			addCriterion("email =", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("email <>", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThan(String value) {
			addCriterion("email >", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("email >=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThan(String value) {
			addCriterion("email <", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("email <=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLike(String value) {
			addCriterion("email like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotLike(String value) {
			addCriterion("email not like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailIn(List<String> values) {
			addCriterion("email in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotIn(List<String> values) {
			addCriterion("email not in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("email between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("email not between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andExpiredIsNull() {
			addCriterion("expired is null");
			return (Criteria) this;
		}

		public Criteria andExpiredIsNotNull() {
			addCriterion("expired is not null");
			return (Criteria) this;
		}

		public Criteria andExpiredEqualTo(Integer value) {
			addCriterion("expired =", value, "expired");
			return (Criteria) this;
		}

		public Criteria andExpiredNotEqualTo(Integer value) {
			addCriterion("expired <>", value, "expired");
			return (Criteria) this;
		}

		public Criteria andExpiredGreaterThan(Integer value) {
			addCriterion("expired >", value, "expired");
			return (Criteria) this;
		}

		public Criteria andExpiredGreaterThanOrEqualTo(Integer value) {
			addCriterion("expired >=", value, "expired");
			return (Criteria) this;
		}

		public Criteria andExpiredLessThan(Integer value) {
			addCriterion("expired <", value, "expired");
			return (Criteria) this;
		}

		public Criteria andExpiredLessThanOrEqualTo(Integer value) {
			addCriterion("expired <=", value, "expired");
			return (Criteria) this;
		}

		public Criteria andExpiredIn(List<Integer> values) {
			addCriterion("expired in", values, "expired");
			return (Criteria) this;
		}

		public Criteria andExpiredNotIn(List<Integer> values) {
			addCriterion("expired not in", values, "expired");
			return (Criteria) this;
		}

		public Criteria andExpiredBetween(Integer value1, Integer value2) {
			addCriterion("expired between", value1, value2, "expired");
			return (Criteria) this;
		}

		public Criteria andExpiredNotBetween(Integer value1, Integer value2) {
			addCriterion("expired not between", value1, value2, "expired");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNull() {
			addCriterion("Description is null");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNotNull() {
			addCriterion("Description is not null");
			return (Criteria) this;
		}

		public Criteria andDescriptionEqualTo(String value) {
			addCriterion("Description =", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotEqualTo(String value) {
			addCriterion("Description <>", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThan(String value) {
			addCriterion("Description >", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("Description >=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThan(String value) {
			addCriterion("Description <", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThanOrEqualTo(String value) {
			addCriterion("Description <=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLike(String value) {
			addCriterion("Description like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotLike(String value) {
			addCriterion("Description not like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionIn(List<String> values) {
			addCriterion("Description in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotIn(List<String> values) {
			addCriterion("Description not in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionBetween(String value1, String value2) {
			addCriterion("Description between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotBetween(String value1, String value2) {
			addCriterion("Description not between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andLocknumIsNull() {
			addCriterion("locknum is null");
			return (Criteria) this;
		}

		public Criteria andLocknumIsNotNull() {
			addCriterion("locknum is not null");
			return (Criteria) this;
		}

		public Criteria andLocknumEqualTo(Integer value) {
			addCriterion("locknum =", value, "locknum");
			return (Criteria) this;
		}

		public Criteria andLocknumNotEqualTo(Integer value) {
			addCriterion("locknum <>", value, "locknum");
			return (Criteria) this;
		}

		public Criteria andLocknumGreaterThan(Integer value) {
			addCriterion("locknum >", value, "locknum");
			return (Criteria) this;
		}

		public Criteria andLocknumGreaterThanOrEqualTo(Integer value) {
			addCriterion("locknum >=", value, "locknum");
			return (Criteria) this;
		}

		public Criteria andLocknumLessThan(Integer value) {
			addCriterion("locknum <", value, "locknum");
			return (Criteria) this;
		}

		public Criteria andLocknumLessThanOrEqualTo(Integer value) {
			addCriterion("locknum <=", value, "locknum");
			return (Criteria) this;
		}

		public Criteria andLocknumIn(List<Integer> values) {
			addCriterion("locknum in", values, "locknum");
			return (Criteria) this;
		}

		public Criteria andLocknumNotIn(List<Integer> values) {
			addCriterion("locknum not in", values, "locknum");
			return (Criteria) this;
		}

		public Criteria andLocknumBetween(Integer value1, Integer value2) {
			addCriterion("locknum between", value1, value2, "locknum");
			return (Criteria) this;
		}

		public Criteria andLocknumNotBetween(Integer value1, Integer value2) {
			addCriterion("locknum not between", value1, value2, "locknum");
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

		public Criteria andCodenumberIsNull() {
			addCriterion("codenumber is null");
			return (Criteria) this;
		}

		public Criteria andCodenumberIsNotNull() {
			addCriterion("codenumber is not null");
			return (Criteria) this;
		}

		public Criteria andCodenumberEqualTo(String value) {
			addCriterion("codenumber =", value, "codenumber");
			return (Criteria) this;
		}

		public Criteria andCodenumberNotEqualTo(String value) {
			addCriterion("codenumber <>", value, "codenumber");
			return (Criteria) this;
		}

		public Criteria andCodenumberGreaterThan(String value) {
			addCriterion("codenumber >", value, "codenumber");
			return (Criteria) this;
		}

		public Criteria andCodenumberGreaterThanOrEqualTo(String value) {
			addCriterion("codenumber >=", value, "codenumber");
			return (Criteria) this;
		}

		public Criteria andCodenumberLessThan(String value) {
			addCriterion("codenumber <", value, "codenumber");
			return (Criteria) this;
		}

		public Criteria andCodenumberLessThanOrEqualTo(String value) {
			addCriterion("codenumber <=", value, "codenumber");
			return (Criteria) this;
		}

		public Criteria andCodenumberLike(String value) {
			addCriterion("codenumber like", value, "codenumber");
			return (Criteria) this;
		}

		public Criteria andCodenumberNotLike(String value) {
			addCriterion("codenumber not like", value, "codenumber");
			return (Criteria) this;
		}

		public Criteria andCodenumberIn(List<String> values) {
			addCriterion("codenumber in", values, "codenumber");
			return (Criteria) this;
		}

		public Criteria andCodenumberNotIn(List<String> values) {
			addCriterion("codenumber not in", values, "codenumber");
			return (Criteria) this;
		}

		public Criteria andCodenumberBetween(String value1, String value2) {
			addCriterion("codenumber between", value1, value2, "codenumber");
			return (Criteria) this;
		}

		public Criteria andCodenumberNotBetween(String value1, String value2) {
			addCriterion("codenumber not between", value1, value2, "codenumber");
			return (Criteria) this;
		}

		public Criteria andDeptidIsNull() {
			addCriterion("deptid is null");
			return (Criteria) this;
		}

		public Criteria andDeptidIsNotNull() {
			addCriterion("deptid is not null");
			return (Criteria) this;
		}

		public Criteria andDeptidEqualTo(Integer value) {
			addCriterion("deptid =", value, "deptid");
			return (Criteria) this;
		}

		public Criteria andDeptidNotEqualTo(Integer value) {
			addCriterion("deptid <>", value, "deptid");
			return (Criteria) this;
		}

		public Criteria andDeptidGreaterThan(Integer value) {
			addCriterion("deptid >", value, "deptid");
			return (Criteria) this;
		}

		public Criteria andDeptidGreaterThanOrEqualTo(Integer value) {
			addCriterion("deptid >=", value, "deptid");
			return (Criteria) this;
		}

		public Criteria andDeptidLessThan(Integer value) {
			addCriterion("deptid <", value, "deptid");
			return (Criteria) this;
		}

		public Criteria andDeptidLessThanOrEqualTo(Integer value) {
			addCriterion("deptid <=", value, "deptid");
			return (Criteria) this;
		}

		public Criteria andDeptidIn(List<Integer> values) {
			addCriterion("deptid in", values, "deptid");
			return (Criteria) this;
		}

		public Criteria andDeptidNotIn(List<Integer> values) {
			addCriterion("deptid not in", values, "deptid");
			return (Criteria) this;
		}

		public Criteria andDeptidBetween(Integer value1, Integer value2) {
			addCriterion("deptid between", value1, value2, "deptid");
			return (Criteria) this;
		}

		public Criteria andDeptidNotBetween(Integer value1, Integer value2) {
			addCriterion("deptid not between", value1, value2, "deptid");
			return (Criteria) this;
		}

		public Criteria andDatetimeIsNull() {
			addCriterion("datetime is null");
			return (Criteria) this;
		}

		public Criteria andDatetimeIsNotNull() {
			addCriterion("datetime is not null");
			return (Criteria) this;
		}

		public Criteria andDatetimeEqualTo(String value) {
			addCriterion("datetime =", value, "datetime");
			return (Criteria) this;
		}

		public Criteria andDatetimeNotEqualTo(String value) {
			addCriterion("datetime <>", value, "datetime");
			return (Criteria) this;
		}

		public Criteria andDatetimeGreaterThan(String value) {
			addCriterion("datetime >", value, "datetime");
			return (Criteria) this;
		}

		public Criteria andDatetimeGreaterThanOrEqualTo(String value) {
			addCriterion("datetime >=", value, "datetime");
			return (Criteria) this;
		}

		public Criteria andDatetimeLessThan(String value) {
			addCriterion("datetime <", value, "datetime");
			return (Criteria) this;
		}

		public Criteria andDatetimeLessThanOrEqualTo(String value) {
			addCriterion("datetime <=", value, "datetime");
			return (Criteria) this;
		}

		public Criteria andDatetimeLike(String value) {
			addCriterion("datetime like", value, "datetime");
			return (Criteria) this;
		}

		public Criteria andDatetimeNotLike(String value) {
			addCriterion("datetime not like", value, "datetime");
			return (Criteria) this;
		}

		public Criteria andDatetimeIn(List<String> values) {
			addCriterion("datetime in", values, "datetime");
			return (Criteria) this;
		}

		public Criteria andDatetimeNotIn(List<String> values) {
			addCriterion("datetime not in", values, "datetime");
			return (Criteria) this;
		}

		public Criteria andDatetimeBetween(String value1, String value2) {
			addCriterion("datetime between", value1, value2, "datetime");
			return (Criteria) this;
		}

		public Criteria andDatetimeNotBetween(String value1, String value2) {
			addCriterion("datetime not between", value1, value2, "datetime");
			return (Criteria) this;
		}

		public Criteria andCoIdIsNull() {
			addCriterion("co_id is null");
			return (Criteria) this;
		}

		public Criteria andCoIdIsNotNull() {
			addCriterion("co_id is not null");
			return (Criteria) this;
		}

		public Criteria andCoIdEqualTo(Integer value) {
			addCriterion("co_id =", value, "coId");
			return (Criteria) this;
		}

		public Criteria andCoIdNotEqualTo(Integer value) {
			addCriterion("co_id <>", value, "coId");
			return (Criteria) this;
		}

		public Criteria andCoIdGreaterThan(Integer value) {
			addCriterion("co_id >", value, "coId");
			return (Criteria) this;
		}

		public Criteria andCoIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("co_id >=", value, "coId");
			return (Criteria) this;
		}

		public Criteria andCoIdLessThan(Integer value) {
			addCriterion("co_id <", value, "coId");
			return (Criteria) this;
		}

		public Criteria andCoIdLessThanOrEqualTo(Integer value) {
			addCriterion("co_id <=", value, "coId");
			return (Criteria) this;
		}

		public Criteria andCoIdIn(List<Integer> values) {
			addCriterion("co_id in", values, "coId");
			return (Criteria) this;
		}

		public Criteria andCoIdNotIn(List<Integer> values) {
			addCriterion("co_id not in", values, "coId");
			return (Criteria) this;
		}

		public Criteria andCoIdBetween(Integer value1, Integer value2) {
			addCriterion("co_id between", value1, value2, "coId");
			return (Criteria) this;
		}

		public Criteria andCoIdNotBetween(Integer value1, Integer value2) {
			addCriterion("co_id not between", value1, value2, "coId");
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