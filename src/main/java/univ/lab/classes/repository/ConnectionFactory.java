package univ.lab.classes.repository;

import java.sql.Connection;
import java.util.Queue;

public class ConnectionFactory {
    private Queue<Connection> _connections;

    public Connection GetConnection(){
        if(_connections.size()<1)
            Refill();
        return _connections.poll();
    }

    private void Refill(){}
}
