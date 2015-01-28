package hhhhhskw.sample.jbatch.jpa;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "empno", nullable = false)
	private int empno;
	
	@Column(name = "ename", length = 10)
	private String ename;
	
	@Column(name = "yomi", length = 20)
	private String yomi;
	
	@Column(name = "job", length = 8)
	private String job;
	
	@Column(name = "mgr")
	private int mgr;
	
	@Column(name = "hiredate")
	private Date hiredate;
	
	@Column(name = "sal", length = 7)
	private int sal;
	
	@Column(name = "comm", length = 7)
	private int comm;
	
	@Column(name = "deptno")
	private int deptno;

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getYomi() {
		return yomi;
	}

	public void setYomi(String yomi) {
		this.yomi = yomi;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public Date getDate() {
		return hiredate;
	}

	public void setDate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", yomi="
				+ yomi + ", job=" + job + ", mgr=" + mgr + ", hiredate="
				+ hiredate + ", sal=" + sal + ", comm=" + comm + ", deptno="
				+ deptno + "]";
	}
	
}
