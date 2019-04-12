package oc.wh40k.units.ta;

import static oc.KeyWord.BATTLESUIT;
import static oc.KeyWord.COMMANDER;
import static oc.KeyWord.ETHEREAL;
import static oc.KeyWord.FLY;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import oc.BuildaHQ;
import oc.KeyWord;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerVater;

public class TAKampfanzugKammer extends RuestkammerVater {

    public boolean uniqueError = false;
    private OptionsZaehlerGruppe o1;
    private OptionsUpgradeGruppe o2;
    private OptionsZaehlerGruppe o4;
    public OptionsUpgradeGruppe o5, o6/*, o7*/;
    private boolean XV08 = false;
    private boolean XV81 = false;
    private boolean XV84 = false;
    public boolean farsight = false;
    private boolean droneSelected = false;

    private OptionsEinzelUpgrade puretideEngramNeurochip;
    private OptionsEinzelUpgrade onagerGauntlet;
    private OptionsEinzelUpgrade multiSensoryDiscouragementArray;
    private OptionsEinzelUpgrade solidImageProjectionUnit;
    private OptionsEinzelUpgrade seismicDestabiliser;
    private OptionsEinzelUpgrade vectoredManoeuvringThrusters;
    private OptionsEinzelUpgrade dynamicMirrorField;
    private OptionsEinzelUpgrade gravInhibitorField;

    public TAKampfanzugKammer() {
        grundkosten = 25;
    }

    static final Set<String> CHARACTERS = ImmutableSet.of("");

