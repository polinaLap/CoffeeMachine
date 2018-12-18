package univ.lab.classes.repository.dao;

import univ.lab.classes.domain.entities.CoffeeMachine;
import univ.lab.classes.domain.entities.CoffeeParameters;
import univ.lab.classes.domain.interfaces.ICoffeeMachineDAO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoffeeMachineDAO implements ICoffeeMachineDAO {

    private DataSource _dataSource;
    private static final String GET_COFFEE_RESERVE =
            "select coffeeAmount, waterAmount, milkAmount, sugarAmount " +
                    "from Reserve where id = ?";
    private static final String UPDATE_COFFEE_MACHINE_RESERVE =
            "update Reserve " +
                    "set coffeeAmount = ?, waterAmount = ?, milkAmount = ?, sugarAmount = ? " +
                    "where id = ?";

    public void setDataSource(DataSource dataSource) {
        this._dataSource = dataSource;
    }

    @Override
    public CoffeeMachine GetCoffeeMachine(int id) {
        CoffeeMachine result = null;
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement st = null;;
        try {
            con = _dataSource.getConnection();
            st = con.prepareStatement(GET_COFFEE_RESERVE);
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                result = new CoffeeMachine(id);
                result.set_coffeeAmount(rs.getDouble("coffeeAmount"));
                result.set_waterAmount(rs.getDouble("waterAmount"));
                result.set_milkAmount(rs.getDouble("milkAmount"));
                result.set_sugarAmount(rs.getDouble("sugarAmount"));
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
    public boolean UpdateCoffeeMachine(int id, CoffeeParameters parameters) {
        boolean result = false;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = _dataSource.getConnection();
            ps = con.prepareStatement(UPDATE_COFFEE_MACHINE_RESERVE);
            ps.setDouble(1, parameters.get_coffeeAmount());
            ps.setDouble(2, parameters.get_waterAmount());
            ps.setDouble(3, parameters.get_milkAmount());
            ps.setDouble(4, parameters.get_sugarAmount());
            ps.setDouble(5, id);
            int out = ps.executeUpdate();
            if (out != 0) {
                result = true;
            }
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
