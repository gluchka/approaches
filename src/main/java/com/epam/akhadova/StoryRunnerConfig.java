package com.epam.akhadova;

import com.epam.akhadova.steps.MyStorySteps;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;

import java.text.SimpleDateFormat;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.*;


public class StoryRunnerConfig extends JUnitStory {
    private CrossReference crossReference = new CrossReference().withJsonOnly()
            .withOutputAfterEachStory(true);

    @Override
    public Configuration configuration() {
        Class<? extends Embeddable> embedableClass = this.getClass();
        ParameterConverters parameterConverters = new ParameterConverters();
        ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(new LocalizedKeywords());
        parameterConverters.addConverters(new ParameterConverters.DateConverter(new SimpleDateFormat("yyyy-MM-dd")),
                new ParameterConverters.ExamplesTableConverter(examplesTableFactory));
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(embedableClass))
                .useStoryParser(new RegexStoryParser(examplesTableFactory))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withCodeLocation(codeLocationFromClass(embedableClass))
                        .withDefaultFormats()
                        .withFormats(CONSOLE, TXT, HTML, XML)
                        .withCrossReference(crossReference)
                        .withRelativeDirectory("../build/jbehave"))
                .useParameterConverters(parameterConverters)
                .useStepMonitor(crossReference.getStepMonitor());

    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new MyStorySteps());
    }

//    @Override
//    public void run() throws Throwable {
//        Embedder embedder = configuredEmbedder();
//        embedder.embedderControls().doIgnoreFailureInStories(true)
//                .doIgnoreFailureInView(false)
//                .useStoryTimeoutInSecs(120000);
//        try {
//            embedder.runStoriesAsPaths(storyPaths());
//        } finally {
//            embedder.generateCrossReference();
//        }
//    }


//    protected List<String> storyPaths() {
//        String storyToInclude = "**/" + System.getProperty("story", "*") + "*.story";
//        return new StoryFinder().findPaths(codeLocationFromClass(getClass()).getFile(), storyToInclude, null);
//    }
}
