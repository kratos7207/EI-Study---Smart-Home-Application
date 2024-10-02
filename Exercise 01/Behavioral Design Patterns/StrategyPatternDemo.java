// Strategy Interface

interface TravelStrategy {

    void travel();
}

// Concrete Strategy
class CarStrategy implements TravelStrategy {

    @Override
    public void travel() {
        System.out.println("Traveling by Car.");
    }
}

// Concrete Strategy
class BikeStrategy implements TravelStrategy {

    @Override
    public void travel() {
        System.out.println("Traveling by Bike.");
    }
}

// Concrete Strategy
class WalkStrategy implements TravelStrategy {

    @Override
    public void travel() {
        System.out.println("Traveling by Walking.");
    }
}

// Context
class TravelContext {

    private TravelStrategy strategy;

    public void setTravelStrategy(TravelStrategy strategy) {
        this.strategy = strategy;
    }

    public void travel() {
        strategy.travel();
    }
}

// Example usage
public class StrategyPatternDemo {

    public static void main(String[] args) {
        TravelContext context = new TravelContext();

        context.setTravelStrategy(new CarStrategy());
        context.travel();

        context.setTravelStrategy(new BikeStrategy());
        context.travel();

        context.setTravelStrategy(new WalkStrategy());
        context.travel();
    }
}
