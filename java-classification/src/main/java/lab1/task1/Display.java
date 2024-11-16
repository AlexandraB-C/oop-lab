package lab1.task1;
public class Display {
    // display specs
    private int width;
    private int height;
    private float ppi;
    private String model;

    // constructor
    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    // compare size with another display
    public void compareSize(Display m) {
        int thisArea = this.width * this.height;
        int otherArea = m.width * m.height;
        
        if (thisArea > otherArea) {
            System.out.println(this.model + " is larger than " + m.model);
        } else if (thisArea < otherArea) {
            System.out.println(this.model + " is smaller than " + m.model);
        } else {
            System.out.println("Both displays have the same size");
        }
    }

    // compare sharpness based on ppi
    public void compareSharpness(Display m) {
        if (this.ppi > m.ppi) {
            System.out.println(this.model + " is sharper than " + m.model);
        } else if (this.ppi < m.ppi) {
            System.out.println(this.model + " is less sharp than " + m.model);
        } else {
            System.out.println("Both displays have the same sharpness");
        }
    }

    // compare both size and sharpness
    public void compareWithMonitor(Display m) {
        compareSize(m);
        compareSharpness(m);
    }
}