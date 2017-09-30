package com.mhw.space.util.system.validate;

import javax.servlet.http.HttpServletRequest;

public interface IValidator {

	public void doValidate(HttpServletRequest request) throws ValidateException;
}
