package oc.wh40k.units.ne;

import oc.*;

public class NESentryPylon extends Eintrag {

    AnzahlPanel squad;
    OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade oe;

    public NESentryPylon() {
        name = "Sentry Pylon";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Sentry Pylon", 1, 3, getPts("Sentry Pylon"));
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Gauss exterminator", getPts("Gauss exterminator")));
        ogE.addElement(new OptionsGruppeEintrag("Heat cannon", getPts("Heat cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Focussed death ray", getPts("Focussed death ray")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator();

        add(oe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Teleportation matrix", getPts("Teleportation matrix")));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {

        power = 7 * squad.getModelle() + 1;

        o1.setPreis("Gauss exterminator", getPts("Gauss exterminator") * squad.getModelle());
        o1.setPreis("Heat cannon", getPts("Heat cannon") * squad.getModelle());
        o1.setPreis("Focussed death ray", getPts("Focussed death ray") * squad.getModelle());
        oe.setPreis(getPts("Teleportation matrix") * squad.getModelle());
    }
}
