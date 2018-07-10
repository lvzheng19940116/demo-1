package ad.util;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/**
 *
* @ClassName: SysStatic
* @Description: 系统中常量的定义类
* @author: chenhaoxian
* @date: 2013-6-7
*
 */
@SuppressWarnings("serial")
public class SysStatic implements Serializable{

	/**web完整目录*/
	public static String WEB_REAL_PATH;
	/**web主目录 */
	public static String WEBROOTPATH;
	/**图片保存根目录 */
	public static String IMAGES_SAVE_ROOT_PATH = "\\WEB-INF\\images\\";
	/**图片显示根目录 */
	public static String IMAGES_SHOW_ROOT_PATH = "/images/";
	/**请求响应正常状态*/
	public static final Integer REQUEST_CODE_OK=1;
	/**请求响应错误状态*/
	public static final Integer REQUEST_CODE_ERROR=0;
	/**公用对象正常标识 1*/
	public static final Integer NORMALDELFLAG = 1;
	/**公用对象删除标识 2*/
	public static final Integer DELFLAG = 2;
	/**新建不可用清单增加业务漏记字段*/
	public static final String  PARAMERERNAME="newnewnew";
	/**用户未修改密码 0*/
	public static final Integer USERSTATE_NOCHANGEPWD = 0;
	/**用户密码已经修改 1*/
	public static final Integer USERSTATE_CHANGEPWD = 1;
	/**用户组*/
	public static final Integer USER_GROUP=1;
	/**非用户组*/
	public static final Integer USER_NO_GROUP=2;
	/**后台登录session key*/
	public static final String MC_LOGIN = "USERINFO";
	/**邮件未发送标识*/
	public static final Integer NO_SEND=1;
	/**邮件发送标识*/
	public static final Integer SEND = 2;
	/**系统邮件stmp服务器地址*/
	public static String EMAIL_HOST;
	/**系统邮件发送者*/
	public static String EMAIL_AUTH;
	/**系统邮件密码*/
	public static String EMAIL_PWD;
	/**权限模块*/
	public static final Map<Integer,String> MODELMAP = new HashMap<>();
	/*** 记录当前用户下载压缩百分比key为用户ID * */
	public static final Map<String,Long> userDownProgress = new  HashMap<>();
	/****已经完成百分比下载**/
	public static final String ALREADY ="already";
	/****一共百分比下载**/
	public static final String ALL ="all";

	/**以下为权限管理各模块组名称*/
	/**生产维修*/
	public static final Integer MODEL_MAINTAIN = 1;
	/**技术支持*/
	public static final Integer MODEL_TOOL = 2;
	/**生产管理*/
	public static final Integer MODEL_MANAGE = 3;
	/**统计预测*/
	public static final Integer MODEL_STAT = 4;
	/**通用信息*/
	public static final Integer MODEL_INFO = 5;
	/**系统管理*/
	public static final Integer MODEL_SYSTEM = 6;

	static{
		MODELMAP.put(MODEL_MAINTAIN, "生产维修");
		MODELMAP.put(MODEL_TOOL, "技术支持");
		MODELMAP.put(MODEL_MANAGE, "生产管理");
		MODELMAP.put(MODEL_STAT, "统计预测");
		MODELMAP.put(MODEL_INFO, "通用信息");
		MODELMAP.put(MODEL_SYSTEM, "系统管理");
	}

	/**以下为上传ftp文件各模块标识*/
	/**故障信息模块*/
	public static final String FAULT_FTP_CODE = "1GZFJ";

	/**工卡模版模块*/
	public static final String WCTEMPLATE_FTP_CODE = "2WCTL";

	/**出场交接单模块*/
	public static final String EXITJOIN_FTP_CODE = "3EXJO";

	/**返工记录模块*/
	public static final String REWORK_FTP_CODE = "4REWK";

	/**件号定义模块*/
	public static final String MATEREIL_FTP_CODE = "5MATE";

	/**外委工作模块*/
	public static final String REPAIROUT_FTP_CODE = "5REPAIR";


	public static int DEPTSIZE = 0;

