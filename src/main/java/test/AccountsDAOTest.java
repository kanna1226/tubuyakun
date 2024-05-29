package test;

import dao.AccountsDAO;
import model.Account;
import model.Login;

public class AccountsDAOTest {
	public static void main(String[] args) {
		testFindByLoginOK();
		testFindByLoginNG();
		testRegisterAccountOK();
		
	}
	
	public static void testFindByLoginOK() {
		Login login = new Login("minato", "1234");
		AccountsDAO dao = new AccountsDAO();
		Account result = dao.findByLogin(login);
		if(result != null &&
				result.getUserId().equals("minato") &&
				result.getPass().equals("1234") &&
				result.getMail().equals("yusuke.minato@miyabilink.jp") &&
				result.getName().equals("湊　雄輔")) {
			System.out.println("testFindByLoginOK:成功しました");
		} else {
			System.out.println("testFindByLoginOK:失敗しました");
		}
	}
	public static void testFindByLoginNG() {
		Login login = new Login("minato", "12345");
		AccountsDAO dao = new AccountsDAO();
		Account result = dao.findByLogin(login);
		if(result == null) {
			System.out.println("testFindByLoginNG:成功しました");
		} else {
			System.out.println("testfindByLoginNG:失敗しました");
		}
	}
	public static void testRegisterAccountOK() {
		Account account = new Account("megumi", "5678", "megumi.ayabe@miyabilink.jp", "綾部　めぐみ");
		AccountsDAO dao = new AccountsDAO();
		boolean result = dao.registerAccount(account);
		if (result) {
			System.out.println("testResultAccountOK:成功しました");
		} else {
			System.out.println("testResultAccountOK:失敗しました");
		}
	}
}
