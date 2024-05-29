package test;

import java.util.List;

import dao.MuttersDAO;
import model.Mutter;

public class MuttersDAOTest {
	public static void main(String[] args) {
		findAllOK();
//		findAllNG();
		createOK();
	}
	
	public static void findAllOK() {
		MuttersDAO dao = new MuttersDAO();
		List<Mutter> result = dao.findAll();
		if(result != null) {
			System.out.println("findAllOK:成功しました");
		} else {
			System.out.println("findAllOK:失敗しました");
		}
	}
//	public static void findAllNG() {
//		Login login = new Login("minato", "12345");
//		AccountsDAO dao = new AccountsDAO();
//		Account result = dao.findByLogin(login);
//		if(result == null) {
//			System.out.println("testFindByLoginNG:成功しました");
//		} else {
//			System.out.println("testfindByLoginNG:失敗しました");
//		}
//	}
	public static void createOK() {
		Mutter mutter = new Mutter("minato", "湊　雄輔", "ありがとう");
		MuttersDAO dao = new MuttersDAO();
		boolean result = dao.create(mutter);
		if(result) {
			System.out.println("createOK:成功しました");
		} else {
			System.out.println("createOK:失敗しました");
		}
	}
}
