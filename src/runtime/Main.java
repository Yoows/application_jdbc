package runtime;

import java.util.List;

import dao.IDao;
import factory.DaoFactory;
import model.User;

public class Main {

	public static void main(String[] args) {
		try {
			IDao<User> user = DaoFactory.getInstance();
			System.out.println(user);
			List<User> userList = user.list();
			System.out.println(userList);
			userList.forEach(t -> t.sePresenter());

			user.create(new User(100, "Jean", "1200"));

			List<User> userList2 = user.list();
			System.out.println(userList2);
			userList2.forEach(t -> t.sePresenter());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}