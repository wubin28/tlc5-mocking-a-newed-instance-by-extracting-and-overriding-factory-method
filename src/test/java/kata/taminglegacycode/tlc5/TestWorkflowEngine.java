package kata.taminglegacycode.tlc5;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class TestWorkflowEngine extends WorkflowEngine{

    private TransactionManager mockTransactionManager;

    @Override
    protected TransactionManager makeTransactionManager() {
        mockTransactionManager = mock(TransactionManager.class);
        return mockTransactionManager;
    }

    public void verifyShouldApproveIfHavingPermission() {
        then(mockTransactionManager).should(times(1)).approve("t01", 9, "n01");
    }
}
