package oc.wh40k.units.hhca;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class HHCAPrimarisLightningStrikeFighter extends Eintrag {

    OptionsZaehlerGruppe o1, o2;
    OptionsUpgradeGruppe o3;

    public HHCAPrimarisLightningStrikeFighter() {
        name = "Primaris-Lightning Strike Fighter";
        grundkosten = 135;

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Twin-linked autocannon", 20));
        ogE.addElement(new OptionsGruppeEintrag("Twin-linked multilaser", 20));
        ogE.addElement(new OptionsGruppeEintrag("TL missile launcher", "Twin-linked missile launcher", 25));
        ogE.addElement(new OptionsGruppeEintrag("Sunfury heavy missiles", 15));
        ogE.addElement(new OptionsGruppeEintrag("Kraken missiles", "Kraken penetrator heavy missiles", 25));
        ogE.addElement(new OptionsGruppeEintrag("Phosphex bomb cluster", 25));
        ogE.addElement(new OptionsGruppeEintrag("Storm charges", "Electromagnetic storm charges", 20));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
        ogE.addElement(new OptionsGruppeEintrag("Rad missiles", 15));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Battle Servitor Control", 15));
        ogE.addElement(new OptionsGruppeEintrag("Ground-tracking Auguries", 10));
        ogE.addElement(new OptionsGruppeEintrag("Ramjet Diffraction Grid", 20));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));

        complete();
    }

    @Override
    public void refreshen() {

        o2.setMaxAnzahl(o1.getAnzahl(2));

    }

}
