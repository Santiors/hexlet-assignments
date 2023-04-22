package exercise;
import exercise.connections.Disconnected;
import exercise.connections.State;

import java.util.List;
import java.util.ArrayList;

// BEGIN
public class TcpConnection {
    private String ipAddress;
    private int port;
    private State state;
    private List<String> buffer;

    public TcpConnection(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.state = new Disconnected(this);
        this.buffer = new ArrayList<>();
    }

    public void changeState(State initialState) {
        this.state = initialState;
    }

    public void addToBuffer(String data) {
        buffer.add(data);
    }

    public String getCurrentState() {
        return state.getCurrentState();
    }

    public void connect() {
        state.connect();
    }

    public void disconnect() {
        state.disconnect();
    }

    public void write(String data) {
        state.write(data);
    }
}
// END
