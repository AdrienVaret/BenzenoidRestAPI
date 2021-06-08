package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.model.Benzenoid;
import com.example.utils.Operator;

@Repository("memoire")
public class BenzenoidDAOImpl implements BenzenoidDAO {

	private ArrayList<Benzenoid> benzenoids = new ArrayList<>();

	@Override
	public void save(Benzenoid benzenoid) {
		benzenoids.add(benzenoid);
	}

	@Override
	public void update(Benzenoid benzenoid) {

		for (Benzenoid benzenoidDB : benzenoids) {
			if (benzenoidDB.getId().equals(benzenoid.getId())) {

				int index = benzenoids.indexOf(benzenoidDB);
				benzenoids.set(index, new Benzenoid(benzenoid.getId(), benzenoid.getName(), benzenoid.getNbHexagons(),
						benzenoid.getNbCarbons(), benzenoid.getNbHydrogens(), benzenoid.getIrregularity()));
			}
		}
	}

	@Override
	public Optional<Benzenoid> findById(Long id) {
		return benzenoids.stream().filter(benzenoid -> benzenoid.getId().equals(id)).findFirst();
	}

	@Override
	public void deleteById(Long id) {
		benzenoids.remove(findById(id).get());
	}

	@Override
	public List<Benzenoid> findAll() {
		return benzenoids;
	}

	@Override
	public List<Benzenoid> findBenzenoids(String[] columns, Operator[] operators, Object[] params) {
		return null;
	}

}
