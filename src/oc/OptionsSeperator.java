package oc;import java.awt.event.MouseEvent;import org.w3c.dom.Element;public class OptionsSeperator extends OptionsVater{	public String getText(){return "";}	public String getSaveText(){return "";}                public Element getSaveElement() {return null;}	public void load(String s){}                public void loadElement(Element e) {}	public void setLegal(boolean b){}	public boolean isLegal(){return true;}	public double getKosten(){return 0;}	public boolean isSelected(){return false;}	public String getLabel(){return "";}	public void mouseReleased(MouseEvent event){}	private int h�he = 0;	public OptionsSeperator(int h�he){		this.h�he = h�he;}	@Override	public int getHoehe(){		return h�he;	}}