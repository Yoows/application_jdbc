package runtime;

import java.util.List;

import dao.IDao;
import dao.UserDaoImpl;
import exception.DAOException;
import model.User;

public class TestDB {
	static IDao<User> dao = new UserDaoImpl();

	public static void test_create(User user) {
		try {
			dao.create(user);
			System.out.println("Utilisateur créé avec succès.");
		} catch (DAOException e) {
			e.printStackTrace();
		}

	}

	public static void test_delete(int id) {

		UserDaoImpl dao = new UserDaoImpl();
		try {
			dao.delete(id);
			System.out.println("Utilisateur supprimé avec succès.");
		} catch (DAOException e) {
			e.printStackTrace();
		}

	}

	public static void test_update(User user) {
		try {
			dao.update(user);
			System.out.println("Utilisateur modifié avec succès.");
		} catch (DAOException e) {
			e.printStackTrace();
		}

	}

	public static void test_read(int id) {
		try {
			User user;
			user = (User) dao.read(id);
			user.sePresenter();
		} catch (DAOException e) {
			e.printStackTrace();
		}

	}

	public static void test_list() {
		try {
			List<User> users = dao.list();
			System.out.println("Liste des utilisateurs de la base : ");
			for (User user : users) {
				user.sePresenter();
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}

	}
}
