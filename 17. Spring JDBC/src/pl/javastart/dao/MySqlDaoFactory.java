package pl.javastart.dao;

public class MySqlDaoFactory extends DaoFactory {

    @Override
    public BookDao getBookDao() {
        return new MysqlBookDao();
    }

    @Override
    public UserDao getUserDao() {
        return new MySqlUserDao();
    }

}