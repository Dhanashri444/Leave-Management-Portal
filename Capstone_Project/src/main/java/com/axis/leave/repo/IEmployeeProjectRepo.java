package com.axis.leave.repo;
/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Dhanashri kale
 * About this Page : IEmployeeProjectRepo
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.axis.leave.entity.EmployeeProject;

@Repository(value = "IEmployeeProjectRepo")
public interface IEmployeeProjectRepo extends JpaRepository<EmployeeProject, Integer>{ 

	@Query(value = "select * from EmployeeProject where EMP_ID= :empId" , nativeQuery = true)
	List<EmployeeProject> findByEmpId(@Param("empId") int empId);
}
