package oc.wh40k.units.dw;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class DWBikers extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o3;

    public DWBikers() {
        name = "Bike Squad\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Bikers", 1, 5, 30);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/Bikeschwadron.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Nahkampfwaffe", 0));
        ogE.addElement(new OptionsGruppeEintrag("Energie-Waffe", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energie-Schwert", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energie-Axt", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energie-Stab", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energie-Lanze", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energie-Streitkolben", 5));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Melterbomben", 5));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Teleportpeilsender", 10));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle());
        o2.setMaxAnzahl(squad.getModelle());
        o3.setMaxAnzahl(squad.getModelle());
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }

}

