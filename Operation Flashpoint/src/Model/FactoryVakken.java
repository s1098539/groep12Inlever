package Model;


public class FactoryVakken {
    Vak[][]vakken = new Vak[10][8];
    public FactoryVakken() {
    }

    public void createVakken() {

        for(int y = 0; y<8; y++) {
            for(int x = 0; x<10; x++) {
                vakken[x][y] = new Vak();
            }
        }
    }

    public Vak[][] getVakken() {
        return vakken;
    }
}
