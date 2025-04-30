package br.com.unicuritiba.Investimento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicuritiba.Investimento.models.Invest;
import br.com.unicuritiba.Investimento.repositories.InvestRepository;

@RestController
public class InvestController {
	@Autowired
	InvestRepository repository;
	
	@GetMapping("/investimentos")
	public ResponseEntity<List<Invest>> getInvests(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/investimentos/{id}")
	public ResponseEntity<Invest> getInvest(@PathVariable long id){
		return ResponseEntity.ok(repository.findById(id).get());
	}
	
	@PostMapping("/investimentos")
	public ResponseEntity<Invest> saveUser(@RequestBody Invest invest){
		Invest savedInvest = repository.save(invest);
		return ResponseEntity.ok(savedInvest);
	}
	
	@DeleteMapping("/investimentos/{id}")
	public void removeUser(@PathVariable long id, @RequestBody Invest invest) {
		repository.deleteById(id);
	}
	
	@PutMapping("/investimentos/{id}")
	public ResponseEntity<Invest> updateUser(@PathVariable long id, @RequestBody Invest invest){
		invest.setId(id);
		Invest savedInvest = repository.save(invest);
		return ResponseEntity.ok(savedInvest);
	}
}
