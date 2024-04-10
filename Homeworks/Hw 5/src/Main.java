/*
Create the classes TouristicPackage and Attraction.
A package has a name, id and price and also a list of attractions.
An attraction has a name and location.

Create 10 different packages each one with 2-3 attractions.
(make sure that some attractions repeat in more packages).
Add the packages to a List<TouristicPackage>.
This list represents the list of sold packages.

We are interested in determining which are the most popular attractions.
For that we create a Map<Attraction,Integer> which stores how many times each attraction was bought.
We populate this Map by parsing the List created earlier.
Check the results.
(Attractions should be unique in order to be used as keys for the map, what does this imply?)

It is not enough to know just the number of times an attraction
was bought because it depends on the total number of sales.
We want to know the relative popularity of an attraction.
For example if 5 touristic packages, each with 2 attractions, were bought
and "Paltinis" as an attraction appeared 2 times it means that
it has a relative popularity of 2/10. Create a Map<Attraction,Double>
which stores the relative popularity of each attraction.
Populate this Map by parsing the Map created earlier. Check the results.

Print for each attraction how many times it was bought and its relative popularity.

*/
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Attraction a1 = new Attraction("Paltinis", "Sibiu");
        Attraction a2 = new Attraction("VUNK", "Sibiu");
        Attraction a3 = new Attraction("Castelul Corvinilor", "Hunedoara");
        Attraction a4 = new Attraction("Castelul Bran", "Brasov");
        Attraction a5 = new Attraction("Cetatea Alba Carolina", "Alba Iulia");
        Attraction a6 = new Attraction("Cetatea Deva", "Deva");
        Attraction a7 = new Attraction("Cetatea Sighisoara", "Sighisoara");
        Attraction a8 = new Attraction("Cetatea Rasnov", "Rasnov");
        Attraction a9 = new Attraction("Cetatea Fagaras", "Fagaras");
        Attraction a10 = new Attraction("Cetatea Sibiu", "Sibiu");
        Attraction a11 = new Attraction("Cetatea Hunedoara", "Hunedoara");
        Attraction a12 = new Attraction("Cetatea Brasov", "Brasov");

        TouristicPackage tp1 = new TouristicPackage("Sibiu", 1, 100, List.of(a1, a2, a10));
        TouristicPackage tp2 = new TouristicPackage("Hunedoara", 2, 200, List.of(a3, a11));
        TouristicPackage tp3 = new TouristicPackage("Brasov", 3, 300, List.of(a4, a12));
        TouristicPackage tp4 = new TouristicPackage("Alba Iulia", 4, 400, List.of(a5));
        TouristicPackage tp5 = new TouristicPackage("Deva", 5, 500, List.of(a6));
        TouristicPackage tp6 = new TouristicPackage("Sighisoara", 6, 600, List.of(a7));
        TouristicPackage tp7 = new TouristicPackage("Rasnov", 7, 700, List.of(a8));
        TouristicPackage tp8 = new TouristicPackage("Fagaras", 8, 800, List.of(a9));
        TouristicPackage tp9 = new TouristicPackage("Paltinis", 9, 900, List.of(a1));
        TouristicPackage tp10 = new TouristicPackage("VUNK", 10, 1000, List.of(a2));
        List<TouristicPackage> soldPackages = List.of(tp1, tp2, tp3, tp4, tp5, tp6, tp7, tp8, tp9, tp10);


        System.out.println("Absolute Popularity: ");
        Map<Attraction, Integer> attractionsPopularity = new HashMap<>();
        for (TouristicPackage tp : soldPackages) {
            for (Attraction a : tp.getAttractions()) {
                if (attractionsPopularity.containsKey(a)) {
                    attractionsPopularity.put(a, attractionsPopularity.get(a) + 1);
                } else {
                    attractionsPopularity.put(a, 1);
                }
            }
        }

        for (Attraction a : attractionsPopularity.keySet()) {
            System.out.println(a.getName() + " was bought " + attractionsPopularity.get(a) + " times");
        }

        System.out.println("----------------------------------------");

        System.out.println("Relative Popularity: ");
        Map<Attraction, Double> relativePopularity = new HashMap<>();
        for (Attraction a : attractionsPopularity.keySet()) {
            relativePopularity.put(a, attractionsPopularity.get(a) / (double) soldPackages.size());
        }

        for (Attraction a : attractionsPopularity.keySet()) {
            System.out.println(a.getName() + " was bought " + attractionsPopularity.get(a) + " times and has a relative popularity of " + relativePopularity.get(a));
        }
    }
}