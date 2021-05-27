package com.lima.accesspoint.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lima.accesspoint.dto.request.WorkdayDTO;
import com.lima.accesspoint.exception.IdNotFoundException;
import com.lima.accesspoint.mapper.WorkdayMapper;
import com.lima.accesspoint.model.Workday;
import com.lima.accesspoint.repository.WorkdayRepository;
import com.lima.accesspoint.response.ResponseMessage;

@Service
public class WorkdayService {
	
	@Autowired
	private WorkdayRepository workdayRepository;
	
	@Autowired
	private ResponseMessage responseMessage;
	
	@Autowired
	private final WorkdayMapper workdayMapper = WorkdayMapper.INSTANCE;

	public List<WorkdayDTO> listAll() {
		List<Workday> workdays = workdayRepository.findAll();
		return workdays.stream()
				.map(workdayMapper::toDTO)
				.collect(Collectors.toList());
	}

	public WorkdayDTO listId(Long id) throws IdNotFoundException {
		Workday workday = ifNotExistId(id);
		return workdayMapper.toDTO(workday);
	}

	public ResponseMessage save(WorkdayDTO workdayDTO) {
		Workday saveWorkday = workdayMapper.toModel(workdayDTO);
		Workday workdaySave = workdayRepository.save(saveWorkday);
		return responseMessage.createMessage("The workday was created successfully with id ", workdaySave.getId());
	}

	public ResponseMessage update(Long id, WorkdayDTO workdayDTO) throws IdNotFoundException {
		ifNotExistId(id);
		Workday updtWorkday = workdayMapper.toModel(workdayDTO);
		Workday workdayUpdt = workdayRepository.save(updtWorkday);
		return responseMessage.createMessage("The workday was updated successfully with id ", workdayUpdt.getId());
	}

	public void delete(Long id) throws IdNotFoundException {
		ifNotExistId(id);
		workdayRepository.deleteById(id);
	}

	public Workday ifNotExistId(Long id) throws IdNotFoundException {
		return workdayRepository.findById(id)
				.orElseThrow(()-> new IdNotFoundException(id));
	}

}
