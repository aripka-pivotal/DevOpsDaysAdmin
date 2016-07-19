package io.pivotal.devopsdays.repository;

import org.springframework.data.repository.CrudRepository;

import io.pivotal.devopsdays.entity.DrawingRegistrant;

public interface DrawingRegistrantRepository extends CrudRepository<DrawingRegistrant, Long> {

}
