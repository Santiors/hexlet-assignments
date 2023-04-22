package exercise;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

import java.util.List;
import java.util.ArrayList;

// BEGIN
public class TcpConnection {
    private String ipAddress;
    private int port;
    private Connection connection;
    private List<String> buffer;

    public TcpConnection(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.connection = new Disconnected(this);
        this.buffer = new ArrayList<>();
    }

    public void changeState(Connection initialConnection) {
        this.connection = initialConnection;
    }

    public void addToBuffer(String data) {
        buffer.add(data);
    }

    public String getCurrentState() {
        return connection.getCurrentState();
    }

    public void connect() {
        connection.connect();
    }

    public void disconnect() {
        connection.disconnect();
    }

    public void write(String data) {
        connection.write(data);
    }
}
// END
