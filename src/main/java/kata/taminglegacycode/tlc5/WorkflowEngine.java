package kata.taminglegacycode.tlc5;

import java.io.Reader;

public class WorkflowEngine {
    private final TransactionManager tm;

    public WorkflowEngine() {
        Reader reader = new ModelReader(AppConfig.getDryConfiguration());

        Persister persister = new XMLStore(AppConfiguration.getDryConfiguration());

        this.tm = new TransactionManager(reader, persister);
    }

    public void approve(String taskId, int employeeId, String nodeID) {
        if (isApprovalable(employeeId)) {
            tm.approve(taskId, employeeId, nodeID);
        }
    }

    private boolean isApprovalable(int employeeId) {
        if (employeeId < 10) {
            return true;
        }
        return false;
    }
}
