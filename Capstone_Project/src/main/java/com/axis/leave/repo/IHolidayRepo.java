package com.axis.leave.repo;
/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Dhanashri kale
 * About this Page :IHolidayRepo
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.axis.leave.entity.Holiday;
@Repository(value = "IHolidayRepo")
public interface IHolidayRepo extends JpaRepository<Holiday, Integer> {
	
	@Query(value = "select * from Holiday where EMP_ID= :empId" , nativeQuery = true)
	List<Holiday> findByEmpId(@Param("empId") int empId);

}
