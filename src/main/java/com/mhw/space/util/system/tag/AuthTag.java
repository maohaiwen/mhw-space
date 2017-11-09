package com.mhw.space.util.system.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import com.mhw.space.model.user.UserEntity;

public class AuthTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	private PageContext pageContext;

	@Override
	public int doStartTag() throws JspException {
		UserEntity userEntity = (UserEntity) pageContext.getSession().getAttribute("user");
		if(userEntity == null) {
			return TagSupport.SKIP_BODY;
		}
		return TagSupport.EVAL_BODY_INCLUDE;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}
	
}
