package com.app.inventory.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.inventory.model.Dosar;

public interface DosarRepository extends JpaRepository<Dosar, Long> {
	List<Dosar> findByInventar_Id(Long inventarId);
	boolean existsByInventar_IdAndNumarCriteriu(Long inventarId, String numarCriteriu);
	 @Query("select d.numarCriteriu from Dosar d " +
	           "where d.inventar.id = :inventarId and d.numarCriteriu in :nums")
	    List<Integer> findExistingNumarCriteriuIn(@Param("inventarId") Long inventarId,
	                                              @Param("nums") Collection<Integer> nums);

}
