package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMKnightPreceptor extends Eintrag {
    OptionsUpgradeGruppe o1, o2;
    OptionsUpgradeGruppe fk1;
    OptionsUpgradeGruppe fk2;

    public IMKnightPreceptor() {
        name = "Knight Preceptor";
        grundkosten = getPts("Knight Preceptor") + getPts("Titanic feet");
        power = 23;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Las-impulsor", getPts("Las-impulsor")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE = IMQuestorImperialisCarapaceWeapons.createRK("", "", buildaVater);
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Reaper Chainsword", getPts("Reaper Chainsword")));
        ogE.addElement(new OptionsGruppeEintrag("Thunderstrike Gauntlet", getPts("Thunderstrike Gauntlet")));
        add(fk1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", getPts("Heavy stubber (QI)")));
        ogE.addElement(new OptionsGruppeEintrag("Melta gun", getPts("Melta gun (QI)")));
        ogE.addElement(new OptionsGruppeEintrag("Multi-laser", getPts("Multi-laser (QI)")));
        add(fk2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        setInformationVectorValue("Knight selected", getCountFromInformationVector("Knight selected") + 1);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        fk1.alwaysSelected();
        fk2.alwaysSelected();
        o2.alwaysSelected();
    }
    
    //@OVERRIDE
    public void deleteYourself() {
        super.deleteYourself();

        setInformationVectorValue("Knight selected", getCountFromInformationVector("Knight selected") - 1);
    }
}
