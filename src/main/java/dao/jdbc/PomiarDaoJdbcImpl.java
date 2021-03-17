package dao.jdbc;

import dao.PomiarDao;
import exception.DataAccessException;
import model.Pomiar;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class PomiarDaoJdbcImpl implements PomiarDao {

    private static PomiarDaoJdbcImpl instance;

    private PomiarDaoJdbcImpl(){
    }

    public static PomiarDao getInstance(){
        if(instance == null) instance = new PomiarDaoJdbcImpl();
        return instance;
    }

    @Override
    public void save(Pomiar t) {
        final String SQL = "insert into pomiar values (DEFAULT,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, t.getName());
            statement.setInt(2, t.getTimeA());
            statement.setInt(3, t.getTimeB());
            statement.setInt(4, t.getTimeC());
            statement.setInt(5, t.getTimeD());
            statement.setInt(6, t.getTimeE());
            statement.setInt(7, t.getTimeF());
            statement.setInt(8, t.getTimeG());
            statement.setInt(9, t.getTimeH());
            statement.setInt(10, t.getTimeI());
            statement.setInt(11, t.getTimeJ());
            statement.setInt(12, t.getTimeK());
            statement.setInt(13, t.getTimeL());
            statement.setInt(14, t.getTimeM());
            statement.setInt(15, t.getTimeN());
            statement.setInt(16, t.getTimeO());
            statement.setInt(17, t.getTimeP());
            statement.setInt(18, t.getTimeQ());
            statement.setInt(19, t.getTimeR());
            statement.setInt(20, t.getTimeS());
            statement.setInt(21, t.getTimeT());
            statement.setInt(22, t.getTimeU());
            statement.setInt(23, t.getTimeV());
            statement.setInt(24, t.getTimeW());
            statement.setInt(25, t.getTimeX());
            statement.setInt(26, t.getTimeY());
            statement.setInt(27, t.getTimeZ());
            statement.executeUpdate();
            try (ResultSet rs = statement.getGeneratedKeys()) {
                if (rs.next()) {
                    t.setId(rs.getLong(1));
                }
            } catch (SQLException ex) {
                throw new DataAccessException(ex);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public HashSet<String> findNames() {
        final String SQL = "select * from pomiar";
        HashSet<String> result = new HashSet<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(SQL);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                result.add(rs.getString("name"));
            }
        } catch (SQLException ex) {
            throw new DataAccessException(ex);
        }
        return result;
    }

    @Override
    public List<Pomiar> findByName(String name) {
        final String SQL = "select * from pomiar where name = ?";
        List<Pomiar> result = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
             statement.setString(1, name);
             try(ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    result.add(new Pomiar(
                            rs.getString("name"),
                            rs.getInt("timeA"),
                            rs.getInt("timeB"),
                            rs.getInt("timeC"),
                            rs.getInt("timeD"),
                            rs.getInt("timeE"),
                            rs.getInt("timeF"),
                            rs.getInt("timeG"),
                            rs.getInt("timeH"),
                            rs.getInt("timeI"),
                            rs.getInt("timeJ"),
                            rs.getInt("timeK"),
                            rs.getInt("timeL"),
                            rs.getInt("timeM"),
                            rs.getInt("timeN"),
                            rs.getInt("timeO"),
                            rs.getInt("timeP"),
                            rs.getInt("timeQ"),
                            rs.getInt("timeR"),
                            rs.getInt("timeS"),
                            rs.getInt("timeT"),
                            rs.getInt("timeU"),
                            rs.getInt("timeV"),
                            rs.getInt("timeW"),
                            rs.getInt("timeX"),
                            rs.getInt("timeY"),
                            rs.getInt("timeZ")
                            ));
                }
            } catch (SQLException ex) {
                throw new DataAccessException(ex);
            }
        } catch (SQLException ex) {
            throw new DataAccessException(ex);
        }
        return result;
    }

    @Override
    public List<Pomiar> findAll() {
        final String SQL = "select * from pomiar";
        List<Pomiar> result = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            try(ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    result.add(new Pomiar(
                            rs.getString("name"),
                            rs.getInt("timeA"),
                            rs.getInt("timeB"),
                            rs.getInt("timeC"),
                            rs.getInt("timeD"),
                            rs.getInt("timeE"),
                            rs.getInt("timeF"),
                            rs.getInt("timeG"),
                            rs.getInt("timeH"),
                            rs.getInt("timeI"),
                            rs.getInt("timeJ"),
                            rs.getInt("timeK"),
                            rs.getInt("timeL"),
                            rs.getInt("timeM"),
                            rs.getInt("timeN"),
                            rs.getInt("timeO"),
                            rs.getInt("timeP"),
                            rs.getInt("timeQ"),
                            rs.getInt("timeR"),
                            rs.getInt("timeS"),
                            rs.getInt("timeT"),
                            rs.getInt("timeU"),
                            rs.getInt("timeV"),
                            rs.getInt("timeW"),
                            rs.getInt("timeX"),
                            rs.getInt("timeY"),
                            rs.getInt("timeZ")
                    ));
                }
            } catch (SQLException ex) {
                throw new DataAccessException(ex);
            }
        } catch (SQLException ex) {
            throw new DataAccessException(ex);
        }
        return result;
    }
}
