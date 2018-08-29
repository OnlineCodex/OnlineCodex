package oc;import java.awt.event.MouseEvent;import org.w3c.dom.Element;public class OptionsEinzelUpgrade extends OptionsVater {	private OptionsButtonUpgrade myUpgrade;	private boolean aktiv = true;	private boolean showKosten;	public boolean isShowKosten() {		return showKosten;	}	public void setShowKosten(boolean showKosten) {		this.showKosten = showKosten;	}	public double getKosten(){return myUpgrade.getKosten()*this.modelle;}	public void setPreis(double i){myUpgrade.setPreis(i);}	public void setSelected(boolean b){myUpgrade.setSelected(b);}	public void setAktiv(boolean b){		aktiv = b;		myUpgrade.setAktiv(b);}	public boolean isAktiv(){		return myUpgrade.isAktiv();}	public OptionsEinzelUpgrade (int ID, int lX, int lY,String verzierung ,String name, double preis){		konstruktorDerFuerAlleGilt(lX,lY,verzierung,name,preis);	}		public OptionsEinzelUpgrade (int ID, int lX, int lY,String verzierung ,String name, double preis, boolean showKosten){		konstruktorDerFuerAlleGilt(lX,lY,verzierung,name,preis,showKosten);	}	public OptionsEinzelUpgrade (int ID, int lX, int lY,String verzierung ,String name, double preis, int modelle){		konstruktorDerFuerAlleGilt(lX,lY,verzierung,name,preis);		this.modelle = modelle;		myUpgrade.setJeweils(true);	}	public OptionsEinzelUpgrade (int ID, int lX, int lY,String verzierung ,String name){		konstruktorDerFuerAlleGilt(lX,lY,verzierung,name,(double)-88);	}	public OptionsEinzelUpgrade (int ID, int lX, int lY,String verzierung, String kurzerName,String name, double preis){		konstruktorDerFuerAlleGilt(lX,lY,verzierung,name,preis);		myUpgrade.setKurzerName(kurzerName);	}	public OptionsEinzelUpgrade (int ID, int lX, int lY,String verzierung, String kurzerName,String name, double preis, int modelle){		konstruktorDerFuerAlleGilt(lX,lY,verzierung,name,preis);		this.modelle = modelle;		myUpgrade.setJeweils(true);		myUpgrade.setKurzerName(kurzerName);	}	public void konstruktorDerFuerAlleGilt(int lX, int lY,String verzierung ,String name, double preis){		myUpgrade = new OptionsButtonUpgrade(-88,0,0,verzierung,name,false,preis);		myUpgrade.getButton().addMouseListener(this);		panel = myUpgrade.getPanel();		panel.setLocation(lX,lY);	}	public void konstruktorDerFuerAlleGilt(int lX, int lY,String verzierung ,String name, double preis, boolean showKosten){		myUpgrade = new OptionsButtonUpgrade(-88,0,0,verzierung,name,false,preis,showKosten);		myUpgrade.getButton().addMouseListener(this);		panel = myUpgrade.getPanel();		panel.setLocation(lX,lY);				this.showKosten = showKosten;	}	public String getLabel(){		if(myUpgrade.isSelected()){return myUpgrade.getButton().getText()+ZEILENUMBRUCH;}		return "";}	//@OVERRIDE	public void mouseReleased(MouseEvent event)	{		if(!aktiv){return;}		myUpgrade.switsch();				RefreshListener.fireRefresh();	}	public boolean isSelected(){		return myUpgrade.isSelected();}	public void setLegal(boolean b){myUpgrade.setLegal(b);}	public boolean isLegal(){return myUpgrade.isLegal();}	public String getText(){		if(!aktiv){return "";}		StringBuilder text = new StringBuilder(BuildaHQ.abstand);		String kosten = "";				if(BuildaHQ.allePunktkosten){			if ( !isShowKosten() ) {							kosten = punkteAbstandHalter+entferneNullNachkomma(getKosten())+" "+BuildaHQ.translate("Pkt.");   // NET myUpgrade.getKosten() !!! das is was anderes!//				if(getKosten() == 0){//					kosten = punkteAbstandHalter+BuildaHQ.translate("kostenlos");//				}			}		}		text.append(BuildaHQ.anfang+myUpgrade.getName()+kosten);				return text.toString();	}	public void setToolTipText(String s){myUpgrade.getButton().setToolTipText(s);}	public String getSaveText(){		return (this.isSelected()? "y" : "n");	}                public Element getSaveElement() {            Element root = BuildaHQ.getNewXMLElement("Upgrade");            root.setAttribute("selected", Boolean.toString(isSelected()));                        return root;        }	public void load(String s){		this.setSelected(s.equals("y"));	}                public void loadElement(Element e) {                this.setSelected(Boolean.parseBoolean(e.getAttribute("selected")));        }}