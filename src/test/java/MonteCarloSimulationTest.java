import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.junit.Test;

/**
 * Created by Rodrigo on 7/22/16.
 */
public class MonteCarloSimulationTest {

    private static final double AGGRESSIVE_RETURN = 0.094324;
    private static final double AGGRESSIVE_RISK = 0.15675;
    private static final double CONSERVATIVE_RETURN = 0.06189;
    private static final double CONSERVATIVE_RISK = 0.063438;
    private static final double INITIAL_INVESTMENT = 100000;

    @Test
    public void simulateAggressivePortfolioTwentyYears() throws Exception {
        Portfolio portfolio = new Portfolio(PortfolioType.AGGRESSIVE, AGGRESSIVE_RETURN, AGGRESSIVE_RISK, INITIAL_INVESTMENT);
        MonteCarloSimulation allocateAsset = new MonteCarloSimulation(portfolio);

        for (int i = 0; i < 10000; i++) {
            portfolio.getStats().addValue(allocateAsset.simulate());
        }
        System.out.println(portfolio.toString());
        System.out.println("The media is: " + portfolio.getStats().getPercentile(50));
        System.out.println("The 10th percentile is: " + portfolio.getStats().getPercentile(10));
        System.out.println("The 90th percentile is: " + portfolio.getStats().getPercentile(90));
    }

    @Test
    public void simulateConservativePortfolioTwentyYears() throws Exception {
        Portfolio portfolio = new Portfolio(PortfolioType.CONSERVATIVE, CONSERVATIVE_RETURN, CONSERVATIVE_RISK, INITIAL_INVESTMENT);
        MonteCarloSimulation allocateAsset = new MonteCarloSimulation(portfolio);
        for (int i = 0; i < 10000; i++) {
            portfolio.getStats().addValue(allocateAsset.simulate());
        }
        System.out.println(portfolio.toString());
        System.out.println("The media is: " + portfolio.getStats().getPercentile(50));
        System.out.println("The 10th percentile is: " + portfolio.getStats().getPercentile(10));
        System.out.println("The 90th percentile is: " + portfolio.getStats().getPercentile(90));
    }

}


