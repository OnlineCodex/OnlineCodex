package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;
import oc.wh40k.units.Warlordtraits;

public class IMLibrarianDreadnought extends Eintrag {

    OptionsUpgradeGruppe o2;
    RuestkammerStarter psychicPowers;
    RuestkammerStarter warlord;

    public IMLibrarianDreadnought() {
        name = "Librarian Dreadnought";
        grundkosten = getPts("Librarian Dreadnought") + getPts("Furioso force halberd") + getPts("Furioso fist (single)");
        power = 10;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", "Storm bolter", getPts("Storm bolter (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", "Heavy flamer", getPts("Heavy flamer (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun (SM)")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableSanguinary();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        add(warlord);

        complete();
    }

    @Override
    public void refreshen() {
        o2.alwaysSelected();
        warlord.getPanel().setLocation(
                (int) warlord.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}
