package mock.metrics;

/**
 * Pretends these write metrics to some service that handles all your team's metrics
 */
public class Metrics implements IMetrics {
    private int insertSuccess;
    private int insertFailure;
    private int updateSuccess;
    private int updateFailure;
    private int getSuccess;
    private int getFailure;
    private int deleteSuccess;
    private int deleteFailure;

    public Metrics() {
        insertSuccess = 0;
        insertFailure = 0;
        updateSuccess = 0;
        updateFailure = 0;
        getSuccess = 0;
        getFailure = 0;
        deleteSuccess = 0;
        deleteFailure = 0;
    }

    public void addInsertCount(boolean error) {
        if (error) {
            insertFailure++;
        } else {
            insertSuccess++;
        }
    }

    public void addUpdateCount(boolean error) {
        if (error) {
            updateFailure++;
        } else {
            updateSuccess++;
        }
    }

    public void addDeleteCount(boolean error) {
        if (error) {
            deleteFailure++;
        } else {
            deleteSuccess++;
        }
    }

    public void addGetCount(boolean error) {
        if (error) {
            getFailure++;
        } else {
            getSuccess++;
        }
    }
}
