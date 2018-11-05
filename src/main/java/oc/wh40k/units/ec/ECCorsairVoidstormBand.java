package oc.wh40k.units.ec;

import oc.*;

public class ECCorsairVoidstormBand extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1, o1x, o2, o3;
    OptionsEinzelUpgrade jetpacks;
    RuestkammerStarter rkFalcon;
    RuestkammerStarter rkVenom;
    OptionsEinzelUpgrade drugs;
    OptionsEinzelZaehler key;
    OptionsEinzelZaehler master;
    OptionsEinzelUpgrade rage;

    OptionsEinzelUpgrade armour;

    public ECCorsairVoidstormBand() {
        name = "Corsair Voidstorm Band\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Corsair Felarchs", 5, 10, 15);
        squad.setGrundkosten(-10);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ECCorsairSquad.jpg"));

        seperator();

        add(jetpacks = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Corsair Jet Packs", 5));

        seperator();

        add(armour = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Voidplate harness", 10));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Lasblaster", 0));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Splinter rifle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Shuriken catapult", 0));
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
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Void hardened armour", 10));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Close combat weapon", 0));
        ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power maul", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power lance", 15));
        ogE.addElement(new OptionsGruppeEintrag("Venom blade", 10));
        ogE.addElement(new OptionsGruppeEintrag("Blast pistol", 20));
        ogE.addElement(new OptionsGruppeEintrag("Dissonance pistol", 10));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        add(drugs = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Combat drugs", 15));
        add(key = new OptionsEinzelZaehler(ID, randAbstand, cnt, "Multiph. key gen.", "Multiphase key generator", 5, 25));
        add(master = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "master-crafted", 5, 10));
        add(rage = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rage SR", 0));

        seperator();

        rkVenom = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairVenomKammer", "Corsair Venom");
        rkVenom.initKammer();
        add(rkVenom);

        rkFalcon = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairFalconKammer", "Corsair Falcon");
        rkFalcon.initKammer();
        add(rkFalcon);

        complete();
    }

    @Override
    public void refreshen() {

        armour.setModelle(squad.getModelle());
        jetpacks.setModelle(squad.getModelle());
        o1x.setMaxAnzahl(squad.getModelle() - o1.getAnzahl() - o2.getAnzahl());
        o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl() - o2.getAnzahl());
        o1.setMaxAnzahl(squad.getModelle() - o2.getAnzahl());
        int o2max = squad.getModelle() / 5 * 2;
        int oSel = squad.getModelle() - o1.getAnzahl();
        o2.setMaxAnzahl(oSel < o2max ? oSel : o2max);
        o3.setMaxAnzahl(squad.getModelle() * 2);

        drugs.setAktiv(getCountFromInformationVector("ECPrinceTrait") == 0);
        key.setAktiv(getCountFromInformationVector("ECPrinceTrait") == 1);
        key.setMaxAnzahl(squad.getModelle());
        master.setAktiv(getCountFromInformationVector("ECPrinceTrait") == 2);
        master.setMaxAnzahl(squad.getModelle());
        rage.setAktiv(getCountFromInformationVector("ECPrinceTrait") == 3);

        rkFalcon.setAktiv(squad.getModelle() > 5 && !rkVenom.isSelected() && !jetpacks.isSelected());
        rkVenom.setAktiv(squad.getModelle() <= 5 && !rkFalcon.isSelected() && !jetpacks.isSelected());
    }

}
