package com.bvlsh.audit.ui.beans;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.bvlsh.audit.ui.utils.DateUtil;
@RequestScoped
@ManagedBean
public class FormatBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public String formatDate(Date date) 
	{
		return DateUtil.formatDate(date);
	}

	public String formatTimestamp(Date date) 
	{
		return DateUtil.formatTimestamp(date);
	}

}
