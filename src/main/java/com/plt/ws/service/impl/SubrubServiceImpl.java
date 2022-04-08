package com.plt.ws.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plt.ws.document.SubrubDocument;
import com.plt.ws.io.repo.SubrubRepository;
import com.plt.ws.model.response.SubrubsRest;
import com.plt.ws.model.response.UserRest;
import com.plt.ws.service.SubrubService;
import com.plt.ws.shared.Utils;
import com.plt.ws.shared.dto.SubrubDto;

@Service
public class SubrubServiceImpl implements SubrubService{

	Map<String, UserRest> users;
	Map<String, SubrubsRest> subrubs;
	Utils utils;
	
	@Autowired
	private SubrubRepository subrubRepository;
	
	public SubrubServiceImpl() {}
	
	@Autowired
	public SubrubServiceImpl(Utils utils)
	{
		this.utils =utils;
	}


	@Override
	public SubrubDto createSubrub(SubrubDto subrubDto) {
		String uniqueId = utils.generateUniqueId();
		SubrubDto returnValue = new SubrubDto();
		ModelMapper modelMapper = new ModelMapper();
		subrubDto.setId(uniqueId);
		SubrubDocument subrubDoc = modelMapper.map(subrubDto, SubrubDocument.class);
		if(subrubs == null) subrubs = new HashMap<>();
		SubrubDocument sotredSubrub = subrubRepository.save(subrubDoc);
		returnValue = modelMapper.map(sotredSubrub, SubrubDto.class);
		return returnValue;
	}

	@Override
	public List<SubrubDto> getListOfSubrub(String postCode) {
		List<SubrubDto> returnValue = new ArrayList<SubrubDto>();
		returnValue = subrubRepository.findByZipCode(postCode);
		return returnValue;
	}

}
