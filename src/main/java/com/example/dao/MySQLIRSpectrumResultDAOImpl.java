package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.IRSpectrumResult;
import com.example.utils.Operator;

@Repository("mysql_ir")
public class MySQLIRSpectrumResultDAOImpl implements IRSpectrumResultDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<IRSpectrumResult> findSpectraResults(String[] columns, Operator[] operators, Object[] params) {

		StringBuilder query = new StringBuilder();

		query.append("SELECT * FROM benzenoid b, gaussian_result r ");

		if (columns.length > 0)
			query.append("WHERE ");

		for (int i = 0; i < columns.length; i++) {

			String column = columns[i];
			Operator operator = operators[i];

			String condition;

			if (i == 0)
				condition = column + " " + Operator.getOperatorString(operator) + " " + params[i].toString() + " ";
			else
				condition = " AND " + column + " " + Operator.getOperatorString(operator) + " " + params[i].toString()
						+ " ";

			query.append(condition);
		}

		System.out.println(query);

		return jdbcTemplate.query(query.toString(), (resultSet, i) -> {

			Long benzenoidId = resultSet.getLong("id");
			String name = resultSet.getString("name");
			int nbHexagons = resultSet.getInt("nbHexagons");
			int nbCarbons = resultSet.getInt("nbCarbons");
			int nbHydrogens = resultSet.getInt("nbHydrogens");
			Double irregularity = resultSet.getDouble("irregularity");

			Long idSpectrum = resultSet.getLong("id_gaussian_result");
			String frequencies = resultSet.getString("frequencies");

			return null;
		});
	}

}
