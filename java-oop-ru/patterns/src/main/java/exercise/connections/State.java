package exercise.connections;

public interface State {
    String getCurrentState();
    void connect();
    void disconnect();
    void write(String data);
}
