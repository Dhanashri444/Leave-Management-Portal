package com.axis.leave.repo;
/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Dhanashri kale
 * About this Page : IEmployeeRepo
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.axis.leave.entity.Employee;
@Repository(value = "IEmployeeRepo")
public interface IEmployeeRepo extends JpaRepository<Employee, String>{ 

	@Query(value = "select EMP_ID from emp_table where EMP_ID=(select max(EMP_ID) from Employee)" , nativeQuery = true)
	 int findMaxValue();
	
	@Query(value = "UPDATE emp_table SET  SICK_LEAVE= SICK_LEAVE- :period where EMP_ID= :empId" , nativeQuery = true)
	boolean updateSickLeave(@Param("period") int period , @Param("empId") int empId);
	
	@Query(value = "UPDATE emp_table SET  CASUAL_LEAVE= CASUAL_LEAVE- :period where EMP_ID= :empId" , nativeQuery = true)
	boolean updateCasualLeave(@Param("period") int period , @Param("empId") int empId);
	
	@Query(value = "UPDATE emp_table SET  PERSONAL_LEAVE= PERSONAL_LEAVE- :period where EMP_ID= :empId" , nativeQuery = true)
	boolean updatePersonalLeave(@Param("period") int period , @Param("empId") int empId);
	
	@Query(value = "UPDATE emp_table SET  MATERNITY_LEAVE= MATERNITY_LEAVE- :period where EMP_ID= :empId" , nativeQuery = true)
	boolean updateMaternityLeave(@Param("period") int period , @Param("empId") int empId);
	
	@Query(value = "UPDATE emp_table SET  PATERNITY_LEAVE= PATERNITY_LEAVE- :period where EMP_ID= :empId" , nativeQuery = true)
	boolean updatePaternityLeave(@Param("period") int period , @Param("empId") int empId);
	
	@Query(value = "UPDATE emp_table SET  MARRIAGE_LEAVE= MARRIAGE_LEAVE- :period where EMP_ID= :empId" , nativeQuery = true)
	boolean updateMarriageLeave(@Param("period") int period , @Param("empId") int empId);
	
	@Query(value = "UPDATE emp_table SET  ADOPTION_LEAVE= ADOPTION_LEAVE- :period where EMP_ID= :empId" , nativeQuery = true)
	boolean updateAdoptionLeave(@Param("period") int period , @Param("empId") int empId);
	
}
