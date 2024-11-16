package lab1.task3;

import lab1.task1.Display;

public class Main {
    public static void main(String[] args) {
        // create assistant
        Assistant assistant = new Assistant("Ash");

        // create displays (reusing from task1)
        Display d1 = new Display(1920, 1080, 141, "Display 1");
        Display d2 = new Display(3840, 2160, 282, "Dispaly 2");
        Display d3 = new Display(2560, 1440, 185, "Display 3");

        // assign displays to assistant
        assistant.assignDisplay(d1);
        assistant.assignDisplay(d2);
        assistant.assignDisplay(d3);

        // get comparison help
        System.out.println("Assistant comparing all displays:");
        assistant.assist();

        // buy a display
        System.out.println("\nBuying Dispaly 2 display:");
        Display bought = assistant.buyDisplay(d2);

        System.out.println("\nComparing remaining displays:");
        assistant.assist();
    }
}