package oc.wh40k.units.ty;

import oc.*;

public class TYTyranidShrikes extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o3;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    OptionsEinzelUpgrade oe3;

    public TYTyranidShrikes() {
        name = "Tyranid Shrikes";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Tyranid Shrikes", 3, 9, getPts("Tyranid Shrikes"));
        add(squad);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/TYKrieger.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Devourer", getPts("Devourer")));
        ogE.addElement(new OptionsGruppeEintrag("Scything talons", getPts("Scything talons"))); //Basic Bio-Weapons
        ogE.addElement(new OptionsGruppeEintrag("Spinefists", getPts("Spinefists (Ravener)"))); //Basic Bio-Weapons
        ogE.addElement(new OptionsGruppeEintrag("Deathspitter", getPts("Deathspitter"))); //Basic Bio-Weapons
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator(5);

        ogE.addElement(new OptionsGruppeEintrag("Barbed Strangler", getPts("Barbed Strangler")));
        ogE.addElement(new OptionsGruppeEintrag("Venom cannon", getPts("Venom cannon")));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Scything talons", getPts("Scything talons")));
        ogE.addElement(new OptionsGruppeEintrag("Rending Claws", getPts("Rending Claws"))); //Melee Bio-Weapons
        ogE.addElement(new OptionsGruppeEintrag("Boneswords", getPts("Boneswords"))); //Melee Bio-Weapons
        ogE.addElement(new OptionsGruppeEintrag("Lash whip and bonesword", getPts("Lash whip and bonesword"))); //Melee Bio-Weapons
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (others)")));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxin sacs", getPts("Toxin sacs (Tyranid Shrike)")));
        add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Flesh Hooks", getPts("Flesh Hooks")));


        complete();
    }

    @Override
    public void refreshen() {

        o1.setMaxAnzahl(squad.getModelle() - o3.getAnzahl());
        o3.setMaxAnzahl(squad.getModelle() / 3);
        o2.setMaxAnzahl(squad.getModelle());

        o1.setLegal(squad.getModelle() == (o1.getAnzahl() + o3.getAnzahl()));
        o3.setLegal(squad.getModelle() == (o1.getAnzahl() + o3.getAnzahl()));
        o2.setLegal(squad.getModelle() == o2.getAnzahl());

        oe1.setPreis(squad.getModelle() * getPts("Adrenal glands (others)"));
        oe2.setPreis(squad.getModelle() * getPts("Toxin sacs (Tyranid Shrike)"));
        oe3.setPreis(squad.getModelle() * getPts("Flesh Hooks"));

        if (squad.getModelle() > 6) {
            power = 18;
        } else if (squad.getModelle() > 3) {
            power = 12;
        } else {
            power = 6;
        }
    }

}
