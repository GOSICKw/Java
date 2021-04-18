package SubjectSystem;

public class Enrollment {
	private Student[] stu;
	private Subject sub;
	private int count;

	public Enrollment(Subject sub) {
		count = 0;
		this.sub = sub;
		stu = new Student[sub.getMaxNum()];
	}

	public Student[] getStu() {
		return stu;
	}

	public void setStu(Student[] stu) {
		this.stu = stu;
	}

	public Subject getSub() {
		return sub;
	}

	public void setSub(Subject sub) {
		this.sub = sub;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Enrollment(Student[] stu, Subject sub, int count) {
		super();
		this.stu = stu;
		this.sub = sub;
		this.count = count;
	}

	public boolean add(Student student) {
		if (student == null)
			return false;
		if (count >= stu.length)
			return false;
		stu[count] = student;
		count++;
		return true;
	}

	public int indexOf(String id) {
		for (int i = 0; i < stu.length && stu[i] != null; i++) {
			if (stu[i].getId().equals(id))
				return i;
		}
		return -1;
	}

	public int size() {
		return this.count;
	}

	public Student get(int index) {
		return stu[index];
	}

	public String toString() {
		String info = "";
		info = this.sub.toString() + "\n";
		info += "选课人数:" + this.count + "\n";
		info += "学号\t姓名\n";
		for (int i = 0; i < count; i++) {
			info += stu[i].toString() + "\n";
		}
		return info;
	}

	/*
	 * 将指定位置的对象设置为NULL,同时将其后面的所有对象依次前移, count-1,保证集合中的对象连续存放
	 */
	public boolean remove(int index) {
		if (index < 0 || index >= count) {
			return false;
		}
		stu[index] = null;
		count--;
		// 最后一个元素,或者集合中只有一个元素,直接返回
		if (index == count + 1 || count == 0) {
			return false;
		}
		//所有元素前移
		for (int i = index; i < count; i++) {
			stu[i] = stu[i + 1];
		}
		stu[count] = null;
		return true;
	}

}
