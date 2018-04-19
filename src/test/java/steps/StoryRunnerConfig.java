package steps;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.*;

@RunWith(JUnitReportingRunner.class)
public class StoryRunnerConfig extends JUnitStory {
    private CrossReference crossReference = new CrossReference().withJsonOnly()
            .withOutputAfterEachStory(true);

    @Override
    public Configuration configuration() {
        Class<? extends Embeddable> embedableClass = this.getClass();
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(embedableClass))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withCodeLocation(CodeLocations.codeLocationFromClass(embedableClass))
                        .withDefaultFormats()
                        .withFormats(CONSOLE, TXT, HTML_TEMPLATE, XML_TEMPLATE)
                        .withFailureTrace(true)
                        .withFailureTraceCompression(true)
                        .withRelativeDirectory("../build/jbehave/")
                        .withCrossReference(crossReference))
                .useStepMonitor(crossReference.getStepMonitor());

    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new My());
    }

    @Override
    public void run() throws Throwable {
        Embedder embedder = configuredEmbedder();
        try {
            embedder.runStoriesAsPaths(storyPaths());
        } finally {
            embedder.generateCrossReference();
        }
    }


    protected List<String> storyPaths() {
        String storyToInclude = "**/" + System.getProperty("story", "*") + "*.story";
        return new StoryFinder().findPaths(codeLocationFromClass(getClass()).getFile(), storyToInclude, null);
    }
}
