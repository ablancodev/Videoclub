package com.ablancodev.videoclub.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ablancodev.videoclub.entity.Movie;

@Repository( "movieJpaRepository" )
public interface MovieJpaRepository extends JpaRepository<Movie, Serializable> {

}
