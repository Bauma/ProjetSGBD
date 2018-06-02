package database.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MysqlClient {

        private static Connection dbConnect = null;

        private static final String Driver = "com.mysql.jdbc.Driver";
        private static final String Url = "jdbc:mysql://localhost:3306/demoSGDB?verifyServerCertificate=false&useSSL=true";
        private static final String User = "root";
        private static final String Pwd = "root";

        private MysqlClient(){}

        public static Connection getConnection(){
            if(dbConnect == null){
                try {
                    Class.forName(Driver);
                    dbConnect = DriverManager.getConnection(Url, User, Pwd);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(MysqlClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return dbConnect;
        }
}
