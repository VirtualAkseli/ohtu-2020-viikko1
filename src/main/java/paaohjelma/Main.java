package paaohjelma;

import ohtu.ohtuvarasto.Varasto;

public class Main {

    public static void main(String[] args) {

        Varasto mehua = new Varasto(100.0);
        Varasto olutta = new Varasto(100.0, 20.2);

        
        mehua.lisaaVarastoon(50.7);
        mehua.otaVarastosta(3.14);
        Varasto huono = new Varasto(-100.0);
       

        huono = new Varasto(100.0, -50.7);
        olutta.lisaaVarastoon(1000.0);
        mehua.lisaaVarastoon(-666.0);
        double saatiin = olutta.otaVarastosta(1000.0);
        saatiin = mehua.otaVarastosta(-32.9);  
    }
}
