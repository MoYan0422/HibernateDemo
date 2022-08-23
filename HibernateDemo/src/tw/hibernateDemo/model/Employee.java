package tw.hibernateDemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	
	@Column(name = "employee_name")
	private String employeeName ;
	
	@Column(name = "salary")
	private Integer salary;
	
	@Column(name = "vacation")
	private Integer vacation;
	

	public Employee() {
		// TODO Auto-generated constructor stu
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public Integer getSalary() {
		return salary;
	}


	public void setSalary(Integer salary) {
		this.salary = salary;
	}


	public Integer getVacation() {
		return vacation;
	}


	public void setVacation(Integer vacation) {
		this.vacation = vacation;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName + ", salary=" + salary + ", vacation=" + vacation
				+ "]";
	}
	

}
