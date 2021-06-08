package com.example.dao;

import java.util.List;

import com.example.model.IRSpectrumResult;
import com.example.utils.Operator;

public interface IRSpectrumResultDAO {

	List<IRSpectrumResult> findSpectraResults(String[] columns, Operator[] operators, Object[] params);
}
