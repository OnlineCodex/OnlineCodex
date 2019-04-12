package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMOgrynBodyguard extends Eintrag {
	private final OptionsUpgradeGruppe o1, o2;

    public IMOgrynBodyguard() {
        name = "Ogryn Bodyguard";
        grundkosten = getPts("Ogryn Bodyguard") + getPts("Frag bombs");
        power = 4;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Ripper gun", getPts("Ripper gun")));
        ogE.addElement(new OptionsGruppeEintrag("Grenadier Gauntlet", getPts("Grenadier Gauntlet")));
        ogE.addElement(new OptionsGruppeEintrag("Bullgryn maul", getPts("Bullgryn maul")));
        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "option", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Huge knife", getPts("Huge knife")));
        ogE.addElement(new OptionsGruppeEintrag("Slabshield", getPts("Slabshield")));
        ogE.addElement(new OptionsGruppeEintrag("Brute shield", getPts("Brute shield")));
        add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "option", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bullgryn plate", getPts("Bullgryn plate")));

        seperator();

        addWarlordTraits("");

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
}
