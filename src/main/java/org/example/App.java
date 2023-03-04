package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DAO dao= DAO.getDao();
        //dao.insertNew();
        //dao.check();
        //dao.update();
        dao.delete();
        dao.readOne();
    }
}
