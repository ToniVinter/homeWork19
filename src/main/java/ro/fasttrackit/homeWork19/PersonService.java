package ro.fasttrackit.homeWork19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonService {
    private final List<Person> persons;

    public PersonService(List<Person> persons) {
        this.persons = new ArrayList<>(persons);
    }

    public List<String> getFullName() {
        return persons.stream()
                .map(p -> p.getFirstName() + " " + p.getLastName())
                .collect(Collectors.toList());
    }

    public List<Person> getMajorPersons() {
        return persons.stream()
                .filter(p -> p.getAge() > 18)
                .collect(Collectors.toList());
    }

    public List<Person> personsFromOradea() {
        return persons.stream()
                .filter(p -> p.getCity().equalsIgnoreCase("oradea"))
                .collect(Collectors.toList());
    }

    public List<Person> personsFromOradeaOrCluj() {
        return persons.stream()
                .filter(p -> p.getCity().equalsIgnoreCase("oradea") || p.getCity().equalsIgnoreCase("cluj"))
                .collect(Collectors.toList());
    }

    public List<String> getCapitalizedName() {
        return persons.stream()
                .map(p -> p.getFirstName().toUpperCase())
                .collect(Collectors.toList());
    }

    public List<String> getNamesCustomized() {
        return persons.stream()
                .map(p -> p.getFirstName() + p.getLastName().toUpperCase().charAt(0) + ".")
                .collect(Collectors.toList());
    }

    public List<Person> getCustomAgeSelection(){
        return persons.stream()
                .filter(p -> p.getAge() > 18)
                .filter(p -> p.getAge() < 60)
                .collect(Collectors.toList());
    }

    public List<Person> getPersonsWithA(){
        return persons.stream()
                .filter(p -> p.getLastName().startsWith("A"))
                .collect(Collectors.toList());
    }

    public List<String> getUniquePersons(){
        return persons.stream()
                .map(Person::getFirstName)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Person> orderPersonsByFName(){
        return persons.stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());
    }

    public List<Person> orderPersonsByLName(){
        return persons.stream()
                .sorted(Comparator.comparing(Person::getLastName))
                .collect(Collectors.toList());
    }

    public List<Person> customOrder(){
        return persons.stream()
                .sorted(Comparator.comparing(Person::getFirstName)
                        .thenComparing(Person::getLastName)
                        .thenComparing(Person::getAge))
                .collect(Collectors.toList());
    }


}
