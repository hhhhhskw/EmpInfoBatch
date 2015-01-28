package hhhhhskw.sample.jbatch;

import hhhhhskw.sample.jbatch.jpa.Employee;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.chunk.ItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Dependent
@Named("EmpInfoWriter")
public class EmpInfoWriter implements ItemWriter {

	private static final Logger logger = Logger.getLogger(EmpInfoWriter.class.getName());
	
	@PersistenceContext(unitName="Employees")
	private EntityManager em;


	@Override
	public void open(Serializable ckpt) throws Exception {
		logger.log(Level.INFO, "EmpInfoWriter#open");
	}

	@Override
	public void writeItems(List<Object> items) throws Exception {
		logger.log(Level.INFO, "EmpInfoWriter#writeItems");

		for (int i = 0; i < items.size(); i++) {
			Employee employee = (Employee) items.get(i);
			// DBにEmployeeインスタンスを永続化する
			em.persist(employee);
			logger.log(Level.INFO, "persistEmployee");
		}
	}
	
	@Override
	public Serializable checkpointInfo() throws Exception {
		logger.log(Level.INFO, "EmpInfoWriter#checkpointInfo");
		return null;
	}

	@Override
	public void close() throws Exception {
		logger.log(Level.INFO, "EmpInfoWriter#close");
	}
}
