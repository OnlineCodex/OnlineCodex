package oc.wh40k.units.sm;


import oc.*;

public class SMSentryGunBattery extends Eintrag {

    AnzahlPanel SentryGuns;
    OptionsZaehlerGruppe SentryGunsFK;
    OptionsZaehlerGruppe SentryGunsFKE;
    OptionsEinzelUpgrade hyperion;
    OptionsZaehlerGruppe hyperiosE;
    OptionsEinzelUpgrade camo;
    OptionsEinzelUpgrade ds;

    public SMSentryGunBattery() {

        kategorie = 5;

        grundkosten = 0;

        SentryGuns = new AnzahlPanel(ID, randAbstand, cnt, "Sentry Gun", "Sentry Guns", 1, 3, 15);
        add(SentryGuns);

        add(ico = new oc.Picture("oc/wh40k/images/TLLegionSentryGunBattery.gif"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("TL heavy bolter", 0));
        add(SentryGunsFKE = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta + Searchlight", 5));
        ogE.addElement(new OptionsGruppeEintrag("TL lascannon", 15));
        add(SentryGunsFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        add(hyperion = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hyperios missile launcher", 20));
        ogE.addElement(new OptionsGruppeEintrag("Hyperios command platform", 20));
        add(hyperiosE = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        add(camo = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Camo netting", 10));
        add(ds = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Deepstrike SR", 10));

        complete();
    }

    //@OVERRIDE
    public void refreshen() {

        SentryGunsFKE.setMaxAnzahl(SentryGuns.getModelle() - SentryGunsFK.getAnzahl());
        SentryGunsFKE.setAnzahl(0, SentryGuns.getModelle() - SentryGunsFK.getAnzahl());
        SentryGunsFK.setMaxAnzahl(SentryGuns.getModelle());

        SentryGunsFK.setAktiv(!hyperion.isSelected());
        SentryGunsFKE.setAktiv(!hyperion.isSelected());
        hyperiosE.setAktiv(hyperion.isSelected());
        hyperiosE.setMaxAnzahl(SentryGuns.getModelle());

        hyperion.setPreis(SentryGuns.getModelle() * 20);
        camo.setPreis(SentryGuns.getModelle() * 10);
        ds.setPreis(SentryGuns.getModelle() * 10);

    }
}
