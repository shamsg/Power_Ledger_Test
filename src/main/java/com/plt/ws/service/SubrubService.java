package com.plt.ws.service;

import java.util.List;

import com.plt.ws.model.request.SubrubsRequestModel;
import com.plt.ws.model.response.SubrubsRest;
import com.plt.ws.shared.dto.SubrubDto;

public interface SubrubService {

	SubrubDto createSubrub(SubrubDto subrubDto);

	List<SubrubDto> getListOfSubrub(String postCode);
}
