package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CHDarkApostle extends Eintrag {

    private final RuestkammerStarter waffen;

    public CHDarkApostle() {
        name = "DarkApostle";
        grundkosten = getPts("DarkApostle");
        power = 5;

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, new CHWaffenkammer(name, "Bolt pistol", "Power maul", false, true, false, false));
        waffen.setButtonText("Waffenkammer");
        waffen.setAbwaehlbar(false);
        add(waffen);

        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) waffen.getPanel().getLocation().getY() + waffen.getPanel().getSize().height + 5
        );
    }
}
