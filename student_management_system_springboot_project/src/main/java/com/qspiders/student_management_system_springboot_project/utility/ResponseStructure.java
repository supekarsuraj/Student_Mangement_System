package  com.qspiders.student_management_system_springboot_project.utility;

public class ResponseStructure<T> {
	private String message;
	private int status;
	private T data;

	public String getMessage() {
		return message;
	}

	public int getStatus() {
		return status;
	}

	public T getData() {
		return data;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setData(T data) {
		this.data = data;
	}

}
