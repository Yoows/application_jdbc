package factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import dao.IDao;
import model.User;

public class DaoFactory {
	private static IDao<User> dao;
	private static String className;
	private static String packageName;

	@SuppressWarnings("unchecked")
	private DaoFactory() throws Exception {
		super();
		Class<?> daoImpl = null;
		config();
		daoImpl = Class.forName(packageName + "." + className);
		dao = (IDao<User>) daoImpl.getConstructor().newInstance();

	}

	public static IDao<User> getInstance() throws Exception {
		if (dao == null) {
			new DaoFactory();
		}
		return dao;
	}

	public static void config() throws Exception {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("application.properties"));
			className = properties.getProperty("className");
			packageName = properties.getProperty("packageName");
		} catch (IOException e) {
			throw new Exception("Error while loading application.properties file", e);
		}
	}

}
