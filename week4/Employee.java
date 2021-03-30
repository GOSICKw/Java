package Employee;

public class Employee {
	private String name;
	private int id;
	private float baseSalary;
	private float SalaryIncrease;

	public  Employee(String name,int id,
			float baseSalary){
		 this.name = name;
		 this.id = id;
		 this.baseSalary = baseSalary;

	}
	 public String getName() {
		 return name;
	 }

		public void setName(String name) {
			this.name = name;
		}
		public float getBaseSalary() {
			return this.baseSalary;
		}
		public void setBaseSalary(float baseSalary) {
			this.baseSalary = baseSalary;
		}
	 public void updateSalary(){
		 this.baseSalary = this.baseSalary * 1.035f;
		 
	 }
	 public float getSalaryIncrease(){
		 this.SalaryIncrease = this.baseSalary *(1/1.035f)*0.035f;
		 return this.SalaryIncrease;
		 
	 }

		public void displayEmployee() {
			String info = "";
			info = "id=" + this.id + ",name=" + this.name + ",SalaryIncrease=" + this.SalaryIncrease + ",baseSalary="
					+ this.baseSalary;
			System.out.println(info);
		}

}

public class EmployeeDriver {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1.创建对象,new时会自动调用相应的("根据参数的个数与类型")构造方法
		Employee emp1 = new Employee("田所浩二", 810,114514); // new时会自动调用相应的构造方法
		// EmployeePlus emp2 = new EmployeePlus("tom",1001,2000);

		// 2.通过对象名.方法来访问public成员(变量或方法).运算符号
		float oldSalary = emp1.getBaseSalary();
		System.out.println("员工1的基础薪水为:" + oldSalary);
		emp1.updateSalary();
		float newSalary = emp1.getBaseSalary();
		float Increase = emp1.getSalaryIncrease();
		System.out.println("加薪后员工1的基础薪水为:" + newSalary);
		System.out.println("员工1的薪水增长额:"+Increase);
		emp1.displayEmployee();

	}

}
