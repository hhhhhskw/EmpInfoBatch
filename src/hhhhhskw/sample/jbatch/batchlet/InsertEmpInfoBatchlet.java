package hhhhhskw.sample.jbatch.batchlet;

import hhhhhskw.sample.jbatch.EmpInfoWriter;
import hhhhhskw.sample.jbatch.jpa.Employee;

import java.sql.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.batch.api.Batchlet;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@Dependent
@Named("InsertEmpInfoBatchlet")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class InsertEmpInfoBatchlet implements Batchlet {

	private static final Logger logger = Logger.getLogger(EmpInfoWriter.class
			.getName());

	@PersistenceContext(unitName = "Employees")
	private EntityManager em;

	@Resource
	UserTransaction utx;

	@Override
	public String process() throws Exception {
		logger.log(Level.INFO, "InsertEmpInfoBatchlet#process");

		utx.begin();

		// Insertする従業員情報
		Employee employee = getEmp();

		// DBにEmployeeインスタンスを永続化する
		em.persist(employee);
		utx.commit();

		return null;
	}

	@Override
	public void stop() throws Exception {

	}

	private Employee getEmp() {
		Employee employees = new Employee();
		employees.setEmpno(2001);
		employees.setEname("太郎");
		employees.setYomi("taro");
		employees.setJob("営業");
		employees.setMgr(1001);
		employees.setSal(200000);
		employees.setDeptno(10);
		employees.setDate(getNowDate());
		return employees;
	}

	private Date getNowDate() {
		Calendar cal = Calendar.getInstance();
		Date date = new Date(cal.getTimeInMillis());
		return date;
	}

}
