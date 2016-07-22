package io.pivotal.devopsdays.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import io.pivotal.devopsdays.entity.DrawingRegistrant;
import java.lang.String;
import java.util.List;

public interface DrawingRegistrantRepository extends CrudRepository<DrawingRegistrant, Long> {

	public List<DrawingRegistrant> findByTicketNumber(String ticketnumber);
	
	@Query(nativeQuery=true, value="select * from drawing_registrant ORDER BY rand() limit 1")
	public DrawingRegistrant getWinner();
 
}
