import java.util.List;

public class Main {
    public static void main(String[] args) {
        PlantUMLRunner.setjarPath("/home/student/Pobrane/plantuml-1.2025.2.jar");
        try {
            List<Person> personList = Person.fromCsv("family.csv");

            Person.toBinaryFile(personList, "family.bin");
            List<Person> family = Person.fromBinaryFile("family.bin");

            System.out.println(family.size());
            for (Person p : family) {
                System.out.println(p);
                System.out.println("Dzieci:");
                for (Person child: p.getChildren()) {
                    System.out.println("\t"+child.getFullName());
                }
            }
//            String umlData = Person.umlFromList(
//                    family,
//                    Function.identity()     // bez przekształcenia
//            );
            String umlData = Person.umlFromList(
                    family,
                    uml -> uml.replaceFirst("\\{", "#yellow {"),
                    person -> Person.selectDeceased(family).contains(person) ||
                            Person.getOldestAlive(family) == person
                    );
            PlantUMLRunner.generateDiagram(umlData,
                    "/home/student/Pobrane/",
                    "diagram.png");
            System.out.println(umlData);

            // z4-7
            System.out.println(Person.selectSurnames(family, "dąb"));
            System.out.println(Person.sortedByBirth(family));
            System.out.println(Person.selectDeceased(family));
            System.out.println(Person.getOldestAlive(family));


        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}