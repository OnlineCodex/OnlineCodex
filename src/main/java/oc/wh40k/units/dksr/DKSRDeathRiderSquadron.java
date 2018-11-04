package oc.wh40k.units.dksr;

import oc.*;

public class DKSRDeathRiderSquadron extends RuestkammerVater {

    AnzahlPanel squad;
    OptionsUpgradeGruppe o3;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;

    boolean kamirSelected = false;

    public DKSRDeathRiderSquadron() {
        grundkosten = 0;
    }

    public void initButtons(boolean... defaults) {
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Death Riders", 5, 10, 15);
        squad.setGrundkosten(10);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/IGRoughRaiderSquad.jpg"));

        seperator();

        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "", "Ridemaster-Upgrade", 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 1));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power maul", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power lance", 10));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

        seperator(5);

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melta bombs", 5));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        oe2.setSelected(true);
    }

}
