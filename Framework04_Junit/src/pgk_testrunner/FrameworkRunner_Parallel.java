package pgk_testrunner;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses
(
        {
         FrameworkRunner.class,
         FrameworkRunner_Hooks.class
        }
)

public class FrameworkRunner_Parallel
{

}

//  11. Running Junit runner classes in parallel - reporting limitations
//            Delete target folder first as a precaution


