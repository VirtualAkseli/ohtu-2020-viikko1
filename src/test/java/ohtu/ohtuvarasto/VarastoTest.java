package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    Varasto huonoVarasto;
    Varasto mahdotonVarasto;
    Varasto kunnonVarasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
        huonoVarasto = new Varasto(0.0);
        mahdotonVarasto = new Varasto(2, -2);
        kunnonVarasto = new Varasto(2, 2);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenEiMeneYli() {

        varasto.lisaaVarastoon(4);

        varasto.otaVarastosta(11);

        // varastossa pitäisi olla tilaa 10 - 4 + 6 eli 10 (ylimenoa ei sallittu)
        assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void eiVoiLisätäLiikaa() {
        varasto.lisaaVarastoon(20);
        assertEquals(0, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void huonoVarastoRakentuuOikein() {
        Varasto huonoVarasto = new Varasto(0.0, 0.1);
        assertEquals(0, huonoVarasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void mahdotonVarastoRakentuuOikein() {
        assertEquals(0, mahdotonVarasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void kunnonVarastoHuonoOtto() {
        kunnonVarasto.otaVarastosta(-2);

        assertEquals(2, kunnonVarasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void varastoHuonoLisäys() {
        varasto.lisaaVarastoon(-2);

        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void varastonTulostusOikein() {
        String oikein = "saldo = 0.0, vielä tilaa 10.0";

        assertEquals(oikein, varasto.toString());
    }

}
