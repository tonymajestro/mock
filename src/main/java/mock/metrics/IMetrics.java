package mock.metrics;

public interface IMetrics {
    void addInsertCount(boolean error);
    void addUpdateCount(boolean error);
    void addDeleteCount(boolean error);
    void addGetCount(boolean error);
}
