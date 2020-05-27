package com.spring.myschool.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.myschool.restful.model.Course;
import com.spring.myschool.restful.model.Course_content;
import com.spring.myschool.restful.model.Course_progress;
import com.spring.myschool.restful.model.Exercice;
import com.spring.myschool.restful.model.Exercice_progress;
import com.spring.myschool.restful.model.Listchoices;
import com.spring.myschool.restful.model.LogActivity;
import com.spring.myschool.restful.model.Payement;
import com.spring.myschool.restful.model.Qcm;
import com.spring.myschool.restful.model.User;
import com.spring.myschool.restful.dao.CourseDao;
import com.spring.myschool.restful.dao.LogDao;
import com.spring.myschool.restful.dao.PayementDao;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogDao logdao;
	
	@Transactional
	@Override
	public void saveLog(LogActivity activity) {
		logdao.saveLog(activity);
	}

	@Override
	public List<LogActivity> getLog(User user) {
		
		return logdao.getLog(user);
	}

}
