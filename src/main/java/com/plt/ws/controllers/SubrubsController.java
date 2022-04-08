package com.plt.ws.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;
import com.plt.ws.model.request.SubrubsRequestModel;
import com.plt.ws.model.response.SubrubsRest;
import com.plt.ws.service.SubrubService;
import com.plt.ws.shared.dto.SubrubDto;

@RestController
@RequestMapping("/subrubs")
public class SubrubsController {
	
	
	@Autowired
	SubrubService subrubService;

	@PostMapping(
			consumes =  { 
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
			}, 
			produces =  { 
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
					}  )
	public ResponseEntity<SubrubsRest> createSubrub( @RequestBody SubrubsRequestModel subrubsDetails)
	{
		SubrubsRest returnValue = new SubrubsRest();
		ModelMapper modelMapper = new ModelMapper();
		SubrubDto subrubDto = modelMapper.map(subrubsDetails, SubrubDto.class);
		SubrubDto createSubrub = subrubService.createSubrub(subrubDto);
		returnValue = modelMapper.map(createSubrub, SubrubsRest.class);
		return new ResponseEntity<SubrubsRest>(returnValue, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{postCode}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SubrubDto>> getSubrubsList(@PathVariable String postCode) {
		List<SubrubDto> returnValue = new ArrayList<SubrubDto>();

		List <SubrubDto> getSubrubs = subrubService.getListOfSubrub(postCode);
		
		List<SubrubDto> sortedSubrubs = getSubrubs.stream().sorted().collect(Collectors.toList());
		ModelMapper modelMapper = new ModelMapper();
		returnValue = ObjectMapperUtils.mapAll(sortedSubrubs, SubrubDto.class);
		return new ResponseEntity<List<SubrubDto>>(returnValue, HttpStatus.OK);
	}	
}
