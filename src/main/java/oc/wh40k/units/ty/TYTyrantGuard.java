package oc.wh40k.units.ty;

import oc.*;

public class TYTyrantGuard extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsEinzelUpgrade o3, o4;

    public TYTyrantGuard() {
        name = "Tyrant Guard";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Tyrant Guards", 3, 6, getPts("Tyrant Guard") + getPts("Rending Claws"));
        add(squad);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/TYTyrantenwache.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Scything talons", getPts("Scything talons")));
        ogE.addElement(new OptionsGruppeEintrag("Crushing Claws", getPts("Crushing Claws"))); //Melee Bio-Weapons
        ogE.addElement(new OptionsGruppeEintrag("Lash whip and bonesword", getPts("Lash whip and bonesword"))); //Melee Bio-Weapons
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (others)")));
        add(o4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxin sacs", getPts("Toxin sacs (Tyrant Guard)")));

        complete();
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle());
        o1.setLegal(o1.getAnzahl() == squad.getModelle());

        o3.setPreis(squad.getModelle() * getPts("Adrenal glands (others)"));
        o4.setPreis(squad.getModelle() * getPts("Toxin sacs (Tyrant Guard)"));

        if (squad.getModelle() > 3) {
            power = 14;
        } else {
            power = 7;
        }
    }

}
