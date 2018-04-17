package com.epam;

public class Test {
//        extends ConfigurableEmbedder {

//    private static final int STORY_TIMEOUT_IN_SECS = 12000000;
//
//    private CrossReference crossReference = new CrossReference().withJsonOnly()
//            .withOutputAfterEachStory(true);
//
//    @Override
//    public void run() {
//        Embedder embedder = configuredEmbedder();
//        embedder.useMetaFilters(getMetaFilters());
//        embedder.embedderControls().doIgnoreFailureInStories(true)
//                .doIgnoreFailureInView(false)
//                .useStoryTimeoutInSecs(STORY_TIMEOUT_IN_SECS);
//        try {
//            embedder.runStoriesAsPaths(storyPaths());
//        } finally {
//            embedder.generateCrossReference();
//        }
//    }
//
//    private List<String> getMetaFilters() {
//        String metaFiltersProperty = System.getProperty("metaFilters", "");
//        String[] split = metaFiltersProperty.split(",");
//        return Arrays.asList(split);
//    }
//
//    @Override
//    public Configuration configuration() {
//
//        ParameterConverters parameterConverters = new ParameterConverters();
//        // factory to allow parameter conversion and loading from external
//        // resources (used by StoryParser too)
//        parameterConverters.addConverters(new ParameterConverters.EnumConverter());
//        return new MostUsefulConfiguration()
//                .useStoryControls(
//                        new StoryControls().doSkipScenariosAfterFailure(false))
//                .usePendingStepStrategy(new FailingUponPendingStep())
//                .useStoryLoader(new LoadFromClasspath(getClass()))
//                .useStoryReporterBuilder(new StoryReporterBuilder()
//                        .withFormats(Format.CONSOLE, Format.HTML, Format.XML).withCrossReference(crossReference)
//                        .withRelativeDirectory("../build/jbehave")
//                )
//                .useParameterConverters(parameterConverters)
//                .useStepMonitor(crossReference.getStepMonitor());
//    }
//
//    @Override
//    public InjectableStepsFactory stepsFactory() {
//        return new InstanceStepsFactory(configuration(), new My());
//    }
//
//    /**
//     * Story paths.
//     *
//     * @return the list
//     */
//    protected List<String> storyPaths() {
//        String storyToInclude = "**/" + System.getProperty("story", "*")
//                + "*.story";
//        return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(getClass()).getFile(), storyToInclude, null);
//    }

}
