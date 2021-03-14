package reports;

import reports.composition.InMemoryPersonProvider;
import reports.composition.PersonFileReader;
import reports.composition.ReportGenerator;
import reports.inheritance.FilePersonReportGenerator;
import reports.inheritance.MemoryPersonReportGenerator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        new MemoryPersonReportGenerator().generateReport(
                "C:\\Users\\SBela\\Desktop\\FullStack\\Homework2\\src\\main\\java\\reports\\inheritance\\memoryPersons.txt");

        var fileGenerator = new FilePersonReportGenerator("C:\\Users\\SBela\\Desktop\\FullStack\\Homework2\\src\\main\\resources\\people.txt");
        fileGenerator.generateReport("C:\\Users\\SBela\\Desktop\\FullStack\\Homework2\\src\\main\\java\\reports\\inheritance\\filePersons.txt");

        new ReportGenerator(new InMemoryPersonProvider()).generateReport(
                "C:\\Users\\SBela\\Desktop\\FullStack\\Homework2\\src\\main\\java\\reports\\composition\\fromMemoryPersons.txt");

        new ReportGenerator(new PersonFileReader(
                "C:\\Users\\SBela\\Desktop\\FullStack\\Homework2\\src\\main\\resources\\people.txt"))
                .generateReport("C:\\Users\\SBela\\Desktop\\FullStack\\Homework2\\src\\main\\java\\reports\\composition\\fromFilePersons.txt");

    }
}
