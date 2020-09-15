package main.rice;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.FileSystems;

/**
 * Simple Main class that programmatically executes all test cases in ChessBoardTest.java
 * and prints the results.
 */
public class Main {

    /**
     * Simple main method that programmatically executes all test cases in
     * ChessBoardTest.java and pretty-prints the results.
     *
     * @param args command-line args; none expected
     * @throws Exception if the test class cannot be found or if an unexpected test case
     *                   is encountered
     */
    public static void main(String[] args) throws Exception {
        TestExecutionSummary summary = runAllTests();
        printSummary(summary);
    }

    /**
     * Runs all test cases in ChessBoardTest.java and returns the results in the form of a
     * TestExecutionSummary object.
     *
     * @return a TestExecutionSummary object encapsulating the results of testing
     */
    private static TestExecutionSummary runAllTests() throws MalformedURLException,
        ClassNotFoundException {

        // Create a request to run all tests in ChessBoardTest.java
        URL url = FileSystems.getDefault().getPath("").toUri().toURL();
        URLClassLoader loader = new URLClassLoader(new URL[]{url});
        for (URL url2 : loader.getURLs()) {
            System.out.println(url2);
        }
        Class<?> c = loader.loadClass("test.rice.ChessBoardTest");
        LauncherDiscoveryRequest request =
            LauncherDiscoveryRequestBuilder.request().selectors(selectClass(c)).build();

        // Execute the request to run all tests
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        Launcher launcher = LauncherFactory.create();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);

        // Return a summary of the results
        return listener.getSummary();
    }

    /**
     * Pretty-prints the results of testing.
     *
     * @param summary a TestExecutionSummary object encapsulating the results of testing
     */
    private static void printSummary(TestExecutionSummary summary) throws Exception {
        // Get the number of tests that passed & failed
        long numTests = summary.getTestsStartedCount();
        long numFailed = summary.getTestsFailedCount();
        long numPassed = numTests - numFailed;

        if (numPassed == numTests) {
            System.out.println("All tests passed!");
        } else {
            // Print the number of tests that passed & failed
            System.out.println("\n" + numPassed + " test(s) passed!");
            System.out.println("\n" + numFailed + " test(s) failed:");

            // For each failed test, print the name of the test function, the expected
            // result, and the actual result
            for (TestExecutionSummary.Failure failure : summary.getFailures()) {
                System.out.println("\t" + failure.getTestIdentifier().getDisplayName());
                System.out.println("\t\t" + failure.getException().getMessage() + "\n");
            }
        }
    }
}