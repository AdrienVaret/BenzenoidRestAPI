package com.example.dao;

import java.util.List;
import java.util.Optional;

import com.example.model.Benzenoid;
import com.example.model.IRSpectrumResult;
import com.example.utils.Operator;

public interface BenzenoidDAO {

	void save(Benzenoid benzenoid);

	void update(Benzenoid benzenoid);

	Optional<Benzenoid> findById(Long id);

	void deleteById(Long id);

	List<Benzenoid> findAll();

	List<Benzenoid> findBenzenoids(String[] columns, Operator[] operators, Object[] params);

	List<IRSpectrumResult> findIRSpectra(String[] columns, Operator[] operators, Object[] params);
}
