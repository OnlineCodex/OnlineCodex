package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class IMTerminatorAncient extends Eintrag {
    OptionsUpgradeGruppe o2;
    RuestkammerStarter warlord;

    public IMTerminatorAncient() {
        name = "Terminator Ancient";
        grundkosten = getPts("Terminator Ancient");
        power = 6;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("lightning claw (single)")));
        ogE.addElement(new OptionsGruppeEintrag("thunder hammer", getPts("thunder hammer (Characters)")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
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
    }
}
