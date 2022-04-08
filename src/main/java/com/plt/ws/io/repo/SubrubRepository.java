package com.plt.ws.io.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.plt.ws.document.SubrubDocument;
import com.plt.ws.shared.dto.SubrubDto;

@Repository
public interface SubrubRepository extends MongoRepository<SubrubDocument, Long> {

	List<SubrubDto> findByZipCode(String postCode);

}
