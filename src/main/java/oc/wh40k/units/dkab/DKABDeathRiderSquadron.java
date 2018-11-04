package oc.wh40k.units.dkab;

import oc.*;

public class DKABDeathRiderSquadron extends RuestkammerVater {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o3;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;

    boolean kamirSelected = false;

    public DKABDeathRiderSquadron() {
        name = "Death Rider Squadron";
        grundkosten = 0;
    }

    public void initButtons(boolean... defaults) {
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Death Riders", 5, 10, 15);
        squad.setGrundkosten(10);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/IGRoughRaiderSquad.jpg"));

        seperator();

        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "", "Upgrade to Ridemaster", 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", 10));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

        seperator(5);

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melta bombs", 5));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        oe2.setSelected(true);
    }

}
