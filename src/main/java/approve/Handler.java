package approve;
/**
* @author LvZheng
* 创建时间：2018年5月16日 下午3:13:56
*/
public abstract class Handler {
	/**
	 * 持有后继责任的对象
	 */
	private Handler successor;

	public Handler getSuccessor() {
		return successor;
	}

	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}
	/**
     * 示意处理请求的方法，虽然这个示意方法是没有传入参数的
     * 但实际是可以传入参数的，根据具体需要来选择是否传递参数
	 *
     * 处理聚餐费用的申请
     * @param user    申请人
     * @param i    申请的钱数
     * @return        成功或失败的具体通知
     */
	public abstract String handleRequest(String user ,int i);
	

}
