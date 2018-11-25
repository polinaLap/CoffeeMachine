package univ.lab.classes.repository.dao;

import univ.lab.classes.domain.entities.CoffeeType;
import univ.lab.classes.domain.interfaces.ICoffeeTypeDAO;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoffeeTypeDAO implements ICoffeeTypeDAO {
    private DataSource _dataSource;
    private static final String GET_COFFEE_TYPE = "select coffeeAmount, waterAmount, " +
            "milkAmount, waterBeforeMilk from CoffeeTypes  where Id = ?";

    public void setDataSource(DataSource dataSource) {
        this._dataSource = dataSource;
    }

    public CoffeeType GetCoffeeType(int id) {
        CoffeeType result = null;
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement st = null;;
        try {
            con = _dataSource.getConnection();
            st = con.prepareStatement(GET_COFFEE_TYPE);
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                result = new CoffeeType();
                result.setId(id);
                result.setCoffeeAmount(rs.getDouble("coffeeAmount"));
                result.setWaterAmount(rs.getDouble("waterAmount"));
                result.setWaterBeforeMilk(rs.getBoolean("waterBeforeMilk"));

            } else {
                System.out.println("No CoffeeType found with id=" + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                rs.close();
                st.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean AddCoffeeType(CoffeeType type) {
        return false;
    }
}
