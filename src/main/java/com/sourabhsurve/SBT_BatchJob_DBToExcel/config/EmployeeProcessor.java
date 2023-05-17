package com.sourabhsurve.SBT_BatchJob_DBToExcel.config;

import com.sourabhsurve.SBT_BatchJob_DBToExcel.entity.Employee;
import org.springframework.batch.item.ItemProcessor;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class EmployeeProcessor implements ItemProcessor<Employee,Employee> {

    @Override
    public Employee process(Employee employee) throws Exception {

        String dateOfJoiningStr = employee.getDateOfJoining();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateOfJoining = LocalDate.parse(dateOfJoiningStr, formatter);

        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateOfJoining, currentDate);

        double experience = 0.0;

        if (period.getYears() >= 1) {
            experience = period.getYears() + (period.getMonths() / 12.0);
        } else {
            experience = period.getMonths() / 10.0;
        }

        DecimalFormat df = new DecimalFormat("#.#");
        employee.setExperience(Double.valueOf(df.format(experience)));

        return employee;



//
//        String dateOfJoiningStr = employee.getDateOfJoining();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        LocalDate dateOfJoining = LocalDate.parse(dateOfJoiningStr, formatter);
//
//        LocalDate currentDate = LocalDate.now();
//        Period period = Period.between(dateOfJoining, currentDate);
//
//        double experience = employee.getExperience();
//
//        if (period.getYears() >= 1) {
//            experience = period.getYears() + (period.getMonths() / 12.0);
//        } else {
//            experience += 1.0 / 12.0; // increase experience by 1 month
//        }
//
//        DecimalFormat df = new DecimalFormat("#.#");
//        employee.setExperience(Double.valueOf(df.format(experience)));
//
//        return employee;


    }
}
