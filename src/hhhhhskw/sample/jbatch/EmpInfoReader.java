package hhhhhskw.sample.jbatch;

import hhhhhskw.sample.jbatch.jpa.Employee;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.chunk.ItemReader;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Dependent
@Named("EmpInfoReader")
public class EmpInfoReader implements ItemReader {

	private static final Logger logger = Logger.getLogger(EmpInfoReader.class.getName());

	private EmpInfoCheckpoint checkpoint;

	@PersistenceContext(unitName = "Employees")
	private EntityManager em;

	@Override
	public void open(Serializable ckpt) throws Exception {
		logger.log(Level.INFO, "EmpInfoReader#open");
		if (checkpoint == null) {
			checkpoint = new EmpInfoCheckpoint();
		} else {
			checkpoint = (EmpInfoCheckpoint) ckpt;
		}
	}

	@Override
	public Object readItem() throws Exception {
		logger.log(Level.INFO, "EmpInfoReader#readItem");

		// 1件だけ読む
		if (checkpoint.getNum() == 0) {
			TypedQuery<Employee> query = em.createQuery(
					"SELECT e FROM Employee e WHERE e.empno = 2001", Employee.class);
			Employee emp = query.getSingleResult();
			checkpoint.increase();
			return emp;
		}
		return null;
	}

	@Override
	public void close() throws Exception {
		logger.log(Level.INFO, "EmpInfoReader#close");
	}

	@Override
	public Serializable checkpointInfo() throws Exception {
		logger.log(Level.INFO, "EmpInfoReader#checkpointInfo");
		return null;
	}

}
