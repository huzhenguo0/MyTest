package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EmpDAO;
import com.entity.Emp;
import com.service.EmpService;
@Service
@Transactional
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDAO empDAO;
	@Override
	public List<Emp> findAll() {
		return empDAO.selectAll();
	}

}
