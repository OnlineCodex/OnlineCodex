package oc.wh40k.units.ec;

import oc.*;

public class ECCorsairMalevolentBand extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1x, o2;
    OptionsEinzelUpgrade jetpacks;

    OptionsEinzelUpgrade armour;
    OptionsEinzelUpgrade drugs;
    OptionsEinzelUpgrade rage;

    public ECCorsairMalevolentBand() {
        name = "Corsair Malevolent Band\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Corsair Malevolent", 5, 10, 15);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ECCorsairSquad.jpg"));

        seperator();

        add(jetpacks = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Corsair Jet Packs", 5));

        seperator();

        add(armour = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heavy mesh armour", 5));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Close combat weapons", 0));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power maul", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power lance", 15));
        ogE.addElement(new OptionsGruppeEintrag("Venom blade", 10));
        ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 20));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        add(drugs = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Combat drugs", 15));
        add(rage = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rage SR", 0));

        complete();
    }

    @Override
    public void refreshen() {

        armour.setModelle(squad.getModelle());
        jetpacks.setModelle(squad.getModelle());
        o1x.setMaxAnzahl(squad.getModelle() - o2.getAnzahl());
        o1x.setAnzahl(0, squad.getModelle() - o2.getAnzahl());
        int o2max = squad.getModelle() / 5 * 2;
        o2.setMaxAnzahl(o2max);

        drugs.setAktiv(getCountFromInformationVector("ECPrinceTrait") == 0);
        rage.setAktiv(getCountFromInformationVector("ECPrinceTrait") == 3);
    }

}
