package com.axis.leave.repo;
/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Dhanashri kale
 * About this Page : IHrLeaveRepo
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.axis.leave.entity.HrLeave;
@Repository(value = "IHrLeaveRepo")
public interface IHrLeaveRepo extends JpaRepository<HrLeave, Integer>{ 
	
	@Query("select u from HrLeave u where u.empId= :id")
	public List<HrLeave> findByEmployeeId(@Param("id") int  id);

}
