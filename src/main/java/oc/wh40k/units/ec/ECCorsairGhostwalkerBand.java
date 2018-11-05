package oc.wh40k.units.ec;

import oc.*;

public class ECCorsairGhostwalkerBand extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1, o1x;
    OptionsZaehlerGruppe o2;
    OptionsEinzelUpgrade jetpacks;
    OptionsEinzelUpgrade drugs;
    OptionsEinzelUpgrade rage;

    public ECCorsairGhostwalkerBand() {
        name = "Corsair Ghostwalker Band\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Corsair Ghostwalkers", 5, 10, 12);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ECCorsairSquad.jpg"));

        seperator();

        add(jetpacks = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Corsair Jet Packs", 5));

        seperator();


        ogE.addElement(new OptionsGruppeEintrag("Lasblaster", 0));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Eldar longrifle", 1));
        ogE.addElement(new OptionsGruppeEintrag("Ccw + pistols", "Close combat weapon + a brace of pistols", 0));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Fusion gun", 10));
        ogE.addElement(new OptionsGruppeEintrag("Shredder", 5));
        ogE.addElement(new OptionsGruppeEintrag("Blaster", 10));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Haywire Grenades", 25));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Tanglefield Grenades", 10));

        seperator();

        add(drugs = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Combat drugs", 15));
        add(rage = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rage SR", 0));

    }

    @Override
    public void refreshen() {

        jetpacks.setModelle(squad.getModelle());
        o1x.setMaxAnzahl(squad.getModelle() - o1.getAnzahl() - o2.getAnzahl());
        o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl() - o2.getAnzahl());
        o1.setMaxAnzahl(squad.getModelle() - o2.getAnzahl());
        int o2max = squad.getModelle() / 5 * 2;
        int oSel = squad.getModelle() - o1.getAnzahl();
        o2.setMaxAnzahl(oSel < o2max ? oSel : o2max);

        drugs.setAktiv(getCountFromInformationVector("ECPrinceTrait") == 0);
        rage.setAktiv(getCountFromInformationVector("ECPrinceTrait") == 3);
    }

}
