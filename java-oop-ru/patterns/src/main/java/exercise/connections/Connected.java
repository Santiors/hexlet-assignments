package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements State {

    private TcpConnection connection;

    public Connected(TcpConnection connection) {
        this.connection = connection;
    }

    @Override
    public String getCurrentState() {
        return "connected";
    }

    @Override
    public void connect() {
        System.out.println("Error! Connection already established");
    }

    @Override
    public void disconnect() {
        connection.changeState(new Disconnected(connection));
    }

    @Override
    public void write(String data) {
        connection.addToBuffer(data);
    }
}
// END
