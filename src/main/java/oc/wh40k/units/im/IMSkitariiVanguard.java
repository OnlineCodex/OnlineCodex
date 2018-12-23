package oc.wh40k.units.im;

import oc.*;

public class IMSkitariiVanguard extends Eintrag {

    private final AnzahlPanel squad;
    private final OptionsZaehlerGruppe o2;

    public IMSkitariiVanguard() {
        name = "Skitarii Vanguard";
        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Skitarii Vanguard", 5, 10, getPts("Skitarii Vanguard")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Enh. data-tehter", "Enhanced data-tehter", getPts("Enhanced data-tether")));
        ogE.addElement(new OptionsGruppeEintrag("Omnispex", getPts("Omnispex")));
        OptionsUpgradeGruppe o1;
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE = IMAdeptusMechanicusSpecialWeapons.createRK("Radium carbine", "Radium carbine", buildaVater);
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        RuestkammerStarter rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new IMAdeptusMechanicusRuestkammer("Vanguard Alpha", true, false, false, false), "Vanguard Alpha");
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setAbwaehlbar(false);
        add(rkBoss);

        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() >= 10)
            o2.setMaxAnzahl(3);
        else
            o2.setMaxAnzahl(2);

        power = 4;
        if (squad.getModelle() > 5) {
            power = 8;
        }
    }
}