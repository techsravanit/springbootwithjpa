package com.purpletalk.helper;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.purpletalk.entities.TestUser;

@Repository
public interface UserRepositary extends JpaRepository<TestUser, String>{
	
	// native query example and returns a list
	@Query(value="select *from-----",nativeQuery=true)
	List<TestUser> getUsersByXyz();
	
	// native query example and returns a stream
    @Query("select u from TestUser u where u.email = :email")
    Stream<TestUser> findByEmailReturnStream(@Param("email") String email);
    
    List<TestUser> findByNameAndEmail(String name, String email);
    
   //TestUser findById(String id);

}
