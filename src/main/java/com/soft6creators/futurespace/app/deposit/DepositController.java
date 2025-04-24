package com.soft6creators.futurespace.app.deposit;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositController {
	@Autowired
	private DepositService depositService;
	
	@CrossOrigin(maxAge = 3600)
	@RequestMapping(method = RequestMethod.POST, value = "/deposit")
	public Deposit addDeposit(@RequestBody Deposit deposit) {
		return depositService.addDeposit(deposit);
	}
	
	@CrossOrigin(maxAge = 3600)
	@RequestMapping(method = RequestMethod.PUT, value = "/deposit")
	public Deposit updateDeposit(@RequestBody Deposit deposit) {
		return depositService.addDeposit(deposit);
	}
	
	@CrossOrigin(maxAge = 3600)
	@RequestMapping("/deposit/{depositId}")
	public Optional<Deposit> getDeposit(@PathVariable int depositId) {
		return depositService.getDeposit(depositId);
	}
	
	@CrossOrigin(maxAge = 3600)
	@RequestMapping("/deposit/user/{userEmail}")
	public List<Deposit> getDepositsByUser(@PathVariable String userEmail) {
		return depositService.getDepositsByUser(userEmail);
	}
	
	@CrossOrigin(maxAge = 3600)
	@RequestMapping("/deposits/{status}")
	public List<Deposit> getDepositsByStatus(@PathVariable String status) {
		return depositService.getDepositsByStatus(status);
	}
	
	@CrossOrigin(maxAge = 3600)
	@RequestMapping("/deposits")
	public List<Deposit> getAllDeposits() {
		return depositService.getAllDeposits();
	}
} 