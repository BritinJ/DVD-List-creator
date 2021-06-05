import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class organizer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);
        Scanner pez = new Scanner(in);
        Scanner s = new Scanner(in);
        Scanner c = new Scanner(in);

        int choice;
        BlueRayCollection myColl = new BlueRayCollection();

        do {
            out.println("0. Quit\n1. Add BlueRay to collection\n2. see collection\n" +
                    "3. Search Collection\n4. Remove Blueray from collection");
            choice = s.nextInt();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    out.println("What is the title?");
                    String title = scan.nextLine();
                    out.println("What is the director?");
                    String director = pez.nextLine();
                    out.println("what is the year of release?");
                    int yof = c.nextInt();
                    out.println("what is the cost?");
                    double cost = s.nextDouble();
                    myColl.add(title, director, yof, cost);
                    break;
                case 2:
                    myColl.show_all();
                    break;
                case 3:
                    out.println("What title to search for?");
                    String search = scan.nextLine();
                    out.println(myColl.search(search));
                    break;
                case 4:
                    out.println("What title to remove");
                    String peach = scan.nextLine();
                    boolean found = myColl.remove(peach);
                    if (found) {
                        out.println(peach + " Deleted");
                    } else out.println("Not Found");
            }

        }
        while (choice != 0);


    }
}

class BlueRayDisk {
    public String title;
    public String director;
    public int year_of_release;
    public double cost;

    public BlueRayDisk(String title, String director, int year_of_release, double cost) {
        this.title = title;
        this.director = director;
        this.year_of_release = year_of_release;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "$" + cost + " " + year_of_release + " " + title + ", " + director;
    }

}

class Node {
    public BlueRayDisk disk;
    public Node next;
}

class BlueRayCollection {
    private Node head = null;

    public void add(String title, String director, int year, double cost) {
        Node newNode = new Node();

        newNode.disk = new BlueRayDisk(title, director, year, cost);
        newNode.next = null;
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }

    }

    public void show_all() {
        Node current = head;

        while (current != null) {
            out.println(current.disk.toString());

            current = current.next;

        }

    }

    public void prntTxt() {


    }


    public String search(String title) {
        String place = "Not Found";
        Node search = head;
        while (search != null) {
            if (search.disk.title.equals(title)) {
                place = search.disk.toString();
            }
            search = search.next;


        }
        return place;

    }

    public boolean remove(String title) {
        boolean found = false;
        Node curr = head;
        Node prev = curr;

        if (curr.disk.title.equals(title)) {
            found = true;
            head = curr.next;
        }
        while (!curr.disk.title.equals(title)) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        return found;
    }


}
