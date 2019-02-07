package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMKnightValiant extends Eintrag {
    OptionsUpgradeGruppe o1, o2, o3;
    OptionsUpgradeGruppe fk1;
    OptionsUpgradeGruppe fk2;
    OptionsUpgradeGruppe fk3;

    public IMKnightValiant() {
        name = "Knight Valiant";
        grundkosten = getPts("Knight Valiant") + getPts("Titanic feet");
        power = 30;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Thundercoil harpoon", getPts("Thundercoil harpoon")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Conflagration cannon", getPts("Conflagration cannon")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Two shieldbreaker missiles", getPts("Shieldbreaker missile") * 2));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Two twin meltaguns", getPts("Twin meltaguns") * 2));
        add(fk1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin siegebreaker cannon", getPts("Twin siegebreaker cannon")));
        add(fk2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Two shieldbreaker missiles", getPts("Shieldbreaker missile") * 2));
        ogE.addElement(new OptionsGruppeEintrag("Twin siegebreaker cannon", getPts("Twin siegebreaker cannon")));
        add(fk3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        setInformationVectorValue("Knight selected", getCountFromInformationVector("Knight selected") + 1);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        fk1.alwaysSelected();
        fk2.alwaysSelected();
        o2.alwaysSelected();
        o3.alwaysSelected();
        o1.alwaysSelected();
        fk3.alwaysSelected();
    }
    
    //@OVERRIDE
    public void deleteYourself() {
        super.deleteYourself();

        setInformationVectorValue("Knight selected", getCountFromInformationVector("Knight selected") - 1);
    }
}
