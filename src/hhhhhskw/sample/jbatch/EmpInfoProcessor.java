package hhhhhskw.sample.jbatch;

import hhhhhskw.sample.jbatch.jpa.Employee;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("EmpInfoProcessor")
public class EmpInfoProcessor implements ItemProcessor {

	private static final Logger logger = Logger.getLogger(EmpInfoReader.class.getName());

	@Override
	public Object processItem(Object obj) throws Exception {
		logger.log(Level.INFO, "EmpInfoProcessor#processItem");

		if (obj instanceof Employee) {
			Employee emp = (Employee) obj;
			emp.setComm(10000);
			return emp;
		}else {
			return obj;
		}
	}
}
