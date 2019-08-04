package kata.taminglegacycode.tlc5;

public class WorkflowEngine {
    private DryConfiguration dryConfiguration;

    private ModelReader reader;

    private TransactionManager tm;

    public WorkflowEngine() {
        this.dryConfiguration = AppConfiguration.getDryConfiguration();
        this.reader = new ModelReader(AppConfig.getDryConfiguration());
        this.tm = new TransactionManager(reader, new XMLStore(dryConfiguration));
    }

    public WorkflowEngine(DryConfiguration dryConfiguration, ModelReader reader, TransactionManager transactionManager) {
        this.dryConfiguration = dryConfiguration;
        this.reader = reader;
        this.tm = transactionManager;
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
