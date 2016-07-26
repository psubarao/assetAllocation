import org.apache.commons.math3.distribution.NormalDistribution;

import java.util.Random;

/**
 * Created by Rodrigo on 7/22/16.
 */
public class MonteCarloSimulation {

    private NormalDistribution normalDistribution;
    private Portfolio portfolio;
    private static final double INFLATION = 0.035;

     MonteCarloSimulation (Portfolio portfolio) {
         this.portfolio = portfolio;
         normalDistribution = new NormalDistribution(portfolio.getMean(), portfolio.getRisk());
     }

    public double simulate(){
        double result = portfolio.getInitialInvestment();
        for (int i=0; i<20; i++) {
            result = applyMonteCarlo(result);
        }
        return result;
    }

    private double applyMonteCarlo(double investedAmount) {
        double result;
        double beforeInflationResult;
        double randomizedReturn = normalDistribution.sample();
        beforeInflationResult = (1 + randomizedReturn) * investedAmount;
        result = (1 - INFLATION) * beforeInflationResult;
        return result;
    }

}
