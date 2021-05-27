package com.lima.accesspoint.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.lima.accesspoint.dto.request.CompanyDTO;
import com.lima.accesspoint.model.Company;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
	
	CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);
	
	Company toModel(CompanyDTO companyDTO);
	
	CompanyDTO toDTO(Company company);

}
