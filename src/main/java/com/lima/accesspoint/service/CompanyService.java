package com.lima.accesspoint.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lima.accesspoint.dto.request.CompanyDTO;
import com.lima.accesspoint.exception.IdNotFoundException;
import com.lima.accesspoint.mapper.CompanyMapper;
import com.lima.accesspoint.model.Company;
import com.lima.accesspoint.repository.CompanyRepository;
import com.lima.accesspoint.response.ResponseMessage;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private ResponseMessage responseMessage;
	
	@Autowired
	private final CompanyMapper companyMapper = CompanyMapper.INSTANCE;
	
	public List<CompanyDTO> listAll() {
		 List<Company> company = companyRepository.findAll();
		 return company.stream()
				 .map(companyMapper::toDTO)
				 .collect(Collectors.toList());
	}
	
	public CompanyDTO listId(Long id) throws IdNotFoundException {
		Company companyId = ifNotExistId(id);
		return companyMapper.toDTO(companyId);
	}
	
	public ResponseMessage save(CompanyDTO companyDTO) {
		Company saveCompany = companyMapper.toModel(companyDTO);
		Company companySave = companyRepository.save(saveCompany);
		return responseMessage.createMessage("The company was created successfully with id ", companySave.getId());
	}
	
	public ResponseMessage update(Long id, CompanyDTO companyDTO) throws IdNotFoundException {
		ifNotExistId(id);
		Company updtCompany = companyMapper.toModel(companyDTO);
		Company companyUpdt = companyRepository.save(updtCompany);
		return responseMessage.createMessage("The company was updated successfully with id ", companyUpdt.getId());
	}
	
	public void delete(Long id) throws IdNotFoundException {
		ifNotExistId(id);
		companyRepository.deleteById(id);
	}
	
	public Company ifNotExistId(Long id) throws IdNotFoundException {
		return companyRepository.findById(id)
				.orElseThrow(()->new IdNotFoundException(id));
	}

}






