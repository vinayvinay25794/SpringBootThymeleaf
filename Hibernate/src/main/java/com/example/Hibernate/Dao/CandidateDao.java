package com.example.Hibernate.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hibernate.Pojo.Candidate;


public interface CandidateDao extends JpaRepository<Candidate, Long>{

}
