package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMBjorntheFellHanded extends Eintrag {
	private final OptionsUpgradeGruppe o1, o2;

    public IMBjorntheFellHanded() {
        name = "Bjorn the Fellhanded";
        grundkosten = getPts("Bjorn the Fellhanded");
        power = 14;

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Assault cannon", getPts("Assault cannon (other)")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy plasma cannon", getPts("Heavy plasma cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Helfrost cannon", getPts("Helfrost cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Twin lascannon", getPts("Twin lascannon")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        seperator();
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("True Claw & Heavy Flamer", getPts("Heavy Flamer")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
        o1.alwaysSelected();
        o2.alwaysSelected();
    }

}
