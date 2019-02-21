package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMWulfenDreadnought extends Eintrag {
	private final OptionsUpgradeGruppe o1, o2;

    public IMWulfenDreadnought() {
        name = "Wulfen Dreadnought";
        grundkosten = getPts("Wulfen Dreadnought");
        power = 8;

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Fenrisian great axe", getPts("Fenrisian great axe")));
        ogE.addElement(new OptionsGruppeEintrag("Shield + Storm bolter", "Blizzard shield + Storm bolter", getPts("Blizzard shield") + getPts("Storm bolter (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Shield + Heavy flamer", "Blizzard shield + Heavy flamer", getPts("Blizzard shield") + getPts("Heavy flamer (SM)")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Claw + Storm bolter", "Great wolf claw + Storm bolter", getPts("Great wolf claw") + getPts("Storm bolter (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Claw + Heavy flamer", "Great wolf claw + Heavy flamer", getPts("Great wolf claw") + getPts("Heavy flamer (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Shield + Storm bolter", "Blizzard shield + Storm bolter", getPts("Blizzard shield") + getPts("Storm bolter (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Shield + Heavy flamer", "Blizzard shield + Heavy flamer", getPts("Blizzard shield") + getPts("Heavy flamer (SM)")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        o1.setAktiv( "Blizzard shield + Storm bolter", !o2.isSelected("Blizzard shield + Storm bolter") && !o2.isSelected("Blizzard shield + Heavy flamer"));
        o1.setAktiv( "Blizzard shield + Heavy flamer", !o2.isSelected("Blizzard shield + Storm bolter") && !o2.isSelected("Blizzard shield + Heavy flamer"));
        o2.setAktiv( "Blizzard shield + Storm bolter", !o1.isSelected("Blizzard shield + Storm bolter") && !o1.isSelected("Blizzard shield + Heavy flamer"));
        o2.setAktiv( "Blizzard shield + Heavy flamer", !o1.isSelected("Blizzard shield + Storm bolter") && !o1.isSelected("Blizzard shield + Heavy flamer"));
    }
}
