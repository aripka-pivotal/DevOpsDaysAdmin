package io.pivotal.devopsdays.repository;

import org.springframework.data.repository.CrudRepository;

import io.pivotal.devopsdays.entity.LeadCapture;

public interface LeadCaptureRepository extends CrudRepository<LeadCapture, Long>{

}
