package com.lims.constants;  
/**   
 * @ClassName: ResultCode
 * @author Jincan
 * @date 2015-12-28 下午5:33:04 
 * @version V1.0   
 * Copyright  2015 Egaotech Inc.All rights reserved.
 */
public class ResultCode {
	/** 成功 */
	public static final int SUCCESS = 0;

	/** 失败 */
	public static final int FAILURE = -1;

	/** 参数错误 */
	public static final int ARGUMENT_ERROR = -2;
	
	/** 数据库错误 */
	public static final int DB_ERROR = -3;
	
	
    ///////////////////////控制层返回//////////////////////////////
	public static final String RETURN_SUCCESS="200"; //成功
	
	public static final String RETURN_FAILURE="201"; //失败
	
	public static final String OTHER_ERROR = "500";//系统错误
	
	public static final String GATEWAY_ERROR = "501";//网关错误
	
	public static final String LIKE_EXPIRED_ERROR = "401";   //链接失效,即链接超时
	
	public static final String PRIMARY_KEY_ERROR = "402";     //秘钥错误
	
	public static final String ILLEGAL_ARGUMENT_ERROR ="403"; //传递参数不合法
	
	public static final String ARGUMENT_LACK_ERROR ="405"; //参数缺失错误,不完整
	
	public static final String SING_ERROR ="406"; //数字签名有误
	
	public static final String UNIQUE_KEY_ERROR ="407"; //唯一键冲突
	
	public static final String DB_FAILURE="410";//数据操作错误


}
