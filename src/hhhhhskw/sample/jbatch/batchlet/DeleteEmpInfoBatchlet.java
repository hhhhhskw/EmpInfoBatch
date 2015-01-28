package hhhhhskw.sample.jbatch.batchlet;

import hhhhhskw.sample.jbatch.jpa.Employee;

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
@Named("DeleteEmpInfoBatchlet")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DeleteEmpInfoBatchlet implements Batchlet {

	private static final Logger logger = Logger.getLogger(DeleteEmpInfoBatchlet.class.getName());

	@PersistenceContext(unitName = "Employees")
	private EntityManager em;

	@Resource
	UserTransaction utx;

	@Override
	public String process() throws Exception {
		logger.log(Level.INFO, "DeleteEmpInfoBatchlet#process#begin");

		utx.begin();
		Employee emp = getEmp();

		Employee toBeRemoved = em.merge(emp);
		em.remove(toBeRemoved);
		utx.commit();

		logger.log(Level.INFO, "DeleteEmpInfoBatchlet#process#commit");

		return "COMPLETED";
	}

	private Employee getEmp() {
		Employee employees = new Employee();
		employees.setEmpno(2001);
		return employees;
	}

	@Override
	public void stop() throws Exception {

	}
}
