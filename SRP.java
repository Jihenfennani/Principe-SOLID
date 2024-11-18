import java.util.ArrayList;
import java.util.List;

public class Car {
    private String id;
    private String model;
    private String brand;

    public Car(String id, String model, String brand) {
        this.id = id;
        this.model = model;
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }
}


public class CarManager {
    private List<Car> carsDb;

    public CarManager() {
        this.carsDb = new ArrayList<>();
    }

    public Car getFromDb(String carId) {
        for (Car car : carsDb) {
            if (car.getId().equals(carId)) {
                return car;
            }
        }
        return null;
    }

    public List<Car> getAllCars() {
        return new ArrayList<>(carsDb);
    }
}


public class CarFormatter {
    public String formatCarsNames(List<Car> cars) {
        StringBuilder formattedNames = new StringBuilder();
        for (Car car : cars) {
            formattedNames.append(car.getModel()).append(" ").append(car.getBrand()).append("\n");
        }
        return formattedNames.toString();
    }
}

public class CarRater {
    public Car getBestCar(List<Car> cars) {
        // Implémentation fictive pour le meilleur classement des voitures
        if (cars == null || cars.isEmpty()) {
            return null;
        }
        return cars.get(0);  // Retourne la première voiture pour l'exemple
    }
}

public class CarController {
    private CarManager carManager = new CarManager();
    private CarFormatter carFormatter = new CarFormatter();
    private CarRater carRater = new CarRater();

    public void displayCarNames() {
        List<Car> cars = carManager.getAllCars();
        String formattedNames = carFormatter.formatCarsNames(cars);
        System.out.println(formattedNames);
    }
public class Main {
    public static void main(String[] args) {
        CarController carController = new CarController();
        carController.displayCarNames();
        carController.displayBestCar();
    }
}


    public void displayBestCar() {
        List<Car> cars = carManager.getAllCars();
        Car bestCar = carRater.getBestCar(cars);
        if (bestCar != null) {
            System.out.println("Best Car: " + bestCar.getModel() + " " + bestCar.getBrand());
        } else {
            System.out.println("No best car available.");
        }
    }
}
