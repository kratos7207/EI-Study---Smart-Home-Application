
import java.util.ArrayList;
import java.util.List;

// Subject
interface WeatherSubject {

    void registerObserver(WeatherObserver observer);

    void removeObserver(WeatherObserver observer);

    void notifyObservers();
}

// Observer
interface WeatherObserver {

    void update(float temperature, float humidity, float pressure);
}

// Concrete Subject
class WeatherData implements WeatherSubject {

    private List<WeatherObserver> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }
}

// Concrete Observer
class TemperatureDisplay implements WeatherObserver {

    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Temperature: " + temperature + "°C");
    }
}

// Concrete Observer
class HumidityDisplay implements WeatherObserver {

    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Humidity: " + humidity + "%");
    }
}

// Example usage
public class ObserverPatternDemo {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        TemperatureDisplay tempDisplay = new TemperatureDisplay();
        HumidityDisplay humidityDisplay = new HumidityDisplay();

        weatherData.registerObserver(tempDisplay);
        weatherData.registerObserver(humidityDisplay);

        weatherData.setMeasurements(25.0f, 60.0f, 1013.0f);
    }
}
