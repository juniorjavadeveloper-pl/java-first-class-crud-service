package pl.juniorjavadeveloper.java.crud;

import pl.juniorjavadeveloper.java.crud.model.Car;
import pl.juniorjavadeveloper.java.crud.service.CarService;

import java.math.BigDecimal;
import java.util.List;

public class CarServiceMain {
    public static void main(String[] args) {
        System.out.println("Katalog samochodów z wykorzystaniem CarService - CRUD'a");

        // stworzenie obiektu będącego CRUD'em
        CarService carService = new CarService();

        System.out.println("Zawartość katalogu samochodów przed dodanie zawartości");
        List<Car> carsCatalog = carService.list();
        System.out.println(carsCatalog + "\n");

        System.out.println("Dodanie jednego samochodu do katalogu");
        Car toyotaCorollaCar = new Car(2009, "Corolla", "Toyota", BigDecimal.valueOf(33_000.00));
        System.out.println("Samochód poza katalogie nie posiada unikalnego identyfikatora");
        System.out.println(toyotaCorollaCar);
        Car createdToyotaCorollaCar = carService.create(toyotaCorollaCar);
        System.out.println("Utworzony/dodany samochód w katalogu posiada unikalny identyfikator");
        System.out.println(createdToyotaCorollaCar + "\n");

        System.out.println("Zawartość katalogu samochodów po dodaniu jednego samochodu");
        System.out.println(carService.list() + "\n");

        System.out.println("Dodanie kolejnego samochodu do katalogu");
        Car teslaModelXCar = new Car(2016, "Model X", "Tesla", BigDecimal.valueOf(340_000.00));
        carService.create(teslaModelXCar);

        System.out.println("Zawartość katalogu samochodów po dodaniu kolejnego samochodu");
        System.out.println(carService.list() + "\n");

        System.out.println("Modyfikacja danych samochodu z katalogu");
        // ... najpierw pobieramy katalog samochodów, aby znać identyfikatory samochodów ...
        List<Car> carsCatalogUpdate = carService.list();
        // ... wybieramy pierwszy samochód do modyfikacji danych ...
        Car firstCar = carsCatalogUpdate.get(0);
        System.out.println("Dane samochodu do modyfikacji: " + firstCar);
        // ... podajemy nowe dane samochodu ...
        Car firstCarUpdate = new Car();
        firstCarUpdate.setYear(firstCar.getYear());
        firstCarUpdate.setModel("Corolla Sport");
        firstCarUpdate.setManufacturer(firstCar.getManufacturer());
        firstCarUpdate.setPrice(BigDecimal.valueOf(35_000.00));
        System.out.println("Dane samochodu po modyfikacji: " + firstCarUpdate);
        System.out.println("W katlogu jeszcze są stare dane");
        System.out.println(carsCatalog + "\n");
        // ... identyfikator samochodu jest przekazywany do metody update() ...
        Integer firstCarToUpdateId = firstCar.getId();
        // ... aktulizujemy dane samochodu w katalogu za pomocą serwisu ...
        Car update = carService.update(firstCarToUpdateId, firstCarUpdate);

        System.out.println("W katlogu są już nowe dane");
        System.out.println(carsCatalog + "\n");

        // ... usuwamy jedne samochód z katalogu ...
        // ... najpierw pobieramy katalog samochodów, aby znać identyfikatory samochodów ...
        List<Car> carsCatalogDelete = carService.list();
        // .. usuwamy samochód za pomocą serwisu ...
        Car firstCarToDelete = carsCatalogDelete.get(0);
        Integer firstCarToDeleteId = firstCarToDelete.getId();
        carService.delete(firstCarToDeleteId);

        System.out.println("Samochód został usunięty z katalogu");
        System.out.println(carsCatalog + "\n");
    }
}