    public void addRelics() {

    	for(int i = 0; i < ogE.size(); i++) {

    		if(ogE.get(i).getName().equals("Airbursting fragmentation projector")){
    			ogE.addElement(new OptionsGruppeEintrag("Supernova Launcher", getPts("Airbursting fragmentation projector")).setRelic(true));
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Vior'la Sept"))
    		{
	    		if(ogE.get(i).getName().equals("Flamer")){
	    			ogE.addElement(new OptionsGruppeEintrag("Thermoneutronic Projector", getPts("Flamer")).setRelic(true));
	    		}
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Bork'an Sept"))
    		{
	    		if(ogE.get(i).getName().equals("Plasma rifle")){
	    			ogE.addElement(new OptionsGruppeEintrag("Plasma Accelerator Rifle", getPts("Plasma rifle")).setRelic(true));
	    		}
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Farsight Enclaves"))
    		{
	    		if(ogE.get(i).getName().equals("Fusion blaster")){
	    			ogE.addElement(new OptionsGruppeEintrag("Fusion Blades", getPts("Fusion blaster")).setRelic(true));
	    		}
    		}
    	}
    }

    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();
        int offsetX = randAbstand;
        add(puretideEngramNeurochip = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Puretide Engram Neurochip", 0).setRelic(true));
       	add(onagerGauntlet = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Onager Gauntlet", 0).setRelic(true));
       	add(multiSensoryDiscouragementArray = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multi-Sensory Discouragement Array", 0).setRelic(true));
       	add(solidImageProjectionUnit = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Solid-Image Projection Unit", 0).setRelic(true));
       	add(seismicDestabiliser = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Seismic Destabilisier", 0).setRelic(true));
       	add(vectoredManoeuvringThrusters = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vectored Manoeuvring Thrusters", 0).setRelic(true));
       	add(dynamicMirrorField = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dynamic Mirror Field", 0).setRelic(true));
       	add(gravInhibitorField = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grav-Inhibitor Field", 0).setRelic(true));

       	offsetX += buttonBreite + 15;
       	seperator();

        // Fernkampfwaffen
        if (type.equals("Broadside")) {
            ogE.addElement(new OptionsGruppeEintrag("Heavy rail rifle", getPts("Heavy rail rifle")));
            ogE.addElement(new OptionsGruppeEintrag("2 High-yield missile pods", getPts("High-yield missile pod") * 2));
            add(o5 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o5.setSelected(0, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Smart missile systems", getPts("Smart missile system") * 2));
            ogE.addElement(new OptionsGruppeEintrag("2 Plasma rifles", getPts("Plasma rifle") * 2));
            add(o6 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o6.setSelected(0, true);

            seperator();

            add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Seeker missile", getPts("Seeker missile")));
        } else if (type.equals("Stealth Shas'ui")) {
            ogE.addElement(new OptionsGruppeEintrag("Burst cannon", getPts("Burst cannon")));
            ogE.addElement(new OptionsGruppeEintrag("Fusion blaster", getPts("Fusion blaster")));
            add(o5 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));
        } else if (type.equals("Ghostkeel Shas'vre")) {
            ogE.addElement(new OptionsGruppeEintrag("Fusion collider", getPts("Fusion collider")));
            ogE.addElement(new OptionsGruppeEintrag("Cyclic ion raker", getPts("Cyclic ion raker")));
            add(o5 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o5.setSelected(0, true);

            ogE.addElement(new OptionsGruppeEintrag("2 Flamer", getPts("Flamer") * 2));
            ogE.addElement(new OptionsGruppeEintrag("2 Burst cannons", getPts("Burst cannon") * 2));
            ogE.addElement(new OptionsGruppeEintrag("2 Fusion blaster", getPts("Fusion blaster") * 2));
            add(o6 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o6.setSelected(0, true);
        } else if(!type.equals("Ethereal") && !type.equals("Cadre Fireblade")){
            ogE.addElement(new OptionsGruppeEintrag("Airbursting fragmentation projector", getPts("Airbursting fragmentation projector")));
            ogE.addElement(new OptionsGruppeEintrag("Burst cannon", getPts("Burst cannon")));
            ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer")));
            ogE.addElement(new OptionsGruppeEintrag("Fusion blaster", getPts("Fusion blaster")));
            ogE.addElement(new OptionsGruppeEintrag("Missile pod", getPts("Missile pod")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma rifle", getPts("Plasma rifle")));
            if (keywords.contains(KeyWord.XV86_COLDSTAR)) {
                ogE.addElement(new OptionsGruppeEintrag("High-output burst cannon", getPts("High-output burst cannon")));
            } else {
                ogE.addElement(new OptionsGruppeEintrag("Cyclic ion blaster", getPts("Cyclic ion blaster")));
            }
            addRelics();
            add(o1 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 1));
            if (type.equals("Commander")) {
                o1.setMaxAnzahl(4);
                if (keywords.contains(KeyWord.XV86_COLDSTAR)) {
                	o1.setAnzahl(4, 1);
                	o1.setAnzahl(6, 1);
                } else {
                	o1.setAnzahl(1, 1);
                	o1.setAnzahl(4, 1);
                }
            } else {
            	o1.setAnzahl(1, 1);
            }

            seperator();
        }

        seperator();

        // Unterstützungssysteme
        if (type.equals("Ghostkeel Shas'vre")) {
            ogE.addElement(new OptionsGruppeEintrag("Advanced targeting system", getPts("Advanced targeting system (Ghostkeel Riptide and Stormsurge)")));
            ogE.addElement(new OptionsGruppeEintrag("Counterfire defence system", getPts("Counterfire defence system")));
            ogE.addElement(new OptionsGruppeEintrag("Drone controller", getPts("Drone controller")));
            ogE.addElement(new OptionsGruppeEintrag("Early warning override", getPts("Early warning override (Ghostkeel Riptide and Stormsurge)")));
            ogE.addElement(new OptionsGruppeEintrag("Multi-tracker", getPts("Multi-tracker")));
            ogE.addElement(new OptionsGruppeEintrag("Shield generator", getPts("Shield generator (all other models)")));
            ogE.addElement(new OptionsGruppeEintrag("Target lock", getPts("Target lock (Ghostkeel Riptide and Stormsurge)")));
            ogE.addElement(new OptionsGruppeEintrag("Velocity tracker", getPts("Velocity tracker (Ghostkeel Riptide and Stormsurge)")));
        } else {
            ogE.addElement(new OptionsGruppeEintrag("Advanced targeting system", getPts("Advanced targeting system (all other models)")));
            ogE.addElement(new OptionsGruppeEintrag("Counterfire defence system", getPts("Counterfire defence system")));
            ogE.addElement(new OptionsGruppeEintrag("Drone controller", getPts("Drone controller")));
            ogE.addElement(new OptionsGruppeEintrag("Early warning override", getPts("Early warning override (all other models)")));
            ogE.addElement(new OptionsGruppeEintrag("Multi-tracker", getPts("Multi-tracker")));
            ogE.addElement(new OptionsGruppeEintrag("Shield generator", getPts("Shield generator (all other models)")));
            ogE.addElement(new OptionsGruppeEintrag("Target lock", getPts("Target lock (all other units)")));
            ogE.addElement(new OptionsGruppeEintrag("Velocity tracker", getPts("Velocity tracker (all other units)")));
        }

        if(!type.equals("Ethereal") && !type.equals("Cadre Fireblade"))
        {
        	addRelics();
        	add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

	        if (type.equals("Commander")) {
	            o2.setMaxAmount(4);
	        }

	        if (type.equals("Ghostkeel Shas'vre")) {
	            o2.setMaxAmount(2);
	        }
        }

        seperator();

        cnt = randAbstand;

        seperator();

        if (type.equals("Commander")) {
            ogE.clear();
            ogE.addElement(new OptionsGruppeEintrag("MV1 Gun Drone", getPts("MV1 Gun Drone")));
            ogE.addElement(new OptionsGruppeEintrag("MV4 Shield Drone", getPts("MV4 Shield Drone")));
            ogE.addElement(new OptionsGruppeEintrag("MV7 Marker Drone", getPts("MV7 Marker Drone")));
            add(o4 = new OptionsZaehlerGruppe(0, randAbstand + 280, cnt, "", ogE, 2));
        }

        if(o1 != null) {
        	o1.getPanel().setLocation(offsetX, 10);
	       	offsetX += buttonBreite + 20;
        }

        if(o2 != null) {
        	o2.getPanel().setLocation(offsetX, 10);
	       	offsetX += buttonBreite + 20;
        }

        if(o4 != null) {
        	o4.getPanel().setLocation(offsetX, 10);
        	offsetX += buttonBreite + 20;
        }

        if(o5 != null) {
        	o5.getPanel().setLocation(offsetX, 10);
        }

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!type.equals("Broadside") && !type.equals("Stealth Shas'ui") && !type.equals("Ghostkeel Shas'vre")) {

        } else if (type.equals("Stealth Shas'ui")) {
            if (!o5.isSelected()) {
                o5.setSelected(0, true);
            }
        } else if (type.equals("Broadside") || type.equals("Ghostkeel Shas'vre")) {

            if (!o5.isSelected()) {
                o5.setSelected(0, true);
            }
            if (!o6.isSelected()) {
                o6.setSelected(0, true);
            }
        }

        if (type.equals("Commander") && !keywords.contains(KeyWord.XV86_COLDSTAR)) {
            o1.setAktiv(true);
            o2.setMaxAmount(4);
            final int selected = o1.getAnzahl() + o2.getAnzahl();
            final int remaining = 4 - selected;
            o1.setMaxAnzahl(o1.getAnzahl() + remaining);
            o2.setMaxAmount(o2.getAnzahl() + remaining);
            o1.setLegal(o1.getAnzahl() + o2.getAnzahl() >= 2);
            o2.setLegal(o1.getAnzahl() + o2.getAnzahl() >= 2);
        }

        if (type.equals("Commander") && keywords.contains(KeyWord.XV86_COLDSTAR)) {
            o1.setAktiv(true);
            o2.setMaxAmount(2);
            final int selected = o2.getAnzahl() + o1.getAnzahl();
            final int remaining = 4 - selected;
            o1.setMaxAnzahl(o1.getAnzahl() + remaining);
            o2.setMaxAmount(o2.getAnzahl() + remaining);
            o1.setLegal(o1.getAnzahl() + o2.getAnzahl() >= 2);
            o2.setLegal(o1.getAnzahl() + o2.getAnzahl() >= 2);
        }

        if (type.equals("Crisis Shas'ui")) {
            final int selected = o1.getAnzahl() + o2.getAnzahl();
            final int remaining = 3 - selected;
            o1.setMaxAnzahl(o1.getAnzahl() + remaining);
            o2.setMaxAmount(o2.getAnzahl() + remaining);

            o1.setLegal(o1.getAnzahl() + o2.getAnzahl() >= 1);
            o2.setLegal(o1.getAnzahl() + o2.getAnzahl() >= 1);
        }

        if (type.equals("Crisis Shas'vre")) {
            final int selected = o1.getAnzahl() + o2.getAnzahl();
            final int remaining = 3 - selected;
            o1.setMaxAnzahl(o1.getAnzahl() + remaining);
            o2.setMaxAmount(o2.getAnzahl() + remaining);

            o1.setLegal(o1.getAnzahl() + o2.getAnzahl() >= 1);
            o2.setLegal(o1.getAnzahl() + o2.getAnzahl() >= 1);
        }

        if (type.equals("Crisis Bodyguard")) {
            final int selected = o1.getAnzahl() + o2.getAnzahl();
            final int remaining = 3 - selected;
            o1.setMaxAnzahl(o1.getAnzahl() + remaining);
            o2.setMaxAmount(o2.getAnzahl() + remaining);

            o1.setLegal(o1.getAnzahl() + o2.getAnzahl() >= 1);
            o2.setLegal(o1.getAnzahl() + o2.getAnzahl() >= 1);
        }

        if (type.equals("Stealth Shas'ui")) {
            o2.setMaxAmount(1);
        }

        if(o4 != null) {
        	droneSelected = o4.isSelected();
        }

        puretideEngramNeurochip.setAktiv((chosenRelic == null || puretideEngramNeurochip.isSelected()));
        onagerGauntlet.setAktiv(((chosenRelic == null || onagerGauntlet.isSelected()) && keywords.contains(BATTLESUIT) && keywords.contains(COMMANDER)));
        multiSensoryDiscouragementArray.setAktiv(chosenRelic == null || multiSensoryDiscouragementArray.isSelected());
        solidImageProjectionUnit.setAktiv((chosenRelic == null || solidImageProjectionUnit.isSelected()) && keywords.contains(ETHEREAL) && keywords.contains(FLY));
        seismicDestabiliser.setAktiv(chosenRelic == null || seismicDestabiliser.isSelected());
        vectoredManoeuvringThrusters.setAktiv((chosenRelic == null || vectoredManoeuvringThrusters.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("T'au Sept"));
        dynamicMirrorField.setAktiv((chosenRelic == null || dynamicMirrorField.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Dal'yth Sept"));
        gravInhibitorField.setAktiv((chosenRelic == null || gravInhibitorField.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Sa'cea Sept"));
    }


    @Override
    public void deleteYourself() {

        if (XV08 == true) {
            XV08 = false;
            BuildaHQ.addToInformationVectorGlobal("TAXV08", -1);
        }

        if (XV81 == true) {
            XV81 = false;
            BuildaHQ.addToInformationVectorGlobal("TAXV81", -1);
        }

        if (XV84 == true) {
            XV84 = false;
            BuildaHQ.addToInformationVectorGlobal("TAXV84", -1);
        }

        super.deleteYourself();
    }

    public void clearEntries() {
        boolean entryCleared = false;

        if (o1 != null && o1.isSelected()) {
            o1.setMaxAnzahl(0);
            entryCleared = true;
        }
        if (o4 != null && o4.isSelected()) {
            o4.setMaxAnzahl(0);
            entryCleared = true;
        }
        if (o5 != null && o5.isSelected()) {
            o5.deselectAll();
            entryCleared = true;
        }
        if (o6 != null && o6.isSelected()) {
            o6.deselectAll();
            entryCleared = true;
        }

        if (entryCleared) {
            RefreshListener.fireRefresh();
        }
    }

    public boolean dronesSelected() {
    	return droneSelected;
    }

}
