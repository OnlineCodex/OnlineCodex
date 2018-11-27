package oc.wh40k.units.ty;

import oc.*;

public class TYWarlordtraits extends Eintrag {
    OptionsUpgradeGruppe fk1;

    public TYWarlordtraits() {
        name = "Warlord Traits";
        grundkosten = 0;
        power = 0;

        ogE.addElement(new OptionsGruppeEintrag("Alien Cunning", 0));
        ogE.addElement(new OptionsGruppeEintrag("Heightened Senses", 0));
        ogE.addElement(new OptionsGruppeEintrag("Synaptic Lynchpin", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mind Eater", 0));
        ogE.addElement(new OptionsGruppeEintrag("Instinctive Killer", 0));
        ogE.addElement(new OptionsGruppeEintrag("Adaptive Biology", 0));

        ogE.addElement(new OptionsGruppeEintrag("Behemoth: Monstrous Hunger", 0));
        ogE.addElement(new OptionsGruppeEintrag("Kraken: One Step Ahead", 0));
        ogE.addElement(new OptionsGruppeEintrag("Leviathan: Perfectly Adapted", 0));
        ogE.addElement(new OptionsGruppeEintrag("Gorgon: Lethal Miasma", 0));
        ogE.addElement(new OptionsGruppeEintrag("Jormungandr: Insidious Threat", 0));
        ogE.addElement(new OptionsGruppeEintrag("Hydra: Endless Regeneration", 0));
        ogE.addElement(new OptionsGruppeEintrag("Kronos: Soul hunger", 0));
        add(fk1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1, false));

        this.eintragsCNT = 0;

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        fk1.alwaysSelected();
    }
}
