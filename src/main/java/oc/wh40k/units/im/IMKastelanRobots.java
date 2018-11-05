package oc.wh40k.units.im;

import oc.*;

public class IMKastelanRobots extends Eintrag {

    AnzahlPanel robots, datasmith;
    OptionsZaehlerGruppe o1, o2;
    OptionsZaehlerGruppe o1x, o2x;
    RuestkammerStarter[] rat = new RuestkammerStarter[10];

    public IMKastelanRobots() {

        name = "Kastelan Robots";
        add(robots = new AnzahlPanel(ID, randAbstand, cnt, "Kastelan Robots", 2, 6, getPts("Kastelan Robots")));

        seperator();


        ogE.addElement(new OptionsGruppeEintrag("Kastelan fist", getPts("Kastelan fist")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, robots.getModelle()));
        ogE.addElement(new OptionsGruppeEintrag("2 Heavy Phosphor blasters", getPts("Heavy Phosphor blaster") * 2));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, robots.getModelle()));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Incendine Combustor", getPts("Incendine Combustor")));
        add(o2x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, robots.getModelle()));
        ogE.addElement(new OptionsGruppeEintrag("Heavy Phosphor blaster", getPts("Heavy Phosphor blaster")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, robots.getModelle()));

        complete();
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(robots.getModelle());
        o1x.setMaxAnzahl(robots.getModelle());
        o1x.setAnzahl(0, o1x.getMaxAnzahl() - o1.getAnzahl());

        o2.setMaxAnzahl(robots.getModelle());
        o2x.setMaxAnzahl(robots.getModelle());
        o2x.setAnzahl(0, o2x.getMaxAnzahl() - o2.getAnzahl());

        power = 12;
        if (robots.getModelle() > 4) {
            power = 36;
        } else if (robots.getModelle() > 2) {
            power = 24;
        }
    }

}
