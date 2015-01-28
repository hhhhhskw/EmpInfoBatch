package hhhhhskw.sample.jbatch;

import java.io.Serializable;

public class EmpInfoCheckpoint implements Serializable {

	private static final long serialVersionUID = 1L;

	private long num = 0;

	public void increase() {
		num++;
	}

	public long getNum() {
		return num;
	}
}
