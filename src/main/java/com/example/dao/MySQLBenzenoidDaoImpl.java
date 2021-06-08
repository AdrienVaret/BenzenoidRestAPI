package com.example.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Benzenoid;
import com.example.utils.Operator;

@Repository("mysql")
public class MySQLBenzenoidDaoImpl implements BenzenoidDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void save(Benzenoid benzenoid) {

		String sql = "INSERT INTO benzenoid VALUES (?, ?, ?, ?, ?, ?)";

		jdbcTemplate.update(sql, benzenoid.getId(), benzenoid.getName(), benzenoid.getNbHexagons(),
				benzenoid.getNbCarbons(), benzenoid.getNbHydrogens(), benzenoid.getIrregularity());
	}

	@Override
	public void update(Benzenoid benzenoid) {

		String sql = "UPDATE benzenoid SET name = ?, nbHexagons = ?, nbCarbons = ?, nbHydrogens = ?, irregularity = ? WHERE id = ?";

		jdbcTemplate.update(sql, benzenoid.getName(), benzenoid.getNbHexagons(), benzenoid.getNbCarbons(),
				benzenoid.getNbHydrogens(), benzenoid.getIrregularity(), benzenoid.getId());

	}

	@Override
	public Optional<Benzenoid> findById(Long id) {
		String sql = "SELECT * FROM benzenoid WHERE id = ?";

		@SuppressWarnings("deprecation")
		Benzenoid benzenoid = jdbcTemplate.queryForObject(sql, new Object[] { id }, (resultSet, i) -> {
			Long benzenoidId = resultSet.getLong("id");
			String name = resultSet.getString("name");
			int nbHexagons = resultSet.getInt("nbHexagons");
			int nbCarbons = resultSet.getInt("nbCarbons");
			int nbHydrogens = resultSet.getInt("nbHydrogens");
			Double irregularity = resultSet.getDouble("irregularity");

			return new Benzenoid(benzenoidId, name, nbHexagons, nbCarbons, nbHydrogens, irregularity);
		});

		return Optional.ofNullable(benzenoid);
	}

	@Override
	public void deleteById(Long id) {

		String sql = "DELETE FROM benzenoid WHERE id=?";
		jdbcTemplate.update(sql, id > 0);
	}

	@Override
	public List<Benzenoid> findAll() {

		String sql = "SELECT * FROM benzenoid";

		return jdbcTemplate.query(sql, (resultSet, i) -> {

			Long id = resultSet.getLong("id");
			String name = resultSet.getString("name");
			int nbHexagons = resultSet.getInt("nbHexagons");
			int nbCarbons = resultSet.getInt("nbCarbons");
			int nbHydrogens = resultSet.getInt("nbHydrogens");
			Double irregularity = resultSet.getDouble("irregularity");

			return new Benzenoid(id, name, nbHexagons, nbCarbons, nbHydrogens, irregularity);
		});
	}

	@Override
	public List<Benzenoid> findBenzenoids(String[] columns, Operator[] operators, Object[] params) {

		StringBuilder query = new StringBuilder();
		query.append("SELECT * FROM benzenoid ");

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

			Long id = resultSet.getLong("id");
			String name = resultSet.getString("name");
			int nbHexagons = resultSet.getInt("nbHexagons");
			int nbCarbons = resultSet.getInt("nbCarbons");
			int nbHydrogens = resultSet.getInt("nbHydrogens");
			Double irregularity = resultSet.getDouble("irregularity");

			return new Benzenoid(id, name, nbHexagons, nbCarbons, nbHydrogens, irregularity);
		});
	}

}
