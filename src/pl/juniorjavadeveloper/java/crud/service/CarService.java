package pl.juniorjavadeveloper.java.crud.service;

import pl.juniorjavadeveloper.java.crud.model.Car;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * CRUD Service dla klasy Car
 */
public class CarService {
    // lista przechowująca wszystkie samochody
    // tylko i wyłącznie dla uproszczenia kodu aplikacji
    // normalnie dane powinny być przechowywane w bazie z użyciem DAO
    private List<Car> carsCatalog = new ArrayList<>();

    // pozwala generować unikalne identyfikatory samochodów
    private Random randomCarId = new Random();

    /**
     * C - create - tworzy/zapisuje samochód do katalogu.
     *
     * @param car Dane samochodu do utworzenia/zapisania w katalogu
     * @return Utworzony samochód z unikalnym identyfikatorem
     */
    public Car create(Car car) {
        // generowanie unikalnego identyfikatora samochodu
        int id = randomCarId.nextInt(100_000);
        // ustawienie unikalnego identyfikatora dla samochodu
        car.setId(id);

        // dodanie nowego samochodu do katalogu
        carsCatalog.add(car);
        // zwrócenie utworzonego samochodu z unikalnym identyfikatorem
        return car;
    }

    /**
     * R - read - odczytuje/wyszukuje samochód z katalogu.
     *
     * @param id Unikalny identyfikator samochodu w katalogu
     * @return Odczytany z katalogu samochód
     */
    public Car read(Integer id) {
        // iterujemy po liście/katlogu samachodów
        for (Car car : carsCatalog) {
            // dla każdego samochodu w katalogu ...
            // ... sprawdzamy czy identyfiktory zgadzają się
            if (car.getId().equals(id)) {
                // jeżeli identyfikatory są zgodne, to ...
                // ... zwracamy wyszukany/odczytany samochód
                return car;
            }
        }
        // jeżeli nie znaleziono szukanego samochodu zwracamy null
        return null;
    }

    /**
     * U - update - modyfikuje dane samochodu w katalogu.
     *
     * @param id        Identyfikator samochodu do modyfikacji danych
     * @param carUpdate Aktualne/nowe dane samochodu
     * @return Zmodyfikowany samochód w katalogu
     */
    public Car update(Integer id, Car carUpdate) {
        // iterujemy po liście/katlogu samachodów
        for (Car car : carsCatalog) {
            // dla każdego samochodu w katalogu ...
            // ... sprawdzamy czy identyfiktory zgadzają się
            if (car.getId().equals(id)) {
                // jeżeli identyfikatory są zgodne, to ...
                // ... modyfikujemy dane samochodu ...
                car.setYear(carUpdate.getYear());
                car.setModel(carUpdate.getModel());
                car.setManufacturer(carUpdate.getManufacturer());
                car.setPrice(carUpdate.getPrice());

                // ... zwracamy zmodyfikowany samochód
                return car;
            }
        }
        // jeżeli nie znaleziono szukanego samochodu zwracamy null
        return null;
    }

    /**
     * D - delete - usuwa samochód z katalogu.
     *
     * @param id Identyfikator samochodu do usunięcia z katalogu.
     */
    public void delete(Integer id) {
        // tworzymy Iterator dla naszej listy,
        // aby uniknąć wyjątku ConcurrentModificationException
        // podczas jednoczesnego iterowania po liście
        // i usuwania z niej elementów
        Iterator<Car> iterator = carsCatalog.iterator();
        // wykonujemy operacje dopóki Iterator ma kolejne elementy
        while (iterator.hasNext()) {
            // pobieramy kolejny element
            Car car = iterator.next();
            // jeżeli identyfikatory są zgodne, to ...
            if (car.getId().equals(id)) {
                // ... usuwamy samochód z listy
                iterator.remove();
            }
        }
    }

    /**
     * L - List - zwraca wszystkie samochody z katalogu.
     *
     * @return Lista samochodów
     */
    public List<Car> list() {
        return carsCatalog;
    }

}
