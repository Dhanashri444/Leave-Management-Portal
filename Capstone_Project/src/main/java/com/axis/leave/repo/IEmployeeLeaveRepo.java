package com.axis.leave.repo;
/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Dhanashri kale
 * About this Page : IEmployeeLeaveRepo
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.axis.leave.entity.EmployeeLeave;

@Repository(value = "IEmployeeLeaveRepo")
public interface IEmployeeLeaveRepo extends JpaRepository<EmployeeLeave, Integer> {

	@Query("select u from EmployeeLeave u where u.empId= :id")
	public List<EmployeeLeave> findByEmployeeId(@Param("id") int  id);
}
