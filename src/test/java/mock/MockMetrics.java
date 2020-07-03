package mock;

import mock.metrics.IMetrics;

public class MockMetrics implements IMetrics {
    @Override
    public void addInsertCount(boolean error) {
    }

    @Override
    public void addUpdateCount(boolean error) {
    }

    @Override
    public void addDeleteCount(boolean error) {
    }

    @Override
    public void addGetCount(boolean error) {
    }
}
