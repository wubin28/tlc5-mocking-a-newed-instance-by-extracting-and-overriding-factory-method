package kata.taminglegacycode.tlc5;

import org.junit.Test;

public class WorkflowEngineTest {

    @Test
    public void should_approve_if_having_permission() {
        TestWorkflowEngine testWorkflowEngine = new TestWorkflowEngine();

        testWorkflowEngine.approve("t01", 9, "n01");

        testWorkflowEngine.verifyShouldApproveIfHavingPermission();
    }
}
