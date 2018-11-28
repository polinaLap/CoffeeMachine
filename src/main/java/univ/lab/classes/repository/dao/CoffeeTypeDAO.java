package univ.lab.classes.repository.dao;

import univ.lab.classes.domain.entities.CoffeeType;
import univ.lab.classes.domain.interfaces.ICoffeeTypeDAO;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoffeeTypeDAO implements ICoffeeTypeDAO {
    private DataSource _dataSource;
    private static final String GET_COFFEE_TYPE = "select coffeeAmount, waterAmount, " +
            "milkAmount from CoffeeTypes  where Id = ?";
    private static final String GET_ALL_COFFEE_TYPES = "select coffeeAmount, waterAmount, " +
            "milkAmount from CoffeeTypes";

    public void setDataSource(DataSource dataSource) {
        this._dataSource = dataSource;
    }

    @Override
    public ArrayList<CoffeeType> GetAllCoffeeTypes() {
        ArrayList<CoffeeType> result = new ArrayList<CoffeeType>();
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement st = null;;
        try {
            con = _dataSource.getConnection();
            st = con.prepareStatement(GET_ALL_COFFEE_TYPES);
            rs = st.executeQuery();
            if (rs.next()) {
                CoffeeType coffeeType = new CoffeeType();
                coffeeType.setName(rs.getString("name"));
                coffeeType.setWaterAmount(rs.getDouble("waterAmount"));
                coffeeType.setMilkAmount(rs.getDouble("milkAmount"));
                coffeeType.setCoffeeAmount(rs.getDouble("coffeeAmount"));
                result.add(coffeeType);
            } else {
                System.out.println("No CoffeeTypes found");
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
}
