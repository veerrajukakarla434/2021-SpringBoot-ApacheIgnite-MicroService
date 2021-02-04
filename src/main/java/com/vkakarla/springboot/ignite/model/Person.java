package com.vkakarla.springboot.ignite.model;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.ignite.cache.affinity.AffinityKey;
import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.apache.ignite.cache.query.annotations.QueryTextField;

public class Person implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** */
    private static final AtomicLong ID_GEN = new AtomicLong();

    /** Person ID (indexed). */
    @QuerySqlField(index = true)
    public Long id;

    /** First name (not-indexed). */
    @QuerySqlField
    public String firstName;

    /** Last name (not indexed). */
    @QuerySqlField
    public String lastName;

    /** Resume text (create LUCENE-based TEXT index for this field). */
    @QueryTextField
    public String phone;

    /** Salary (indexed). */
    @QuerySqlField(index = true)
    public double salary;

    /** Custom cache key to guarantee that person is always collocated with its organization. */
    private transient AffinityKey<Long> key;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", salary=" + salary + "]";
	}

}
