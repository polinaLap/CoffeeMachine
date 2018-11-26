package univ.lab.classes.repository.dao;

import univ.lab.classes.domain.entities.Ingredient;
import univ.lab.classes.domain.entities.UserAccount;
import univ.lab.classes.domain.interfaces.IIngredientPricesDAO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IngredientPricesDAO implements IIngredientPricesDAO {

    private DataSource _dataSource;
    private static final String GET_ALL_INGREDIENT_PRICES =
            "select name, portionSize, price " +
                    "from Prices";

    public void setDataSource(DataSource dataSource) {
        this._dataSource = dataSource;
    }

    public ArrayList<Ingredient> getAllIngredients() {
        ArrayList<Ingredient> result = null;
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement st = null;;
        try {
            con = _dataSource.getConnection();
            st = con.prepareStatement(GET_ALL_INGREDIENT_PRICES);
            rs = st.executeQuery();
            if (rs.next()) {
                String ingredientName = rs.getString("name");
                double portionSize = rs.getDouble("portionSize");
                double price = rs.getDouble("price");
                Ingredient ingredient = new Ingredient(ingredientName, portionSize, price);
                result.add(ingredient);
            } else {
                System.out.println("Prices are not available.");
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
}
