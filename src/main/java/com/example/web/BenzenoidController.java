package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Benzenoid;
import com.example.model.BenzenoidData;
import com.example.service.BenzenoidService;
import com.example.utils.Operator;

@RestController
@RequestMapping("/benzenoids")
public class BenzenoidController {

	@Autowired
	BenzenoidService service;

	@GetMapping("/")
	public List<Benzenoid> index() {
		return service.findAll();
	}

	@PostMapping
	public void save(@RequestBody Benzenoid benzenoid) {
		service.save(benzenoid);
	}

	@GetMapping("/{id}")
	public Benzenoid findById(@PathVariable Long id) {
		return service.findById(id).get();
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}

	@PutMapping("/{id}")
	public void update(@RequestBody Benzenoid newBenzenoid, @PathVariable Long id) {

		Benzenoid benzenoid = service.findById(id).get();
		benzenoid.setName(newBenzenoid.getName());
		service.update(benzenoid);
	}

	@PostMapping("/find")
	public List<Benzenoid> find(@RequestBody BenzenoidData benzenoidData) {

		System.out.println(benzenoidData.getId() + " " + benzenoidData.getName() + " " + benzenoidData.getNbHexagons()
				+ " " + benzenoidData.getNbCarbons() + " " + benzenoidData.getNbHydrogens() + " "
				+ benzenoidData.getIrregularity());

		System.out.println(benzenoidData.getOperatorId() + " " + benzenoidData.getOperatorName() + " "
				+ benzenoidData.getOperatorHexagons() + " " + benzenoidData.getOperatorCarbons() + " "
				+ benzenoidData.getOperatorHydrogens() + " " + benzenoidData.getOperatorIrregularity());

		int nbParameters = countParameters(benzenoidData);

		System.out.println(nbParameters + " parameters");

		String[] columns = new String[nbParameters];
		Operator[] operators = new Operator[nbParameters];
		Object[] values = new Object[nbParameters];

		int index = 0;

		if (benzenoidData.getId() != -1) {
			columns[index] = "id";
			operators[index] = Operator.getOperator(benzenoidData.getOperatorId());
			values[index] = benzenoidData.getId();
			index++;
		}

		if (!benzenoidData.getName().equals("none")) {
			columns[index] = "name";
			operators[index] = Operator.getOperator(benzenoidData.getOperatorName());
			values[index] = benzenoidData.getName();
			index++;
		}

		if (benzenoidData.getNbHexagons() > 0) {
			columns[index] = "nbHexagons";
			operators[index] = Operator.getOperator(benzenoidData.getOperatorHexagons());
			values[index] = benzenoidData.getNbHexagons();
			index++;
		}

		if (benzenoidData.getNbCarbons() > 0) {
			columns[index] = "nbCarbons";
			operators[index] = Operator.getOperator(benzenoidData.getOperatorCarbons());
			values[index] = benzenoidData.getNbCarbons();
			index++;
		}

		if (benzenoidData.getNbHydrogens() > 0) {
			columns[index] = "nbHydrogens";
			operators[index] = Operator.getOperator(benzenoidData.getOperatorHydrogens());
			values[index] = benzenoidData.getNbHydrogens();
			index++;
		}

		if (benzenoidData.getIrregularity() >= 0.0) {
			columns[index] = "irregularity";
			operators[index] = Operator.getOperator(benzenoidData.getOperatorIrregularity());
			values[index] = benzenoidData.getIrregularity();
			index++;
		}
		nbParameters++;

		return service.findBenzenoids(columns, operators, values);
	}

	private int countParameters(BenzenoidData benzenoidData) {

		int nbParameters = 0;

		if (benzenoidData.getId() != -1)
			nbParameters++;

		if (!benzenoidData.getName().equals("none"))
			nbParameters++;

		if (benzenoidData.getNbHexagons() > 0)
			nbParameters++;

		if (benzenoidData.getNbCarbons() > 0)
			nbParameters++;

		if (benzenoidData.getNbHydrogens() > 0)
			nbParameters++;

		if (benzenoidData.getIrregularity() >= 0.0)
			nbParameters++;

		return nbParameters;

	}
}
