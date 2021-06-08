package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.dao.BenzenoidDAO;
import com.example.model.Benzenoid;
import com.example.model.IRSpectrumResult;
import com.example.utils.Operator;

@Service
public class BenzenoidServiceImpl implements BenzenoidService {

	@Autowired
	@Qualifier("mysql")
	BenzenoidDAO benzenoidDAO;

	@Override
	public void save(Benzenoid benzenoid) {
		benzenoidDAO.save(benzenoid);
	}

	@Override
	public void update(Benzenoid benzenoid) {
		benzenoidDAO.update(benzenoid);
	}

	@Override
	public Optional<Benzenoid> findById(Long id) {
		return benzenoidDAO.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		benzenoidDAO.deleteById(id);
	}

	@Override
	public List<Benzenoid> findAll() {
		return benzenoidDAO.findAll();
	}

	@Override
	public List<Benzenoid> findBenzenoids(String[] columns, Operator[] operators, Object[] params) {
		return benzenoidDAO.findBenzenoids(columns, operators, params);
	}

	@Override
	public List<IRSpectrumResult> findIRSpectra(String[] columns, Operator[] operators, Object[] params) {
		return benzenoidDAO.findIRSpectra(columns, operators, params);
	}

}
