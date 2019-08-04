package kata.taminglegacycode.tlc5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WorkflowEngineTest {

    @Spy
    @InjectMocks
    private WorkflowEngine workflowEngine;

    @Mock
    private TransactionManager transactionManager;

    @Test
    public void should_invoke_approve_if_having_permission() {
        doReturn(transactionManager).when(workflowEngine).buildTransactionManager();

        workflowEngine.approve("taskId", 2, "nodeId");

        verify(transactionManager, times(1)).approve("taskId", 2, "nodeId");
    }
}
