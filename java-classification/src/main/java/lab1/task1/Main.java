package lab1.task1;

public class Main {
    public static void main(String[] args) {
        // create 3 displays with different specs
        Display d1 = new Display(1920, 1080, 141, "Display 1");
        Display d2 = new Display(3840, 2160, 282, "Display 2");
        Display d3 = new Display(2560, 1440, 185, "Display 3");

        // compare displays
        System.out.println("Comparing Display 1 vs Display 2:");
        d1.compareWithMonitor(d2);
        
        System.out.println("\nComparing Display 2 vs Display 3:");
        d2.compareWithMonitor(d3);
        
        System.out.println("\nComparing Display 3 vs Display 1:");
        d3.compareWithMonitor(d1);
    }
}