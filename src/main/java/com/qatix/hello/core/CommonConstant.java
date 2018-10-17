package com.qatix.hello.core;

public interface CommonConstant {
	
	public static String RESULT_CODE_CONTINUE = "100";			 	//(Continue/继续)
	public static String RESULT_CODE_SWITCHING_PROTOCOLS = "101"; 	//(Switching Protocols/转换协议)
	
	public static String RESULT_CODE_OK = "200";						//(OK/正常)
	public static String RESULT_CODE_CREATED = "201"; 			 	//(Created/已创建)
	public static String RESULT_CODE_ACCEPTED = "202";			 	//(Accepted/接受)
	public static String RESULT_CODE_NON_AUTHORITATIVE_INFORMATION = "203";		//(Non-Authoritative Information/非官方信息)
	public static String RESULT_CODE_NO_CONTENT = "204"; 		 	//(No Content/无内容)
	public static String RESULT_CODE_RESET_CONTENT = "205"; 		 	//(Reset Content/重置内容)
	public static String RESULT_CODE_PARTIAL_CONTENT = "206"; 	 	//(Partial Content/局部内容)
	
	public static String RESULT_CODE_MULTIPLE_CHOICES = "300"; 	 	//(Multiple Choices/多重选择)
	public static String RESULT_CODE_MOVED_PERMANENTLY = "301";   	//(SC_MOVED_PERMANENTLY)状态是指所请求的文档在别的地方；文档新的URL会在定位响应头信息中给出。浏览器会自动连接到新的URL
	public static String RESULT_CODE_FOUND = "302"; 		 			//(Found/找到)
	public static String RESULT_CODE_SEE_OTHER = "303"; 		 		//(See Other/参见其他信息)
	public static String RESULT_CODE_NOT_MODIFIED = "304"; 		 	//(Not Modified/为修正)
	public static String RESULT_CODE_USE_PROXY = "305"; 		 		//(Use Proxy/使用代理)
	public static String RESULT_CODE_TEMPORARY_REDIRECT = "307";  	//(Temporary Redirect/临时重定向))
	
	public static String RESULT_CODE_BAD_REQUEST = "400"; 		 	//(Bad Request/错误请求)
	public static String RESULT_CODE_UNAUTHORIZED = "401"; 		 	//(Unauthorized/未授权)
	public static String RESULT_CODE_FORBIDDEN = "403"; 		 	 	//(Forbidden/禁止)
	public static String RESULT_CODE_NOT_FOUND= "404"; 		 	 	//(Not Found/未找到)
	public static String RESULT_CODE_METHOD_NOT_ALLOWED = "405";  	//(Method Not Allowed/方法未允许)
	public static String RESULT_CODE_NOT_ACCEPTABLE = "406"; 	 	//(Not Acceptable/无法访问)
	public static String RESULT_CODE_PROXY_AUTHENTICATION_REQUIRED = "407"; 		 //(Proxy Authentication Required/代理服务器认证要求)
	public static String RESULT_CODE_REQUEST_TIMEOUT = "408"; 		//(Request Timeout/请求超时)
	public static String RESULT_CODE_CONFLICT = "409"; 		 	 	//(Conflict/冲突)
	public static String RESULT_CODE_GONE = "410"; 		 		 	//(Gone/已经不存在)
	public static String RESULT_CODE_LENGTH_REQUIRED = "411"; 		//(Length Required/需要数据长度)
	public static String RESULT_CODE_PRECONDITION_FAILED = "412"; 	//(Precondition Failed/先决条件错误)
	public static String RESULT_CODE_REQUEST_ENTITY_TOO_LARGE = "413"; 		 //(Request Entity Too Large/请求实体过大)
	public static String RESULT_CODE_REQUEST_URI_TOO_LONG = "414"; 		 	 //(Request URI Too Long/请求URI过长)
	public static String RESULT_CODE_UNSUPPORTED_MEDIA_TYPE = "415"; 		 //(Unsupported Media Type/不支持的媒体格式)
	public static String RESULT_CODE_REQUESTED_RANGE_NOT_SATISFIABLE = "416"; //(Requested Range Not Satisfiable/请求范围无法满足)
	public static String RESULT_CODE_EXPECTATION_FAILED = "417"; 		 	 //(Expectation Failed/期望失败)
	public static String RESULT_CODE_VALID_FAILED = "418"; 		 	 //(输入验证错误)
	
	public static String RESULT_CODE_INTERNAL_SERVER_ERROR = "500"; 		 	 //(Stringernal Server Error/内部服务器错误)
	public static String RESULT_CODE_NOT_IMPLEMENTED = "501"; 		 		 //(Not Implemented/未实现)
	public static String RESULT_CODE_BAD_GATEWAY = "502"; 		 		 	 //(Bad Gateway/错误的网关)
	public static String RESULT_CODE_SERVICE_UNAVAILABLE = "503"; 		 	 //(Service Unavailable/服务无法获得)
	public static String RESULT_CODE_GATEWAY_TIMEOUT = "504"; 		 		 //(Gateway Timeout/网关超时)
	public static String RESULT_CODE_HTTP_VERSION_NOT_SUPPORTED = "505"; 	 //(HTTP Version Not Supported/不支持的 HTTP 版本)
	
	//下常量迁移到了接口com.gudaomai.ekproject.common.Constant @see
	//数据库某一记录的字段值：规范-->table[表]_role[表名]_role_name[字段名]_register_user[字段值]
	//public static String TABLE_ROLE_ROLE_NAME_REGISTER_USER="注册用户";

}
