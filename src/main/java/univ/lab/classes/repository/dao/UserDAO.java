package univ.lab.classes.repository.dao;

import univ.lab.classes.domain.entities.UserAccount;
import univ.lab.classes.domain.interfaces.IUserDAO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements IUserDAO {

    private DataSource _dataSource;
    private static final String GET_USER_ACCOUNT =
            "select money " +
                    "from Users  " +
                    "where Id = ?";
    private static final String UPDATE_USER_ACCOUNT =
            "update Users " +
                    "set money = ?," +
                    "where Id = ?";

    public void setDataSource(DataSource dataSource) {
        this._dataSource = dataSource;
    }

    @Override
    public UserAccount GetUserAccount(int id) {
        UserAccount result = null;
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement st = null;;
        try {
            con = _dataSource.getConnection();
            st = con.prepareStatement(GET_USER_ACCOUNT);
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                result = new UserAccount(id);
                result.set_money(rs.getDouble("money"));
            } else {
                System.out.println("No UserAccount found with id=" + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                rs.close();
                st.close();
                con.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public boolean UpdateUserAccount(UserAccount userAccount) {
        boolean result = false;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = _dataSource.getConnection();
            ps = con.prepareStatement(UPDATE_USER_ACCOUNT);
            ps.setDouble(1, userAccount.get_money());
            ps.setInt(2, userAccount.get_id());
            int out = ps.executeUpdate();
            if (out != 0) {
                result = true;
            } else System.out.println("No UserAccount found with id=" + userAccount.get_id());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
