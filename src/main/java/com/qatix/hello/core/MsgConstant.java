package com.qatix.hello.core;

public interface MsgConstant {
	
	//对Applicant表的相关数据库操作返回的RetMessage[状态信息]
	public String RET_APPLICANT_CLEAR_SUCCESS ="ret_applicant_clear_success";							//清空成功
	public String RET_APPLICANT_CLEAR_FAILURE ="ret_applicant_clear_failure";							//清空失败
	public String RET_APPLICANT_IMPORT_SUCCESS ="ret_applicant_import_success";							//导入成功
	public String RET_APPLICANT_IMPORT_FAILURE ="ret_applicant_import_failure";							//导入失败
	public String RET_APPLICANT_INSERT_SUCCESS ="ret_applicant_insert_success";							//插入成功
	public String RET_APPLICANT_INSERT_FAILURE ="ret_applicant_insert_failure";							//插入失败	
	public String RET_APPLICANT_IMPORT_NOTFOUND ="ret_applicant_import_target_file_not_found";			//目标文件未找到
	public String RET_APPLICANT_SELECT_SUCCESS ="ret_applicant_select_success";							//查询成功
	public String RET_APPLICANT_SELECT_FAILURE ="ret_applicant_select_failure";							//查询失败
	public String RET_APPLICANT_COPY_SUCCESS="ret_applicant_copy_success";								//复制成功
	public String RET_APPLICANT_COPY_FAILURE="ret_applicant_copy_failure";								//复制失败	
	
	//对judge表的相关数据库操作返回的RetMessage[状态信息]
	public String RET_JUDGE_REGISTER_SUCCESS="ret_judge_register_success";								//注册成功
	public String RET_JUDGE_REGISTER_FAILURE="ret_judge_register_failure";								//注册失败
	public String RET_JUDGE_LOGIN_SUCCESS="ret_judge_login_success";									//登录成功
	public String RET_JUDGE_LOGIN_FAILURE="ret_judge_login_failure";									//登录失败
	public String RET_JUDGE_ID_NOT_EXIST="ret_judge_id_not_exist";										//数据库中id不存在
	public String RET_JUDGE_PASSWORD_NOT_RIGHT="ret_judge_password_not_right";							//数据库中密码不正确
	public String RET_JUDGE_MACADDRESS_ALREADY_EXIST="ret_judge_macaddress_already_exist";				//数据库中mac地址已经存在
	public String RET_JUDGE_MACADDRESS_ISNEW="ret_judge_macaddress_isnew";								//数据库中没有此mac地址
	
	//对result表的相关数据库操作返回的RetMessage[状态信息]
	public String RET_RESULT_ADD_SUCCESS="ret_result_add_success";										//添加成功
	public String RET_RESULT_ADD_FAILURE="ret_result_add_failure";										//添加失败
	public String RET_RESULT_COUNT_SUCCESS="ret_result_count_success";									//统计成功
	public String RET_RESULT_COUNT_FAILURE="ret_result_count_failure";									//统计失败
	public String RET_RESULT_CHECK_SUCCESS="ret_result_check_success";									//检查成功
	public String RET_RESULT_CHECK_FAILURE="ret_result_check failure";									//检查失败
	public String RET_RESULT_SELECT_SUCCESS="ret_result_select_success";								//查询成功
	public String RET_RESULT_SELECT_FAILURE="ret_result_select_failure";								//查询失败
	
	//对文件的导出操作返回的RetMessage[状态信息]
	public String RET_FILE_EXPORT_SUCCESS="ret_file_export_success";									//导出成功
	public String RE_FILE_EXPORT_FAILURE="ret_file_export_failure";										//导出失败
	
}	
