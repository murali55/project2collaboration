package org.in.persistanceClzs;

public class ErrorClz 
{
private int errorCode;
private String errorMessage;

public ErrorClz(int errorCode, String errorMessage) 
{
	super();
	this.errorCode=errorCode;
	this.errorMessage= errorMessage;
	
}
public int getErrorCode() 
{
	return errorCode;
}
public void setErrorCode(int errorCode) 
{
	this.errorCode = errorCode;
}
public String getErrorMessage() 
{
	return errorMessage;
}
public void setErrorMessage(String errorMessage) 
{
	errorMessage = errorMessage;
}

}
