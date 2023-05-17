package com.sourabhsurve.SBT_BatchJob_DBToExcel.repository;
import com.sourabhsurve.SBT_BatchJob_DBToExcel.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
