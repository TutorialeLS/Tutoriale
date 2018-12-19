package app;

public class Task implements Comparable<Task>{
	private String name;
	private String description;
	private Priority priority;
	public enum Priority {
		LOW, MODERATE, HIGH
	}
	
	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    public Task(String name, String description, Priority priority) {
        setName(name);
        setDescription(description);
        setPriority(priority);
    }
	@Override
	public int compareTo(Task o) {		
		return priority.compareTo(o.priority);
	}

	@Override
	public String toString() {
		return "Task [name=" + name + ", description=" + description + ", priority=" + priority + "]";
	}



	
	
}
