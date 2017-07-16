/**
 * Created by Srinath on 7/16/2017.
 */
public class Element {

    private int protons;
    private int electrons;
    private int neutrons;
    private String name = "Unknown";

    public void setProtons(int protons) {
        this.protons = protons;
    }

    public void setElectrons(int electrons) {
        this.electrons = electrons;
    }

    public void setNeutrons(int neutrons) {
        this.neutrons = neutrons;
    }

    public String getName() {

        switch (protons) {
            case 1: return "Hydrogen";
            case 2: return "Helium";
            case 3: return "Lithium";
            case 4: return "Beryllium";
            case 5: return "Boron";
            case 6: return "Carbon";

            default: return "Unknown";
        }


    }

}
