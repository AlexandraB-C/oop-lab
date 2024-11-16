package lab1.task3;

import java.util.ArrayList;
import java.util.List;

import lab1.task1.Display;

public class Assistant {
    private String assistantName;
    private List<Display> assignedDisplays;

    // constructor
    public Assistant(String name) {
        this.assistantName = name;
        this.assignedDisplays = new ArrayList<>();
    }

    // add display to list
    public void assignDisplay(Display d) {
        assignedDisplays.add(d);
    }

    // compare all displays
    public void assist() {
        if (assignedDisplays.size() < 2) {
            System.out.println("need at least 2 displays to compare");
            return;
        }

        for (int i = 0; i < assignedDisplays.size() - 1; i++) {
            System.out.println("\nComparing display " + (i + 1) + " with display " + (i + 2) + ":");
            assignedDisplays.get(i).compareWithMonitor(assignedDisplays.get(i + 1));
        }
    }

    // remove and return display
    public Display buyDisplay(Display d) {
        if (assignedDisplays.remove(d)) {
            System.out.println("display purchased successfully");
            return d;
        }
        System.out.println("display not found");
        return null;
    }
}