package com.carefirst.carefirstapp.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "employee", schema = "INVENTORY1")
@Embeddable
public class Employee {
	
	

	@Id
	@Column
	@GeneratedValue(generator="seqGen")
	@SequenceGenerator(name="seqGen",sequenceName="emp_seq_id", allocationSize=1)
	private long employeeId;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String emailAddress;
	@Column
	private String phone;
	@Column
	private Date birthDate;
	@Column
	private String jobTitle;
	@Column
	private String department;
	@Column
	private String location;
	@Column
	private Date startDate;
	@Column
	private String managerReporting;
	
}
