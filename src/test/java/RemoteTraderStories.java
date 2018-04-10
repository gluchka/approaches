import first.TraderStories;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.io.LoadFromURL;
import org.jbehave.core.reporters.StoryReporterBuilder;

import java.util.List;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromURL;
import static org.jbehave.core.reporters.StoryReporterBuilder.Format.*;

public class RemoteTraderStories extends TraderStories {
    @Override
    public Configuration configuration() {
        return super.configuration()
                .useStoryLoader(new LoadFromURL())
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withCodeLocation(codeLocationFromURL("http://jbehave.org/reference/examples/stories/"))
                                .withDefaultFormats()
                                .withFormats(CONSOLE, TXT, HTML, XML));
    }

    @Override
    protected List<String> storyPaths() {
        // Specify story paths as remote URLs
        String codeLocation = codeLocationFromURL("http://jbehave.org/reference/examples/stories/")
                .toExternalForm();
        return asList(codeLocation + "and_step.story");
    }
}
