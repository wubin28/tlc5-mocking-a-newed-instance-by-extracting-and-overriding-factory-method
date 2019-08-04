package kata.taminglegacycode.tlc5;

public class WorkflowEngine {
    private TransactionManager tm;

    public WorkflowEngine() {

        ModelReader reader = new ModelReader(AppConfig.getDryConfiguration());
        XMLStore persister = new XMLStore(AppConfiguration.getDryConfiguration());

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
