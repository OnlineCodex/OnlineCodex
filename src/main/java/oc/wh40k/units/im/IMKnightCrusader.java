package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMKnightCrusader extends Eintrag {
    OptionsUpgradeGruppe o1, o2, o3;
    OptionsUpgradeGruppe fk1;
    OptionsUpgradeGruppe fk2;

    public IMKnightCrusader() {
        name = "Knight Crusader";
        grundkosten = getPts("Knight Crusader") + getPts("Titanic feet");
        power = 25;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Avenger gatling cannon", getPts("Avenger gatling cannon")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer (QI)")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE = IMQuestorImperialisCarapaceWeapons.createRK("", "", buildaVater);
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Thermal cannon", getPts("Thermal cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Battle cannon + stubber", "Rapid-fire battle cannon + Heavy stubber", getPts("Rapid-fire battle cannon") + getPts("Heavy stubber (QI)")));
        add(fk1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", getPts("Heavy stubber (QI)")));
        ogE.addElement(new OptionsGruppeEintrag("Melta gun", getPts("Melta gun (QI)")));
        add(fk2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        setInformationVectorValue("Knight selected", getCountFromInformationVector("Knight selected") + 1);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        fk1.alwaysSelected();
        fk2.alwaysSelected();
        o2.alwaysSelected();
        o3.alwaysSelected();
    }
    
    //@OVERRIDE
    public void deleteYourself() {
        super.deleteYourself();

        setInformationVectorValue("Knight selected", getCountFromInformationVector("Knight selected") - 1);
    }
}
