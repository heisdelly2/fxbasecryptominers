package com.soft6creators.futurespace.app.deposit;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft6creators.futurespace.app.account.Account;
import com.soft6creators.futurespace.app.account.AccountRepository;
import com.soft6creators.futurespace.app.crypto.Crypto;
import com.soft6creators.futurespace.app.crypto.CryptoRepository;

@Service
public class DepositService {
	@Autowired
	private DepositRepository depositRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CryptoRepository cryptoRepository;
	
	public Deposit addDeposit(Deposit deposit) {
		if (deposit.getStatus() != null && deposit.getStatus().equalsIgnoreCase("Completed")) {
			// Update account balance for completed deposits
			Optional<Account> account = accountRepository.findById(deposit.getUser().getAccount().getAccountId());
			if (account.isPresent()) {
				account.get().setAccountBalance(account.get().getAccountBalance() + deposit.getAmount());
				accountRepository.save(account.get());
			}
		}
		return depositRepository.save(deposit);
	}
	
	public Optional<Deposit> getDeposit(int depositId) {
		return depositRepository.findById(depositId);
	}
	
	public List<Deposit> getDepositsByUser(String userEmail) {
		return depositRepository.findByUserEmail(userEmail);
	}
	
	public List<Deposit> getDepositsByStatus(String status) {
		return depositRepository.findAllByStatus(status);
	}
	
	public List<Deposit> getAllDeposits() {
		return (List<Deposit>) depositRepository.findAll();
	}
} 