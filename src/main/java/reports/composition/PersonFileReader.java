package reports.composition;

import reports.Person;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonFileReader implements PersonProvider {

    private final String inputFile;

    public PersonFileReader(String inputFile) {
        this.inputFile = inputFile;
    }

    @Override
    public List<Person> readPersons() {
        try {
            List<Person> personList = new ArrayList<>();
            Scanner reader = new Scanner(new FileReader(inputFile));
            while (reader.hasNextLine()) {
                personList.add(readPerson(reader.nextLine()));
            }
            return personList;
        } catch (IOException e) {
            System.out.println("Cannot read from this file: " + inputFile);
        }
        return List.of();
    }

    private Person readPerson(String line) {
        String[] person = line.split(",");
        return new Person(person[0], person[1], Integer.parseInt(person[2]));
    }

}
