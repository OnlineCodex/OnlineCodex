package oc.wh40k.units.or;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class ORWaffenUndGeschenke extends RuestkammerVater {

    public boolean uniqueError = false;
    public boolean megaruestung = false;
    private OptionsUpgradeGruppe handwaffen = null;
    private OptionsUpgradeGruppe fkwaffen = null;
    private OptionsZaehlerGruppe bosseCC;
    private OptionsZaehlerGruppe bosseCC2;
    private OptionsZaehlerGruppe bosseFK;
    private boolean melee = false;
    private boolean range = false;
    private boolean souped = false;
    private boolean bigmek = false;
    private boolean meleeForRange = false;
    private boolean meleeForSouped = false;
    private boolean killsawFK = false;
    private boolean killsawNK = false;
    private boolean character = false;
    private boolean psyker = false;
    private boolean spanner = false;
    private boolean kaptin = false;
    private boolean warboss = false;
    private boolean boyboss = false;
    private boolean warbikerboss = false;
    private String defaultNK = "";
    private String defaultFK = "";
    private OptionsEinzelUpgrade daLuckyStikk;
    private OptionsEinzelUpgrade morgogsFinkinCap;
    private OptionsEinzelUpgrade rezmekkasRedderArmour;
    private OptionsEinzelUpgrade daFixxerUpperz;
    private OptionsEinzelUpgrade broggsBuzzbom;
    private OptionsEinzelUpgrade daBadskullBanner;
    private OptionsEinzelUpgrade gitstoppaShells;
    private OptionsEinzelUpgrade tezdreksStompaPowerField;
    private OptionsEinzelUpgrade skargrimsSnazztrike;
    private OptionsEinzelUpgrade daBlitzShouta;
    
    static final Set<String> CHARACTERS = ImmutableSet.of("Warboss", "Deffkilla Wartrike", "Big Mek in Mega Armour", "Big Mek with Shokk Attack Gun", "Weirdboy", "Warboss in Mega Armour", "Warboss on Warbike", "Big Mek", "Big Mek on Warbike");
    static final Set<String> PSYKERS = ImmutableSet.of("Weirdboy");
    
    //
    boolean bigChoppaNK = false;
    boolean powerKlawNK = false;
    boolean kustomShootaNK = false;
    boolean kombiNK = false;

    boolean bigChoppaFK = false;
    boolean powerKlawFK = false;
    boolean kustomShootaFK = false;
    boolean kombiFK = false;

    public ORWaffenUndGeschenke() {
        grundkosten = 0;
    }

    @Override
	public void setDefaultCloceCombat(String s) {
        defaultNK = s;
    }

    @Override
	public void setDefaultRanged(String s) {
        defaultFK = s;
    }

    public void setKillsawFK(boolean b) {
        killsawFK = b;
    }

    public void setKillsawNK(boolean b) {
        killsawNK = b;
    }

    public void setSpanner(boolean b) {
        spanner = b;
    }

    public void setKaptin(boolean b) {
        kaptin = b;
    }

    public void setWarboss(boolean b) {
        warboss = b;
    }

    public void setBoyBoss(boolean b) {
        boyboss = b;
    }

    public void setWarbikerBoss(boolean b) {
        warbikerboss = b;
    }

    @Override
    public void initButtons(boolean... defaults) {
        try {
            melee = defaults[0];
            range = defaults[1];
            souped = defaults[2];
            bigmek = defaults[3];
            meleeForRange = defaults[4];
            meleeForSouped = defaults[5];
            //character = defaults[6];
            //psyker = defaults[7];
        } catch (final Exception e) {
        }

        character = CHARACTERS.contains(name);
        psyker = PSYKERS.contains(name);
        
        if (character) {
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Super Cyborg Body", 0).setRelic(true));
            add(daLuckyStikk = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Da Lucky Stikk", 0).setRelic(true));
            add(morgogsFinkinCap = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Morgogs Finkin Cap", 0).setRelic(true));
            add(rezmekkasRedderArmour = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rezmekkas Redder Armour", 0).setRelic(true));
            add(daFixxerUpperz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Da Fixxer Upperz", 0).setRelic(true));
            add(broggsBuzzbom = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Broggs Buzzbom", 0).setRelic(true));
            add(daBadskullBanner = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Da Badskull Banner", 0).setRelic(true));
            add(tezdreksStompaPowerField = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Tezdrek's Stompa Power Field", 0).setRelic(true));
            add(skargrimsSnazztrike = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Skargrim's Snazztrik", 0).setRelic(true));
            add(daBlitzShouta = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Da Blitz Shouta", 0).setRelic(true));
            
            if (psyker) {
                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Scorched Gitbonez", 0).setRelic(true));
            }
            add(gitstoppaShells = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Gitstoppa Shells", 0).setRelic(true));
            seperator();
        }

        if (!defaultFK.equals("no weapon")) {
            if (defaultFK.equals("")) {
                ogE.addElement(new OptionsGruppeEintrag("Slugga", getPts("Slugga")));
            } else if (defaultFK.equals("Kombi-weapon with rokkit-launcha")) {
                ogE.addElement(new OptionsGruppeEintrag("Kombi-rokkit", "Kombi-weapon with rokkit-launcha", getPts("Kombi-weapon with rokkit-launcha")));
                kombiFK = true;
            } else {
                ogE.addElement(new OptionsGruppeEintrag(defaultFK, getPts(defaultFK)));
                if (defaultFK.equals("Kustom shoota")) {
                    kustomShootaFK = true;
                }
            }
        }
        if (souped) {
            if (!defaultFK.equals("Kombi-weapon with rokkit-launcha")) {
                ogE.addElement(new OptionsGruppeEintrag("Kombi-rokkit", "Kombi-weapon with rokkit-launcha", getPts("Kombi-weapon with rokkit-launcha")));
            }
            ogE.addElement(new OptionsGruppeEintrag("Kustom mega-blasta", getPts("Kustom mega-blasta")));
            ogE.addElement(new OptionsGruppeEintrag("Rokkit launcha", getPts("Rokkit launcha")));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-skorcha", "Kombi-weapon with skorcha", getPts("Kombi-weapon with skorcha")));
            ogE.addElement(new OptionsGruppeEintrag("Kustom mega-slugga", getPts("Kustom mega-slugga")));
            kombiFK = true;
        }
        if (range) {
            ogE.addElement(new OptionsGruppeEintrag("Shoota", getPts("Shoota")));
            if (defaultFK != "Kustom shoota") {
                ogE.addElement(new OptionsGruppeEintrag("Kustom shoota", getPts("Kustom shoota")));
            }
            if (!defaultFK.equals("Kombi-weapon with rokkit-launcha")) {
                ogE.addElement(new OptionsGruppeEintrag("Kombi-rokkit", "Kombi-weapon with rokkit-launcha", getPts("Kombi-weapon with rokkit-launcha")));
            }
            ogE.addElement(new OptionsGruppeEintrag("Kombi-skorcha", "Kombi-weapon with skorcha", getPts("Kombi-weapon with skorcha")));
            kombiFK = true;
            kustomShootaFK = true;
        }
        if (meleeForRange) {
            ogE.addElement(new OptionsGruppeEintrag("Power klaw", getPts("Power klaw")));
            ogE.addElement(new OptionsGruppeEintrag("Big choppa", getPts("Big choppa")));
            powerKlawFK = true;
            bigChoppaFK = true;
        }
        if (name.equals("Big Mek with Shokk Attack Gun")) {
           	ogE.addElement(new OptionsGruppeEintrag("Da Souped-Up Shokka", getPts("Shokk attack gun")));
        }
        if (killsawFK) {
            ogE.addElement(new OptionsGruppeEintrag("Killsaw", getPts("Killsaw")));
        }
        if (kaptin) {
            ogE.addElement(new OptionsGruppeEintrag("Choppa", getPts("Choppa")));
            ogE.addElement(new OptionsGruppeEintrag("Slugga", getPts("Slugga")));
        }
        if (spanner) {
            ogE.addElement(new OptionsGruppeEintrag("Rokkit launcha", getPts("Rokkit launcha")));
            ogE.addElement(new OptionsGruppeEintrag("Big shoota", getPts("Big shoota")));
        }
        if (warboss) {
            ogE.addElement(new OptionsGruppeEintrag("Kombi-skorcha", "Kombi-weapon with skorcha", getPts("Kombi-weapon with skorcha")));
            ogE.addElement(new OptionsGruppeEintrag("Kustom shoota", getPts("Kustom shoota")));
            kustomShootaFK = true;
            kombiFK = true;
        }
        if (ogE.size() > 0) {
            if (character) { //Artefakte eintragen, die gegen andere Ausrüstung getauscht werden.
                if (kustomShootaFK) {
                    ogE.addElement(new OptionsGruppeEintrag("Da Ded Shiny Shoota", getPts("Kustom shoota")).setRelic(true)); //Kustom Shoota
                    ogE.addElement(new OptionsGruppeEintrag("Da Gobshot Thunderbuss", getPts("Kustom shoota")).setRelic(true)); //Kustom Shoot oder kombi
                } else if (kombiFK) {
                    ogE.addElement(new OptionsGruppeEintrag("Da Gobshot Thunderbuss", getPts("Kombi-weapon with rokkit-launcha")).setRelic(true)); //Kustom Shoot oder kombi
                }
                if (bigChoppaFK) {
                    ogE.addElement(new OptionsGruppeEintrag("Headwoppa's Killchoppa", getPts("Big choppa")).setRelic(true));
                }
                if (powerKlawFK) {
                    ogE.addElement(new OptionsGruppeEintrag("Da Killa Klaw", getPts("Power klaw")).setRelic(true));
                }
            }

            add(fkwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            if (!defaultFK.equals("no weapon")) {
                fkwaffen.setSelected(0, true);
            }
        }

        seperator();

        if (!defaultNK.equals("no weapon")) {
            if (defaultNK.equals("")) {
                ogE.addElement(new OptionsGruppeEintrag("Choppa", getPts("Choppa")));
            } else {
                ogE.addElement(new OptionsGruppeEintrag(defaultNK, getPts(defaultNK)));
                if (defaultNK.equals("Power klaw")) {
                    powerKlawNK = true;
                }
                if (defaultNK.equals("Big choppa")) {
                    bigChoppaNK = true;
                }
            }
        }
        if (meleeForSouped) {
            ogE.addElement(new OptionsGruppeEintrag("Kombi-rokkit", "Kombi-weapon with rokkit-launcha", getPts("Kombi-weapon with rokkit-launcha")));
            ogE.addElement(new OptionsGruppeEintrag("Kustom mega-blasta", getPts("Kustom mega-blasta")));
            ogE.addElement(new OptionsGruppeEintrag("Rokkit launcha", getPts("Rokkit launcha")));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-skorcha", "Kombi-weapon with skorcha", getPts("Kombi-weapon with skorcha")));
            if (!defaultNK.equals("Kustom mega-slugga")) {
                ogE.addElement(new OptionsGruppeEintrag("Kustom mega-slugga", getPts("Kustom mega-slugga")));
            }
            kombiNK = true;
        }
        if (melee) {
            if (!defaultNK.equals("Power klaw")) {
                ogE.addElement(new OptionsGruppeEintrag("Power klaw", getPts("Power klaw")));
            }
            if (defaultNK != "Big choppa") {
                ogE.addElement(new OptionsGruppeEintrag("Big choppa", getPts("Big choppa")));
            }
            powerKlawNK = true;
            bigChoppaNK = true;
        }
        if (killsawNK) {
            ogE.addElement(new OptionsGruppeEintrag("Killsaw", getPts("Killsaw")));
        }

        if (ogE.size() > 0) {
            if (character) { //Artefakte eintragen, die gegen andere Ausrüstung getauscht werden.
                if (kustomShootaNK) {
                    ogE.addElement(new OptionsGruppeEintrag("Da Ded Shiny Shoota", getPts("Kustom shoota")).setRelic(true)); //Kustom Shoota
                    ogE.addElement(new OptionsGruppeEintrag("Da Gobshot Thunderbuss", getPts("Kustom shoota")).setRelic(true)); //Kustom Shoot oder kombi
                } else if (kombiNK) {
                    ogE.addElement(new OptionsGruppeEintrag("Da Gobshot Thunderbuss", getPts("Kombi-weapon with rokkit-launcha")).setRelic(true)); //Kustom Shoot oder kombi
                }
                if (bigChoppaNK) {
                    ogE.addElement(new OptionsGruppeEintrag("Headwoppa's Killchoppa", getPts("Big choppa")).setRelic(true));
                }
                if (powerKlawNK) {
                    ogE.addElement(new OptionsGruppeEintrag("Da Killa Klaw", getPts("Power klaw")).setRelic(true));
                }
            }

            add(handwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            if (!defaultNK.equals("no weapon")) {
                handwaffen.setSelected(0, true);
            }
        }

        if (kaptin) {
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Gitfinda squig", getPts("Gitfinda squig")));
        }

        if (boyboss || warbikerboss) {
            ogE.addElement(new OptionsGruppeEintrag("Choppa", getPts("Choppa")));
            ogE.addElement(new OptionsGruppeEintrag("Killsaw", getPts("Killsaw")));
            ogE.addElement(new OptionsGruppeEintrag("Power stabba", getPts("Power stabba")));
            ogE.addElement(new OptionsGruppeEintrag("Power klaw", getPts("Power klaw")));
            ogE.addElement(new OptionsGruppeEintrag("Big choppa", getPts("Big choppa")));
            ogE.addElement(new OptionsGruppeEintrag("Slugga", getPts("Slugga")));
            add(bosseCC = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
            bosseCC.setAnzahl(0, 1);
            bosseCC.setAnzahl(5, 1);

            seperator(5);

            ogE.addElement(new OptionsGruppeEintrag("2 Killsaws", getPts("Two killsaws")));
            add(bosseCC2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator(5);

            if (!warbikerboss) {
                ogE.addElement(new OptionsGruppeEintrag("Kombi-rokkit", "Kombi-weapon with rokkit-launcha", getPts("Kombi-weapon with rokkit-launcha")));
                ogE.addElement(new OptionsGruppeEintrag("Kombi-skorcha", "Kombi-weapon with skorcha", getPts("Kombi-weapon with skorcha")));
                ogE.addElement(new OptionsGruppeEintrag("Shoota [Index]", getPts("Shoota")));
                ogE.addElement(new OptionsGruppeEintrag("Kustom shoota [Index]", getPts("Kustom shoota")));
                add(bosseFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
            }
        }

        seperator();

        setUeberschrift("Waffen");
        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!defaultFK.equals("no weapon") && !fkwaffen.isSelected()) {
            fkwaffen.alwaysSelected();
        }
        if (!defaultNK.equals("no weapon") && !handwaffen.isSelected()) {
            handwaffen.alwaysSelected();
        }

        if (character) {
            daLuckyStikk.setAktiv((chosenRelic == null || daLuckyStikk.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Goff"));
            morgogsFinkinCap.setAktiv((chosenRelic == null || morgogsFinkinCap.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Blood Axe"));
            rezmekkasRedderArmour.setAktiv((chosenRelic == null || rezmekkasRedderArmour.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Evil Sunz"));
            daFixxerUpperz.setAktiv((chosenRelic == null || daFixxerUpperz.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Deathskulls"));
            broggsBuzzbom.setAktiv((chosenRelic == null || broggsBuzzbom.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Snakebites"));
            daBadskullBanner.setAktiv((chosenRelic == null || daBadskullBanner.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Freebooterz"));
            tezdreksStompaPowerField.setAktiv((chosenRelic == null || tezdreksStompaPowerField.isSelected()) && BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("Stompa Mob"));
            skargrimsSnazztrike.setAktiv((chosenRelic == null || skargrimsSnazztrike.isSelected()) && BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("Kult of Speed"));
            daBlitzShouta.setAktiv((chosenRelic == null || daBlitzShouta.isSelected()) && BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("Blitz Brigade"));
            
            if (fkwaffen != null) {
                fkwaffen.setAktiv("Da Gobshot Thunderbuss", (chosenRelic == null || fkwaffen.isSelected("Da Gobshot Thunderbuss")) && BuildaHQ.aktBuildaVater.getFormationType().equals("Bad Moonz"));
                fkwaffen.setAktiv("Da Souped-Up Shokka", (chosenRelic == null || fkwaffen.isSelected("Da Souped-Up Shokka")) && BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("Dread Waaagh"));
            }
            if (handwaffen != null) {
                handwaffen.setAktiv("Da Gobshot Thunderbuss", (chosenRelic == null || handwaffen.isSelected("Da Gobshot Thunderbuss")) && BuildaHQ.aktBuildaVater.getFormationType().equals("Bad Moonz"));
            }

            final boolean nkGitstoppa = handwaffen != null && (handwaffen.isSelected("Kombi-weapon with rokkit-launcha") || handwaffen.isSelected("Kombi-weapon with skorcha") || handwaffen.isSelected("Kustom shoota"));
            final boolean fkGitstoppa = fkwaffen != null && (fkwaffen.isSelected("Kombi-weapon with rokkit-launcha") || fkwaffen.isSelected("Kombi-weapon with skorcha") || fkwaffen.isSelected("Kustom shoota"));

            gitstoppaShells.setAktiv((chosenRelic == null || gitstoppaShells.isSelected()) && (nkGitstoppa || fkGitstoppa));
        }

        if (boyboss) {
            bosseCC2.setMaxAnzahl(bosseFK.isSelected() || bosseCC.isSelected() ? 0 : 1);
            bosseCC.setMaxAnzahl(2 - bosseFK.getAnzahl() - bosseCC2.getAnzahl() * 2);
            bosseFK.setMaxAnzahl(bosseCC2.isSelected() || bosseCC.getAnzahl() == 2 ? 0 : 1);
        } else if (warbikerboss) {
            bosseCC2.setMaxAnzahl(bosseCC.isSelected() ? 0 : 1);
            bosseCC.setMaxAnzahl(bosseCC2.isSelected() ? 0 : 2);
        }
    }
}
