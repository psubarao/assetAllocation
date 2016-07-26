import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

/**
 * Created by Rodrigo on 7/22/16.
 */

public class Portfolio {

    private PortfolioType type;
    private double mean;
    private double risk;
    private double initialInvestment;

    private DescriptiveStatistics stats;

    public Portfolio(PortfolioType type, double mean, double risk, double initialInvestment) {
        this.type = type;
        this.mean = mean;
        this.risk = risk;
        this.initialInvestment = initialInvestment;
        stats = new DescriptiveStatistics();
    }

    @Override
    public String toString(){
        return "Portfolio type: " + this.type.name() + " Average return: " + this.mean + " Risk: " + this.risk + " Initial investment: " + this.initialInvestment;
    }

    public PortfolioType getType() {
        return type;
    }

    public void setType(PortfolioType type) {
        this.type = type;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getRisk() {
        return risk;
    }

    public void setRisk(double risk) {
        this.risk = risk;
    }

    public double getInitialInvestment() {
        return initialInvestment;
    }

    public void setInitialInvestment(double initialInvestment) {
        this.initialInvestment = initialInvestment;
    }

    public DescriptiveStatistics getStats() {
        return stats;
    }

    public void setStats(DescriptiveStatistics stats) {
        this.stats = stats;
    }
}
