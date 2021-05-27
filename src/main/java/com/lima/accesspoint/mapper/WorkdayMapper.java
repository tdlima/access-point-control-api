package com.lima.accesspoint.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.lima.accesspoint.dto.request.WorkdayDTO;
import com.lima.accesspoint.model.Workday;

@Mapper(componentModel = "spring")
public interface WorkdayMapper {
	
	WorkdayMapper INSTANCE = Mappers.getMapper(WorkdayMapper.class);
	
	Workday toModel(WorkdayDTO workdayDTO);
	
	WorkdayDTO toDTO(Workday workday);

}
