import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.jdbc.Student.Student;
import com.jdbc.Student.studentDao;

public class App {

	public static void main(String[] args) throws IOException {

		System.out.println("Welcome To Student Management App");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("Press 1 to Insert Student : ");
			System.out.println("Press 2 to Delete Student : ");
			System.out.println("Press 3 to Display Student : ");
			System.out.println("Press 4 to Update Student : ");
			System.out.println("Press 5 to Exit  : ");
			int a = Integer.parseInt(br.readLine());

			if (a == 1) {
				System.out.println("Enter Your Name");
				String name = br.readLine();

				System.out.println("Enter Your Phone No.");
				String phone = br.readLine();

				System.out.println("Enter Your City");
				String city = br.readLine();

				Student st = new Student(name, phone, city);
				boolean answer = studentDao.insertStudent(st);
				if (answer) {
					System.out.println("Successfully Inserted..");
				} else {
					System.out.println("Something went Wrong..");
				}
			}

			else if (a == 2) {
				System.out.println("Enter studentId to Delete data");
				int userId = Integer.parseInt(br.readLine());

				boolean ans = studentDao.deleteStudent(userId);
				if (ans) {
					System.out.println("Successfully Deleted..");
				} else {
					System.out.println("Something went Wrong..");
				}
			}

			else if (a == 3) {
				studentDao.selectAllStudent();

			}
			
			else if(a==4) {
				System.out.println("Enter userId to update Student data");
				int userId=Integer.parseInt(br.readLine());
				
				System.out.println("Enter Your Name");
				String name = br.readLine();

				System.out.println("Enter Your Phone No.");
				String phone = br.readLine();

				System.out.println("Enter Your City");
				String city = br.readLine();
				
				Student st = new Student(name, phone, city);
				boolean ans=studentDao.updateStudent(st);
				
				if (ans) {
					System.out.println("Successfully Updated..");
				} else {
					System.out.println("Something went Wrong..");
				}
			}
			
			
			else if (a == 5) {
				break;
			} 
			
			
			else {
				System.out.println("U Presses wrong Input");
			}
		}
	}
}
