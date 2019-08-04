package kata.taminglegacycode.tlc5;

public class WorkflowEngine {
    private static final DryConfiguration dryConfiguration = AppConfiguration.getDryConfiguration();

    private static ModelReader reader;

    private TransactionManager tm;

    static {
        reader = new ModelReader(AppConfig.getDryConfiguration());
    }

    public WorkflowEngine() {
        this.tm = buildTransactionManager();
    }

    protected TransactionManager buildTransactionManager() {
        XMLStore persister = new XMLStore(dryConfiguration);

        return new TransactionManager(reader, persister);
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
