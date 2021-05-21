package com.lima.accesspoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lima.accesspoint.exception.IdNotFoundException;
import com.lima.accesspoint.model.Company;
import com.lima.accesspoint.repository.CompanyRepository;
import com.lima.accesspoint.service.response.ResponseMessage;

import lombok.Data;

@Service
@Data
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public CompanyService(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	public List<Company> listAll() {
		 return companyRepository.findAll();
	}
	
	public Company listId(Long id) throws IdNotFoundException {
		Company companyId = ifNotExistId(id);
		return companyId;
	}
	
	public ResponseMessage create(Company company) {
		Company saveCompany = companyRepository.save(company);
		return createMessage("The company was created successfully with id ", saveCompany.getId());
	}
	
	public ResponseMessage update(Long id, Company company) throws IdNotFoundException {
		ifNotExistId(id);
		Company updateCompany = companyRepository.save(company);
		return createMessage("The company was updated successfully with id ", updateCompany.getId());
	}
	
	public void delete(Long id) throws IdNotFoundException {
		ifNotExistId(id);
		companyRepository.deleteById(id);
	}
	
	public Company ifNotExistId(Long id) throws IdNotFoundException {
		return companyRepository.findById(id)
				.orElseThrow(()->new IdNotFoundException(id));
	}
	
	public ResponseMessage createMessage(String message, Long id) {
		return ResponseMessage.builder()
				.message(message + id)
				.build();
	}
	
}