	public static String getModelStr(Integer type){
		return MODELMAP.get(type);
	}

	/**用户登陆黑名单*/
	public static final Map<String,String> BLACKLISTMAP = new HashMap<>();
	/**用户登陆黑名单*/
	public static final Map<String,Integer> BLACKLISTTEMPMAP = new HashMap<>();
	/**将IP定义为黑名单的最大连续登陆错误次数*/
	public static  Integer BLACKLISTMAXFAILCOUNT = 0;
	/**用户组Id与其结点名称Map*/
	public static Map<String,String> GROUPID_NODENAMES_MAP = new HashMap<>();

	/**航材类型集合*/
	public static Map<String,String> MATERIEL_CATEGORY_MAP = new HashMap<>();
	/**已删除*/
	public static final Integer DELETEFLAG = 512;
	/**录入状态*/
	public static final Integer ORIGINAL = 0;
	/**保存初稿*/
	public static final Integer SAVEBASE = 1;
	/**待审核*/
	public static final Integer SUBMITASSESS = 2;
	/**审核通过*/
	public static final Integer ASSESSED  = 3;
	/**审核驳回*/
	public static final Integer REJECT  = 4;

	//******* 工卡模块常量 start ******//
	/** 保存初稿 */
	public static final Integer WC_ORIGINAL_SAVE  = 0;
	/** 初稿待审核 */
	public static final Integer WC_ORIGINAL_NOT_CHECK  = 1;
	/** 初稿审核通过,未执行 */
	public static final Integer WC_ORIGINAL_PASS  = 2;
	/** 初稿审核未通过 */
	public static final Integer WC_ORIGINAL_REJECT  = 4;
	/** 已执行过,未提交审批,还可修改 */
	public static final Integer WC_EXECUTE  = 3;
	/** 执行后待审批 */
	public static final Integer WC_NOT_CHECK  = 7;
	/** 执行后已审批 */
	public static final Integer WC_PASS  = 15;
	/** 驳回 */
	public static final Integer WC_REJECT  = 16;

	//******* 工卡模块常量 end ******//
	/** 退件状态*/
	public static final Integer RETURNPART  = 5;

	//******* 试车记录常量 start ******//
	/** 保存初稿 */
	public static final Integer TESTRUN_STATUS_SAVE = 0;
	/** 已审批 */
	public static final Integer TESTRUN_STATUS_PASS = 15;

	//******* 试车记录常量 end ******//
	/** 零小时返厂*/
	public static final Integer RETURNFACTORY  = 2;

	//******* 工卡工段常量 start ******//
	/**工卡审核*/
	public static final String WC_CATEGORY_NOT_CHECK = "1024";
	/**非例行卡*/
	public static final String WC_CATEGORY_NONE_REGULAR = "128";
	/**装配*/
	public static final String WC_CATEGORY_ASSEMBLE = "9";

	//******* 工卡工段常量 end ******//

	//******* 履历中apuStatus常量 start ******//
	/** 已进场检查; */
	public static final Integer RECORD_APU_STATUS_ENTERCHECK  = 32;
	/** 已附件普查; */
	public static final Integer RECORD_APU_STATUS_ATTACHMENTCHECK  = 64;
	/** 已分解; */
	public static final Integer RECORD_APU_STATUS_SPLIT  = 128;
	/** 已清洗; */
	public static final Integer RECORD_APU_STATUS_CLEAN  = 256;
	/** 已故检; */
	public static final Integer RECORD_APU_STATUS_GUJIAN  = 512;
	/** 已修理; */
	public static final Integer RECORD_APU_STATUS_REPAIR  = 1024;
	/**已集件 bit12,&2048 ;*/
	public static final Integer RECORD_APU_STATUS_JIJIAN  = 2048;
	/** 已装配; */
	public static final Integer RECORD_APU_STATUS_ZP  = 4096;
	/** 已试车; */
	public static final Integer RECORD_APU_STATUS_TESTRUN  = 8192;
	/** 已出场; */
	public static final Integer RECORD_APU_STATUS_EXIT  = 16384;

	//******* 履历中apuStatus常量 end ******//

}
