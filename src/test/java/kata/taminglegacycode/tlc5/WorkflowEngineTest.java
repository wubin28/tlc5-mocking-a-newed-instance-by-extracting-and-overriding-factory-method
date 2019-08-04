package kata.taminglegacycode.tlc5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WorkflowEngineTest {


    @Mock
    private TransactionManager transactionManager;

    @Mock
    private DryConfiguration dryConfiguration;

    @Mock
    private ModelReader reader;

    @Test
    public void should_invoke_approve_if_having_permission() {
        WorkflowEngine workflowEngine = new WorkflowEngine(dryConfiguration, reader, transactionManager);

        workflowEngine.approve("taskId", 2, "nodeId");

        verify(transactionManager, times(1)).approve("taskId", 2, "nodeId");
    }
}
