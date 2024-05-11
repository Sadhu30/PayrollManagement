package dao;

import entity.Payroll;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PayrollServiceImpl implements IPayrollService {
    private Map<Integer, Payroll> payrolls;

    public PayrollServiceImpl() {
        this.payrolls = new HashMap<>();
    }

    @Override
    public void generatePayroll(int employeeId, LocalDate startDate, LocalDate endDate) {
        // Placeholder implementation for generating payroll
        // This method should interact with the database to calculate and store the payroll data
        // For demonstration purposes, we'll print a message
        System.out.println("Placeholder implementation for generating payroll for Employee ID: " + employeeId +
                " for the period from " + startDate + " to " + endDate);
    }

    @Override
    public Payroll getPayrollById(int payrollId) {
        return payrolls.get(payrollId);
    }

    @Override
    public List<Payroll> getPayrollsForEmployee(int employeeId) {
        List<Payroll> employeePayrolls = new ArrayList<>();
        for (Payroll payroll : payrolls.values()) {
            if (payroll.getEmployeeID() == employeeId) {
                employeePayrolls.add(payroll);
            }
        }
        return employeePayrolls;
    }

    @Override
    public List<Payroll> getPayrollsForPeriod(LocalDate startDate, LocalDate endDate) {
        List<Payroll> periodPayrolls = new ArrayList<>();
        for (Payroll payroll : payrolls.values()) {
            LocalDate payrollStartDate = payroll.getPayPeriodStartDate();
            LocalDate payrollEndDate = payroll.getPayPeriodEndDate();
            if (payrollStartDate.isEqual(startDate) || payrollStartDate.isAfter(startDate)) {
                if (payrollEndDate.isEqual(endDate) || payrollEndDate.isBefore(endDate)) {
                    periodPayrolls.add(payroll);
                }
            }
        }
        return periodPayrolls;
    }
}
