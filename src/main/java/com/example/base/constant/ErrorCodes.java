package com.example.base.constant;

public class ErrorCodes {
	//version
	public static final String VERSION_1 = "1.0.0";
	
	//scope
	public static final String SCOPE_GENERAL            = "general";

	//errorCode
    public static final int SUCCESS                     = 200;
    public static final int SUCCESS_MORE_DATA           = 201;

    public static final int ERROR_GENERAL_EXCEPTION     = 500;
    public static final int ERROR_LOCK_FAILED           = 501;
    public static final int ERROR_SQL_EXCEPTION         = 502;
    public static final int ERROR_UNSUPPORTED_USAGE     = 503;
    public static final int ERROR_CLASS_NOT_FOUND       = 504;
    public static final int ERROR_ACCESS_DENIED         = 505;
    public static final int ERROR_INVALID_PARAMETER     = 506;
    public static final int ERROR_OUT_OF_STORAGE        = 507;

}
